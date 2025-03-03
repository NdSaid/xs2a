/*
 * Copyright 2018-2023 adorsys GmbH & Co KG
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version. This program is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see https://www.gnu.org/licenses/.
 *
 * This project is also available under a separate commercial license. You can
 * contact us at psd2@adorsys.com.
 */

package de.adorsys.psd2.xs2a.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Xs2aUsageType {
    PRIV("PRIV"),
    ORGA("ORGA");

    private static final Map<String, Xs2aUsageType> container = new HashMap<>();

    static {
        for (Xs2aUsageType usageType : values()) {
            container.put(usageType.getValue(), usageType);
        }
    }

    private String value;

    Xs2aUsageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonIgnore
    public static Optional<Xs2aUsageType> getByValue(String name) {
        return Optional.ofNullable(container.get(name));
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
