/*
 * Copyright 2018-2024 adorsys GmbH & Co KG
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
 * contact us at sales@adorsys.com.
 */

package de.adorsys.psd2.xs2a.web.controller.tb;

import de.adorsys.psd2.api.ListOfTrustedBeneficiariesApi;
import de.adorsys.psd2.xs2a.domain.ResponseObject;
import de.adorsys.psd2.xs2a.domain.account.Xs2aTrustedBeneficiariesList;
import de.adorsys.psd2.xs2a.service.ais.TrustedBeneficiariesService;
import de.adorsys.psd2.xs2a.service.mapper.ResponseMapper;
import de.adorsys.psd2.xs2a.service.mapper.TrustedBeneficiariesModelMapper;
import de.adorsys.psd2.xs2a.service.mapper.psd2.ResponseErrorMapper;
import de.adorsys.psd2.xs2a.web.controller.util.RequestUriHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@SuppressWarnings("unchecked") // This class implements autogenerated interface without proper return values generated
@Slf4j
@RestController
@AllArgsConstructor
public class TrustedBeneficiariesController implements ListOfTrustedBeneficiariesApi {

    private final HttpServletRequest request;
    private final TrustedBeneficiariesService trustedBeneficiariesService;
    private final ResponseMapper responseMapper;
    private final TrustedBeneficiariesModelMapper trustedBeneficiariesModelMapper;
    private final ResponseErrorMapper responseErrorMapper;
    private final RequestUriHandler requestUriHandler;

    @Override
    public ResponseEntity listOfTrustedBeneficiaries(String accountId, UUID xRequestID, String consentID, String psUIPAddress, String authorization) {
        ResponseObject<Xs2aTrustedBeneficiariesList> trustedBeneficiaries =
            trustedBeneficiariesService.getTrustedBeneficiaries(consentID, accountId, requestUriHandler.trimEndingSlash(request.getRequestURI()));
        return trustedBeneficiaries.hasError()
                   ? responseErrorMapper.generateErrorResponse(trustedBeneficiaries.getError())
                   : responseMapper.ok(trustedBeneficiaries, trustedBeneficiariesModelMapper::mapToTrustedBeneficiariesList);
    }
}
