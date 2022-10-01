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
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

enum DefaultSortSupplier implements Sort.SortSupplier {
    INSTANCE;

    @Override
    public Sort apply(Iterable<Order> orders) {
        Objects.requireNonNull(orders, "orders is required");
        return new DefaultSort(StreamSupport.stream(orders.spliterator(), false)
                .map(o -> Objects.requireNonNull(o, "all order element must not be null"))
                .collect(Collectors.toUnmodifiableList()));
    }
}
