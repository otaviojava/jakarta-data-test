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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PageableTest {

    @Test
    public void shouldCreatePageable(){
        Pageable pageable = Pageable.of(2, 6);
        Assertions.assertEquals(6L, pageable.getSize());
        Assertions.assertEquals(2L, pageable.getPage());
    }

    @Test
    public void shouldNext(){
        Pageable pageable = Pageable.of(2, 1);
        Pageable next = pageable.next();
        Assertions.assertEquals(1L, pageable.getSize());
        Assertions.assertEquals(2L, pageable.getPage());
        Assertions.assertEquals(3L, next.getPage());
        Assertions.assertEquals(1L, next.getSize());
    }

    @Test
    public void shouldReturnErrorWhenThereIsIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                Pageable.page(0));

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                Pageable.page(-1));

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                Pageable.of(1, -1));

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                Pageable.of(1, 0));
    }

    @Test
    public void shouldReturnNPEWhenSortIsNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                Pageable.of(1L, 2L, (Sort) null));
        Assertions.assertThrows(NullPointerException.class, () ->
                Pageable.of(1L, 2L, (Iterable<Sort>) null));

        Assertions.assertThrows(NullPointerException.class, () ->
                Pageable.of(1L, 2L, Sort.asc("name"), null));
    }

    @Test
    public void shouldCreatePageableSort() {
        Pageable pageable = Pageable.of(1L, 3L, Sort.asc("name"));
        Assertions.assertNotNull(pageable);
        Assertions.assertEquals(1L, pageable.getPage());
        Assertions.assertEquals(3L, pageable.getSize());
        assertThat(pageable.getSorts())
                .hasSize(1)
                .contains(Sort.asc("name"));
    }

    @Test
    public void shouldNotModifySort() {
        Pageable pageable = Pageable.of(1L, 3L, Sort.asc("name"));
        List<Sort> sorts = pageable.getSorts();
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> sorts.clear());

    }

    @Test
    public void shouldNotModifySortOnNextPage() {
        Pageable pageable = Pageable.of(1L, 3L, Sort.asc("name"), Sort.desc("age"));

    }

}