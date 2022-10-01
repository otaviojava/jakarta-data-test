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
import org.junit.jupiter.api.Test;

class DefaultSortTest {

    @Test
    public void shouldReturnErrorWhenOrderIsNull() {
        Sort sort = new DefaultSort();
        Assertions.assertThrows(NullPointerException.class, () -> sort.order((Order) null ));
    }
    @Test
    public void shouldAddOrder() {
        Sort sort = new DefaultSort();
        Assertions.assertTrue(sort.isEmpty());
        Sort name = sort.order(Order.asc("name"));
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());
        Assertions.assertNotEquals(sort, name);
    }

    @Test
    public void shouldReturnErrorWhenPropertyIsNull(){
        Sort sort = new DefaultSort();
        Assertions.assertThrows(NullPointerException.class, () -> sort.order((String) null ));
    }

    @Test
    public void shouldAddProperty(){
        Sort sort = new DefaultSort();
        Assertions.assertTrue(sort.isEmpty());
        Sort name = sort.order("name");
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());
        Assertions.assertNotEquals(sort, name);
    }
}