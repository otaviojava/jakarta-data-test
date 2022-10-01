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

final class DefaultSort implements Sort {

    private final String property;

    private final Direction direction;

    private DefaultSort(String property, Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    @Override
    public String getProperty() {
        return property;
    }

    @Override
    public boolean isAscending() {
        return Direction.ASC.equals(direction);
    }

    @Override
    public boolean isDescending() {
        return Direction.DESC.equals(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultSort that = (DefaultSort) o;
        return Objects.equals(property, that.property) && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, direction);
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "property='" + property + '\'' +
                ", direction=" + direction +
                '}';
    }

    static Sort of(String property, Direction direction) {
        return new DefaultSort(property, direction);
    }
}
