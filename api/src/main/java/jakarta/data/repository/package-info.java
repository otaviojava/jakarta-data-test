/*
 * Copyright (c) Otavio Santana and others
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
 */
/**
 * In DDD, a repository is an object that participates in the domain but abstracts away storage
 * and infrastructure details. Most systems have persistent storage,
 * like a database, for its full functioning. Applying repositories happens
 * by integrating and synchronizing with existing aggregate objects in the system.
 */
package jakarta.data.repository;