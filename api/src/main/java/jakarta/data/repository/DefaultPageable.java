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

import java.util.Objects;

final class DefaultPageable implements Pageable {

    private final long size;

    private final long pagerNumber;

    private final Sort sort;

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public long getPageNumber() {
        return pagerNumber;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultPageable that = (DefaultPageable) o;
        return size == that.size && pagerNumber == that.pagerNumber && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, pagerNumber, sort);
    }

    @Override
    public String toString() {
        return "DefaultPageable{" +
                "size=" + size +
                ", pagerNumber=" + pagerNumber +
                ", sort=" + sort +
                '}';
    }
}
