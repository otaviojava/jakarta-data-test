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

enum DefaultPageableSupplier implements Pageable.PageableSupplier {
    INSTANCE;

    @Override
    public Pageable apply(long page, long size, Sort sort) {
        if (page < 1) {
            throw new IllegalArgumentException("The page should not be negative or zero: " + page);
        } else if (size < 1) {
            throw new IllegalArgumentException("The size should not be negative or zero: " + size);
        }
        Objects.requireNonNull(sort, "sort is required");
        return DefaultPageable.of(size, page, sort);
    }
}
