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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class DefaultSortsTest {

    @Test
    public void shouldReturnErrorWhenOrderIsNull() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertThrows(NullPointerException.class, () -> sorts.order((Sort) null));
    }

    @Test
    public void shouldAddOrder() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertTrue(sorts.isEmpty());
        Sorts name = sorts.order(Sort.asc("name"));
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());
        Assertions.assertNotEquals(sorts, name);
        assertThat(name.getOrderBy(), contains(Sort.asc("name")));
    }

    @Test
    public void shouldReturnErrorWhenPropertyIsNull() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertThrows(NullPointerException.class, () -> sorts.order((String) null));
    }

    @Test
    public void shouldAddProperty() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertTrue(sorts.isEmpty());
        Sorts name = sorts.order("name");
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());
        Assertions.assertNotEquals(sorts, name);
        assertThat(name.getOrderBy(), contains(Sort.asc("name")));
    }

    @Test
    public void shouldReturnErrorWhenPropertyDirectionIsNull() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertThrows(NullPointerException.class, () -> sorts.order(null, null));
        Assertions.assertThrows(NullPointerException.class, () -> sorts.order("name", null));
        Assertions.assertThrows(NullPointerException.class, () -> sorts.order(null, Direction.ASC));
    }

    @Test
    public void shouldAddPropertyDirection() {
        Sorts sorts = new DefaultSorts();
        Assertions.assertTrue(sorts.isEmpty());
        Sorts name = sorts.order("name", Direction.ASC);
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());
        Assertions.assertNotEquals(sorts, name);
        assertThat(name.getOrderBy(), contains(Sort.asc("name")));
    }

    @Test
    public void shouldReturnErrorWhenSortIsNull(){
        Sorts sorts = new DefaultSorts();
        Assertions.assertThrows(NullPointerException.class, () -> sorts.add(null));
    }
    @Test
    public void shouldAddSort(){
        Sorts sort = new DefaultSorts().order("name", Direction.ASC);
        Sorts sorts = sort.add(Sorts.of(Sort.desc("age")));
        Assertions.assertNotNull(sorts);
        Assertions.assertFalse(sorts.isEmpty());
        Assertions.assertNotEquals(sort, sorts);
        assertThat(sorts.getOrderBy(), contains(Sort.asc("name"), Sort.desc("age")));
    }
}