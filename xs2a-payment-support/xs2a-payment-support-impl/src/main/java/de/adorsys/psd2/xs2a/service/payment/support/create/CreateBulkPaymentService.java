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

package de.adorsys.psd2.xs2a.service.payment.support.create;

import de.adorsys.psd2.logger.context.LoggingContextService;
import de.adorsys.psd2.xs2a.domain.pis.BulkPayment;
import de.adorsys.psd2.xs2a.domain.pis.PaymentInitiationParameters;
import de.adorsys.psd2.xs2a.service.RequestProviderService;
import de.adorsys.psd2.xs2a.service.ScaApproachResolver;
import de.adorsys.psd2.xs2a.service.authorization.AuthorisationChainResponsibilityService;
import de.adorsys.psd2.xs2a.service.authorization.AuthorisationMethodDecider;
import de.adorsys.psd2.xs2a.service.authorization.pis.PisScaAuthorisationServiceResolver;
import de.adorsys.psd2.xs2a.service.consent.Xs2aPisCommonPaymentService;
import de.adorsys.psd2.xs2a.service.mapper.cms_xs2a_mappers.Xs2aPisCommonPaymentMapper;
import de.adorsys.psd2.xs2a.service.mapper.cms_xs2a_mappers.Xs2aToCmsPisCommonPaymentRequestMapper;
import de.adorsys.psd2.xs2a.service.payment.create.AbstractCreatePaymentService;
import de.adorsys.psd2.xs2a.service.payment.support.create.spi.BulkPaymentInitiationService;
import de.adorsys.psd2.xs2a.service.payment.support.mapper.RawToXs2aPaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateBulkPaymentService extends AbstractCreatePaymentService<BulkPayment, BulkPaymentInitiationService> {
    private final RawToXs2aPaymentMapper rawToXs2aPaymentMapper;

    @Autowired
    public CreateBulkPaymentService(Xs2aPisCommonPaymentService pisCommonPaymentService,
                                    PisScaAuthorisationServiceResolver pisScaAuthorisationServiceResolver,
                                    AuthorisationMethodDecider authorisationMethodDecider,
                                    Xs2aPisCommonPaymentMapper xs2aPisCommonPaymentMapper,
                                    Xs2aToCmsPisCommonPaymentRequestMapper xs2aToCmsPisCommonPaymentRequestMapper,
                                    BulkPaymentInitiationService paymentInitiationService,
                                    RequestProviderService requestProviderService,
                                    RawToXs2aPaymentMapper rawToXs2aPaymentMapper,
                                    LoggingContextService loggingContextService,
                                    AuthorisationChainResponsibilityService authorisationChainResponsibilityService,
                                    ScaApproachResolver scaApproachResolver) {
        super(pisCommonPaymentService, pisScaAuthorisationServiceResolver, authorisationMethodDecider,
              xs2aPisCommonPaymentMapper, xs2aToCmsPisCommonPaymentRequestMapper, paymentInitiationService,
              requestProviderService, loggingContextService, authorisationChainResponsibilityService, scaApproachResolver);
        this.rawToXs2aPaymentMapper = rawToXs2aPaymentMapper;
    }

    @Override
    protected BulkPayment getPaymentRequest(byte[] payment, PaymentInitiationParameters paymentInitiationParameters) {
        return rawToXs2aPaymentMapper.mapToBulkPayment(payment);
    }
}
