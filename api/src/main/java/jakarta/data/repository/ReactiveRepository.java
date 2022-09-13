/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0.
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 *
 *  SPDX-License-Identifier: Apache-2.0
 */

package jakarta.data.repository;

/**
 * Interface for generic CRUD operations on a repository for a specific type. This repository follows reactive paradigms.
 *
 * @param <T> the domain type the repository manages
 * @param <K> the type of the id of the entity the repository manages
 */
public interface ReactiveRepository<T, K> extends DataRepository<T, K> {
}
