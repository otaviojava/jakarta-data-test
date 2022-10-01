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

class DefaultSort implements Sort {

    private final List<Order> orders;

    DefaultSort() {
        this.orders = new ArrayList<>();
    }

    @Override
    public Sort order(Order order) {
        return null;
    }

    @Override
    public Sort add(Sort sort) {
        return null;
    }

    @Override
    public Sort order(String property) {
        return null;
    }

    @Override
    public Sort order(String property, Direction direction) {
        return null;
    }

    @Override
    public List<Order> getOrderBy() {
        return Collections.unmodifiableList(orders);
    }

    @Override
    public boolean isEmpty() {
        return this.orders.isEmpty();
    }
}
