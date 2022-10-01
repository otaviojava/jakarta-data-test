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

import static org.junit.jupiter.api.Assertions.*;

class DefaultOrderSupplierTest {

    private Order.OrderSupplier<Order> supplier;

    @BeforeEach
    public void setUp() {
        this.supplier = DefaultOrderSupplier.INSTANCE;
    }

    @Test
    public void shouldReturnErrorWhenPropertyIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> supplier.apply(null, Direction.ASC));
    }

    @Test
    public void shouldReturnErrorWhenDirectionIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> supplier.apply("name", null));
    }

    @Test
    public void shouldSupplierOrder() {
        Order order = supplier.apply("name", Direction.ASC);
        Assertions.assertNotNull(order);
    }
}