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

package de.adorsys.psd2.consent.web.xs2a.controller;

import de.adorsys.psd2.consent.api.CmsAccountApi;
import de.adorsys.psd2.consent.api.ais.UpdateTransactionParametersRequest;
import de.adorsys.psd2.consent.api.service.AccountServiceEncrypted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CmsAccountController implements CmsAccountApi {
    private final AccountServiceEncrypted accountServiceEncrypted;

    @Override
    public ResponseEntity<Boolean> saveTransactionParameters(String encryptedConsentId, String resourceId, UpdateTransactionParametersRequest updateTransactionParametersRequest) {
        return accountServiceEncrypted.saveTransactionParameters(encryptedConsentId, resourceId, updateTransactionParametersRequest)
                   ? new ResponseEntity<>(true, HttpStatus.OK)
                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
