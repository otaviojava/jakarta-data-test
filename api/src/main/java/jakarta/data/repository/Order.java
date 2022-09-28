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

import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.BiFunction;

/**
 * PropertyPath implements the pairing of an {@link Direction} and a property. It is used to provide input for Sort
 */
public interface Order {

    /**
     * @return The direction order by
     */
    Direction getDirection();

    /**
     * @return The property name to order by
     */
    String getProperty();

    /**
     * @return Returns whether sorting for this property shall be ascending.
     */
    boolean isAscending();

    /**
     * @return Returns whether sorting for this property shall be descending.
     */
    boolean isDescending();


    static <O extends Order> O of(String property, Direction direction) {
        Objects.requireNonNull(property, "property is required");
        Objects.requireNonNull(direction, "direction is required");

        OrderSupplier<O> supplier =
        ServiceLoader.load(OrderSupplier.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no implementation of OrderSupplier on the class-load"));
        return supplier.apply(property, direction);
    }
    interface OrderSupplier<O extends Order> extends BiFunction<String, Direction, O>{}

}
