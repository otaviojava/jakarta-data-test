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
 * Repository fragment to provide methods to retrieve entities using the pagination and sorting abstraction. In many
 * cases this will be combined with {@link CrudRepository} or similar or with manually added methods to provide CRUD
 * functionality.
 *
 * @see CrudRepository
 */
public interface PagingRepository<T, K> extends DataRepository<T, K> {

    //https://github.com/spring-projects/spring-data-commons/blob/main/src/main/java/org/springframework/data/repository/PagingAndSortingRepository.java

}
