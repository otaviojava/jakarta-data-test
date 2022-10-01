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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class DefaultSort implements Sort {

    private final List<Order> orders;

    DefaultSort() {
        this.orders = new ArrayList<>();
    }

    DefaultSort(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Sort order(Order order) {
        Objects.requireNonNull(order, "order is required");
        return new DefaultSort(new ArrayList<>(orders) {{
            this.add(order);
        }});
    }

    @Override
    public Sort add(Sort sort) {
        Objects.requireNonNull(sort, "sort is required");
        return new DefaultSort(new ArrayList<>(orders) {{
            this.addAll(sort.getOrderBy());
        }});
    }

    @Override
    public Sort order(String property) {
        Objects.requireNonNull(property, "property is required");
        return order(Order.asc(property));
    }

    @Override
    public Sort order(String property, Direction direction) {
        Objects.requireNonNull(property, "property is required");
        Objects.requireNonNull(direction, "direction is required");
        return order(Order.of(property, direction));
    }

    @Override
    public List<Order> getOrderBy() {
        return Collections.unmodifiableList(orders);
    }

    @Override
    public boolean isEmpty() {
        return this.orders.isEmpty();
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
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "DefaultSort{" +
                "orders=" + orders +
                '}';
    }
}
