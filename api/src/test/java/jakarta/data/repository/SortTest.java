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
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    public void shouldCreatePropertyDirector(){
        Sort sort = Sort.of("name", Direction.ASC);
        Assertions.assertNotNull(sort);
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.asc("name")));
    }

    @Test
    public void shouldCreateAsc(){
        Sort sort = Sort.asc("name");
        Assertions.assertNotNull(sort);
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.asc("name")));
    }

    @Test
    public void shouldCreateDesc(){
        Sort sort = Sort.desc("name");
        Assertions.assertNotNull(sort);
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.desc("name")));
    }

    @Test
    public void shouldCreateOfIterable(){
        Sort sort = Sort.of(List.of(Order.asc("name"), Order.desc("age")));
        Assertions.assertNotNull(sort);
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.asc("name"),
                Order.desc("age")));
    }

    @Test
    public void shouldCreateOfVarArgs(){
        Sort sort = Sort.of(Order.asc("name"), Order.desc("age"));
        Assertions.assertNotNull(sort);
        MatcherAssert.assertThat(sort.getOrderBy(), Matchers.contains(Order.asc("name"),
                Order.desc("age")));
    }

}