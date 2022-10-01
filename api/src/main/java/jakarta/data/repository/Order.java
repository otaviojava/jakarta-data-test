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

/**
 * Order implements the pairing of an {@link Direction} and a property. It is used to provide input for Sort
 */
public interface Order {


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


    /**
     * Create a {@link Order} instance
     * @param property the property name to order by
     * @param direction The direction order by
     * @return an {@link Order} instance
     * @throws NullPointerException when there are null parameter
     */
    static Order of(String property, Direction direction) {
        Objects.requireNonNull(property, "property is required");
        Objects.requireNonNull(direction, "direction is required");
        return DefaultOrder.of(property, direction);
    }

    /**
     * Create a {@link Order} instance on ascending direction {@link  Direction#ASC}
     * @param property the property name to order by
     * @return the Order type
     * @return an {@link Order} instance
     * @throws NullPointerException when there property is null
     */
    static Order asc(String property){
        return of(property, Direction.ASC);
    }
    /**
     * Create a {@link Order} instance on descending direction {@link  Direction#DESC}
     * @param property the property name to order by
     * @return the Order type
     * @return an {@link Order} instance
     * @throws NullPointerException when there property is null
     */
    static Order desc(String property){
        return of(property, Direction.DESC);
    }

}
