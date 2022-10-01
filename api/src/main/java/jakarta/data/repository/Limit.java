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
 * SPDX-License-Identifier: Apache-2.0
 */
package jakarta.data.repository;

import java.util.Objects;

/**
 * <p>Caps the number of results that can be returned by a single invocation
 * of a repository find method.</p>
 *
 * <p><code>Limit</code> is optionally specified as a parameter to a
 * repository method in one of the parameter positions after the
 * query parameters. For example,</p>
 *
 * <pre>
 * &#64;Query("SELECT o FROM Products o WHERE o.weight &lt;= ?1 AND o.width * o.length * o.height &lt;= ?2 ORDER BY o.price DESC")
 * Product[] freeShippingEligible(float maxWeight, float maxVolume, Limit maxResults);
 *
 * ...
 * found = products.freeShippingEligible(6.0f, 360.0f, Limit.of(50));
 * </pre>
 *
 * <p>A repository method will raise {@link IllegalArgumentException} if</p>
 * <ul>
 * <li>multiple <code>Limit</code> parameters are specified on the
 *     same method.</li>
 * <li>a <code>Limit</code> parameter is specified in combination
 *     with the <code>First</code> keyword.</li>
 * </ul>
 */
public class Limit {
    private final long limit;
    private final long skip;

    private Limit(long limit, long skip) {
        if (limit < 1) {
            throw new IllegalArgumentException("limit: " + limit);
        }

        this.limit = limit;
        this.skip = skip;
    }

    /**
     * <p>Maximum number of results that can be returned for a
     * single invocation of the repository method.</p>
     *
     * @return maximum number of results for a query.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * <p>Offset at which to start when returning query results.
     * The first query result is position <code>1</code>.<p>
     *
     * @return offset of the first result.
     */
    public long getSkip() {
        return skip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Limit limit = (Limit) o;
        return this.limit == limit.limit && skip == limit.skip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, skip);
    }

    @Override
    public String toString() {
        return "Limit{" +
                "limit=" + limit +
                ", skip=" + skip +
                '}';
    }

    /**
     * <p>Create a limit that caps the number of results at the
     * specified maximum, starting from the first result.</p>
     *
     * @param maxResults maximum number of results.
     * @return limit that can be supplied to a <code>find...By</code>
     * or <code>&#64;Query</code> method.
     * @throws IllegalArgumentException if maxResults is less than 1.
     */
    public static Limit of(long maxResults) {
        return new Limit(maxResults, 1L);
    }

    /**
     * <p>Create a limit that caps the number of results at the
     * specified maximum, starting from the specified position.</p>
     *
     * @param maxResults maximum number of results.
     * @param startAt    position at which to start returning results.
     * @return limit that can be supplied to a <code>find...By</code>
     * or <code>&#64;Query</code> method.
     * @throws IllegalArgumentException if maxResults or startAt is
     *                                  less than 1.
     */
    public static Limit of(long maxResults, long startAt) {
        if (startAt < 1) {
            throw new IllegalArgumentException("startAt: " + startAt);
        }

        return new Limit(maxResults, startAt);
    }
}
