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

class OrderTest {

    @Test
    public void shouldReturnErrorWhenPropertyDirectionNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                Order.of(null, null));

        Assertions.assertThrows(NullPointerException.class, () ->
                Order.of("name", null));

        Assertions.assertThrows(NullPointerException.class, () ->
                Order.of(null, Direction.ASC));
    }

    @Test
    public void shouldCreateSort() {
        Order order = Order.of("name", Direction.ASC);
        Assertions.assertNotNull(order);
        Assertions.assertEquals("name", order.getProperty());
        Assertions.assertTrue(order.isAscending());
        Assertions.assertFalse(order.isDescending());
    }

    @Test
    public void shouldCreateAsc(){
        Order order = Order.asc("name");
        Assertions.assertNotNull(order);
        Assertions.assertEquals("name", order.getProperty());
        Assertions.assertTrue(order.isAscending());
        Assertions.assertFalse(order.isDescending());
    }

    @Test
    public void shouldCreateDesc(){
        Order order = Order.desc("name");
        Assertions.assertNotNull(order);
        Assertions.assertEquals("name", order.getProperty());
        Assertions.assertTrue(order.isDescending());
        Assertions.assertFalse(order.isAscending());
    }
}