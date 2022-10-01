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

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class DefaultSortSupplierTest {

    private Sort.SortSupplier supplier;

    @BeforeEach
    public void setUp() {
        this.supplier = DefaultSortSupplier.INSTANCE;
    }

    @Test
    public void shouldReturnErrorWhenIterableIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()-> supplier.apply(null));
    }

    @Test
    public void shouldReturnErrorWhenElementIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()-> supplier.apply(Collections.singletonList(null)));
    }

    @Test
    public void shouldCreateSort(){
        Sort sort = supplier.apply(List.of(Order.asc("name"), Order.desc("age")));
        Assertions.assertNotNull(sort);
        Assertions.assertFalse(sort.isEmpty());
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.asc("name"), Order.desc("age")));
    }
}