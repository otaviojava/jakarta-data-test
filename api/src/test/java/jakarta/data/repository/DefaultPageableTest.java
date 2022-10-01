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

class DefaultPageableTest {

    @Test
    public void shouldCreatePageable(){
        Pageable pageable = DefaultPageable.of(2, 6, Sorts.of(Sort.asc("name")));
        Assertions.assertEquals(2L, pageable.getSize());
        Assertions.assertEquals(6L, pageable.getPageNumber());
        Assertions.assertEquals(Sorts.of(Sort.asc("name")), pageable.getSort());
    }

    @Test
    public void shouldNext(){
        Pageable pageable = DefaultPageable.of(2, 1, Sorts.of(Sort.asc("name")));
        Pageable next = pageable.next();
        Assertions.assertEquals(1L, pageable.getPageNumber());
        Assertions.assertEquals(2L, next.getPageNumber());
    }

}