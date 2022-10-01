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

class SortsTest {

    @Test
    public void shouldCreatePropertyDirector(){
        Sorts sorts = Sorts.of("name", Direction.ASC);
        Assertions.assertNotNull(sorts);
        MatcherAssert.assertThat(sorts.getOrderBy(), Matchers.contains(Sort.asc("name")));
    }

    @Test
    public void shouldCreateAsc(){
        Sorts sorts = Sorts.asc("name");
        Assertions.assertNotNull(sorts);
        MatcherAssert.assertThat(sorts.getOrderBy(), Matchers.contains(Sort.asc("name")));
    }

    @Test
    public void shouldCreateDesc(){
        Sorts sorts = Sorts.desc("name");
        Assertions.assertNotNull(sorts);
        MatcherAssert.assertThat(sorts.getOrderBy(), Matchers.contains(Sort.desc("name")));
    }

    @Test
    public void shouldCreateOfIterable(){
        Sorts sorts = Sorts.of(List.of(Sort.asc("name"), Sort.desc("age")));
        Assertions.assertNotNull(sorts);
        MatcherAssert.assertThat(sorts.getOrderBy(), Matchers.contains(Sort.asc("name"),
                Sort.desc("age")));
    }

    @Test
    public void shouldCreateOfVarArgs(){
        Sorts sorts = Sorts.of(Sort.asc("name"), Sort.desc("age"));
        Assertions.assertNotNull(sorts);
        MatcherAssert.assertThat(sorts.getOrderBy(), Matchers.contains(Sort.asc("name"),
                Sort.desc("age")));
    }

}