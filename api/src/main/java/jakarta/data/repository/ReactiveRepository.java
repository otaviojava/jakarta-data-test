/*
 *  Copyright (c) 2022 Otavio Santana, Nathan Rauh and others
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
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
