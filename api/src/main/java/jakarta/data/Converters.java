/*
 *  Copyright (c) 2022 Otavio Santana, Nathan Rauh and others
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
package jakarta.data;

/**
 * The Converter storage
 */
public interface Converters {

    /**
     * Return a new instance from the converter
     *
     * @param converterClass the converter class
     * @param <X> the type of the entity attribute
     * @param <Y> the type of the database column
     * @return a converter instance
     * @throws NullPointerException when converter is null
     */
    <X, Y> AttributeConverter<X, Y> get(Class<? extends AttributeConverter<X, Y>> converterClass);
}
