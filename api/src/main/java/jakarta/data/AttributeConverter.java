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
package jakarta.data;

/**
 * A class that implements this interface can be used to convert entity attribute state into database column
 * representation and back again. Note that the X and Y types may be the same Java type.
 * @param <X> the type of the entity attribute
 * @param <Y> the type of the database column
 */
public interface AttributeConverter<X, Y> {

    /**
     * Converts the value stored in the entity attribute into the data representation to be stored in the database.
     *
     * @param attribute attribute the entity attribute value to be converted
     * @return the converted data to be stored in the database column
     */
    Y convertToDatabaseColumn(X attribute);

    /**
     * Converts the data stored in the database column into the value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to specify the correct dbData type for the
     * corresponding column for use by the JDBC driver: i.e., persistence providers are not expected to do
     * such type conversion.
     *
     * @param dbData the data from the database column to be converted
     * @return the converted value to be stored in the entity attribute
     */
    X convertToEntityAttribute(Y dbData);
}
