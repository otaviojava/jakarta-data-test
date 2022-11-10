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
package jakarta.data;

public class NonUniqueResultException extends DataException {

    /**
     * Constructs a new NonUniqueResultException exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public NonUniqueResultException(String message) {
        super(message);
    }

    /**
     * Constructs a new NonUniqueResultException exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public NonUniqueResultException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new NonUniqueResultException exception with the specified cause.
     *
     * @param cause the cause.
     */
    public NonUniqueResultException(Throwable cause) {
        super(cause);
    }
}