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

import java.util.function.BiFunction;

/**
 * Abstract interface for pagination information.
 */
public interface Pageable {

    /**
     * Returns the offset to be taken according to the underlying page and page size.
     *
     * @return the offset to be taken according to the underlying page and page size.
     */
    long getOffset();

    /**
     * Returns the page to be returned.
     *
     * @return the page to be returned.
     */
    long getPageNumber();

    /**
     * Returns the Pageable requesting the next Page.
     *
     * @return The next pageable.
     */
    Pageable next();

    /**
     * Returns the previous Pageable or the first Pageable if the current one already is the first one.
     *
     * @return The previous pageable
     */
    Pageable previous();

    /**
     * Returns the sorting parameters.
     *
     * @return The sort definition to use.
     */
    Sort getSort();

    static <P extends Pageable> P page(long page) {

    }

    static <P extends Pageable> P of(long page, long size) {

    }

    static <P extends Pageable> P of(long page, long size, Sort sort) {

    }

    interface PageableSupplier<P extends Pageable> {
        P apply(long page, long size, Sort sort);
    }
}
