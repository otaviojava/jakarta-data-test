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

import jakarta.data.DataException;

import java.util.Objects;
import java.util.ServiceLoader;

/**
 * Abstract interface for pagination information.
 */
public interface Pageable {

    long DEFAULT_SIZE = 10;
    Sorts EMPTY_SORTS = Sorts.of();

    /**
     * Returns the size of each page
     *
     * @return the size of each page
     */
    long getSize();

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
     * Returns the sorting parameters.
     *
     * @return The sort definition to use.
     */
    Sorts getSort();

    /**
     * Creates a new Pageable at the given size with a default size of 10.
     *
     * @param page The page
     * @return The pageable
     */
    static Pageable page(long page) {
        return of(page, DEFAULT_SIZE);
    }

    /**
     * Creates a new Pageable at the given size and page
     *
     * @param page The page
     * @param size The size
     * @return The pageable
     */
    static Pageable of(long page, long size) {
        return of(page, size, EMPTY_SORTS);
    }

    /**
     * Creates a new Pageable at the given size with a default size of 10.
     *
     * @param page The page
     * @param size The size
     * @param sorts the sort
     * @return The pageable
     */
    static Pageable of(long page, long size, Sorts sorts) {
        Objects.requireNonNull(sorts, "sort is required");
        PageableSupplier supplier =
                ServiceLoader.load(PageableSupplier.class)
                        .findFirst()
                        .orElseThrow(() -> new DataException("There is no implementation of PageableSupplier" +
                                " on the Class Loader"));
        return supplier.apply(page, size, sorts);
    }


}
