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

package de.adorsys.psd2.xs2a.service.authorization.pis;

import de.adorsys.psd2.xs2a.core.profile.ScaApproach;
import de.adorsys.psd2.xs2a.domain.consent.pis.PaymentAuthorisationParameters;
import de.adorsys.psd2.xs2a.domain.consent.pis.Xs2aUpdatePisCommonPaymentPsuDataResponse;
import de.adorsys.psd2.xs2a.service.mapper.cms_xs2a_mappers.Xs2aPisCommonPaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class RedirectPisScaAuthorisationService extends AbstractPisScaAuthorisationService {

    private final PisAuthorisationConfirmationService pisAuthorisationConfirmationService;

    public RedirectPisScaAuthorisationService(PisAuthorisationService authorisationService, Xs2aPisCommonPaymentMapper pisCommonPaymentMapper, PisAuthorisationConfirmationService pisAuthorisationConfirmationService) {
        super(authorisationService, pisCommonPaymentMapper);
        this.pisAuthorisationConfirmationService = pisAuthorisationConfirmationService;
    }

    @Override
    public Xs2aUpdatePisCommonPaymentPsuDataResponse updateCommonPaymentPsuData(PaymentAuthorisationParameters request) {
        return pisAuthorisationConfirmationService.processAuthorisationConfirmation(request);
    }

    @Override
    public Xs2aUpdatePisCommonPaymentPsuDataResponse updateCommonPaymentCancellationPsuData(PaymentAuthorisationParameters request) {
        return pisAuthorisationConfirmationService.processAuthorisationConfirmation(request);
    }

    @Override
    public ScaApproach getScaApproachServiceType() {
        return ScaApproach.REDIRECT;
    }
}
