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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultPageableSupplierTest {

    private Pageable.PageableSupplier supplier;

    @BeforeEach
    public void setUp() {
        this.supplier = DefaultPageableSupplier.INSTANCE;
    }

    @Test
    public void shouldReturnErrorWhenPageIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> supplier.apply(0L, 2L, Sort.of()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> supplier.apply(-1L, 2L, Sort.of()));
    }

    @Test
    public void shouldReturnErrorWhenSizeIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> supplier.apply(1L, 0L, Sort.of()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> supplier.apply(2L, -1L, Sort.of()));
    }

    @Test
    public void shouldReturnErrorWhenSortIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> supplier.apply(1L, 2L, null));
    }

    @Test
    public void shouldCreatePageable() {
        Pageable pageable = supplier.apply(2, 3, Sort.asc("name"));
        Assertions.assertNotNull(pageable);

        Assertions.assertEquals(3L, pageable.getSize());
        Assertions.assertEquals(2L, pageable.getPageNumber());
        Assertions.assertEquals(pageable.getSort(), Sort.asc("name"));

    }

}