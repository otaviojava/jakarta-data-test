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

import java.util.List;

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
     * Orders by the specified property name (defaults to ascending) {@link Direction#ASC}.
     * @param property The property name to order by
     * @return A new sort with the order applied
     * @throws NullPointerException when property is null
     */
    Sort order(String property);

    /**
     * Orders by the specified property name and direction.
     * @param property The property name to order by
     * @param direction Either "asc" for ascending or "desc" for descending
     * @return A new sort with the order applied
     * @throws NullPointerException when there is null parameter
     */
    Sort order(String property, Direction direction);

    /**
     * @return The order definitions for this sort.
     */
    List<Order> getOrderBy();
}
