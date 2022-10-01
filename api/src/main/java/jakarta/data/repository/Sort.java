/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *  SPDX-License-Identifier: Apache-2.0
 */

package jakarta.data.repository;

import jakarta.data.DataException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * Sort option for queries.
 * Sorted instances are immutable and all mutating operations on this interface return a new instance.
 */
public interface Sort {

    /**
     * Adds an order object.
     *
     * @param order The order object
     * @return A new sort with the order applied
     * @throws NullPointerException when order is null
     */
    Sort order(Order order);

    /**
     * Returns a new Sort consisting of the Sort.Orders of the current Sort combined with the given ones.
     *
     * @param sort The sort
     * @return A new sort with the order applied
     * @throws NullPointerException when sort is null
     */
    Sort add(Sort sort);

    /**
     * Orders by the specified property name (defaults to ascending) {@link Direction#ASC}.
     *
     * @param property The property name to order by
     * @return A new sort with the order applied
     * @throws NullPointerException when property is null
     */
    Sort order(String property);

    /**
     * Orders by the specified property name and direction.
     *
     * @param property  The property name to order by
     * @param direction Either "asc" for ascending or "desc" for descending
     * @return A new sort with the order applied
     * @throws NullPointerException when there is null parameter
     */
    Sort order(String property, Direction direction);

    /**
     * @return The order definitions for this sort.
     */
    List<Order> getOrderBy();

    /**
     * Returns whether the current {@link Sort#getOrderBy()} is empty.
     *
     * @return the  {@link Sort#getOrderBy()} is empty.
     */
    boolean isEmpty();

    /**
     * Create a {@link Sort} instance
     *
     * @param property  the property name to order by
     * @param direction The direction order by
     * @return an {@link Sort} instance
     * @throws NullPointerException when there are null parameter
     */
    static Sort of(String property, Direction direction) {
        Objects.requireNonNull(property, "property is required");
        Objects.requireNonNull(direction, "direction is required");

        SortSupplier supplier =
                ServiceLoader.load(SortSupplier.class)
                        .findFirst()
                        .orElseThrow(() -> new DataException("There is no implementation of SortSupplier on the Class Loader"));
        return supplier.apply(Collections.singletonList(Order.of(property, direction)));
    }

    /**
     * Create a {@link Sort} instance on ascending direction {@link  Direction#ASC}
     *
     * @param property the property name to order by
     * @return an {@link Sort} instance
     * @throws NullPointerException when property is null
     */
    static Sort asc(String property) {
        return of(property, Direction.ASC);
    }

    /**
     * Create a {@link Sort} instance on descending direction {@link  Direction#DESC}
     *
     * @param property the property name to order by
     * @return an {@link Sort} instance
     * @throws NullPointerException when property is null
     */
    static Sort desc(String property) {
        return of(property, Direction.DESC);
    }

    /**
     * Creates a new Sort for the given Orders
     *
     * @param orders an order list
     * @return The sort
     * @throws NullPointerException when orders is null
     */
    static Sort of(Iterable<Order> orders) {
        Objects.requireNonNull(orders, "orders is required");
        SortSupplier supplier =
                ServiceLoader.load(SortSupplier.class)
                        .findFirst()
                        .orElseThrow(() -> new DataException("There is no implementation of IterableSortSupplier" +
                                " on the Class Loader"));
        return supplier.apply(orders);
    }

    /**
     * Creates a new Sort for the given Orders
     *
     * @param orders an order list
     * @return The sort
     */
    static Sort of(Order... orders) {
        return of(List.of(orders));
    }


    /**
     * The {@link Sort} supplier that the API will use on the method {@link Sort#of(String, Direction)}
     *
     */
    interface SortSupplier extends Function<Iterable<Order>, Sort> {
    }
}
