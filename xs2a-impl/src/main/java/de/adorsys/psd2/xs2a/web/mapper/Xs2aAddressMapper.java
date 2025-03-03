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

package de.adorsys.psd2.xs2a.web.mapper;

import de.adorsys.psd2.model.Address;
import de.adorsys.psd2.xs2a.core.domain.address.Xs2aAddress;
import de.adorsys.psd2.xs2a.core.domain.address.Xs2aCountryCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface Xs2aAddressMapper {

    @Mapping(target = "country", source = "address", qualifiedByName = "mapToXs2aCountryCode")
    Xs2aAddress mapToXs2aAddress(Address address);

    @Mapping(target = "country", source = "country.code")
    Address mapToAddress(Xs2aAddress address);

    @Named("mapToXs2aCountryCode")
    default Xs2aCountryCode mapToXs2aCountryCode(Address address) {
        return new Xs2aCountryCode(address.getCountry());
    }
}
