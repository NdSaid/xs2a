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

package de.adorsys.psd2.xs2a.web.validator.body.payment.handler.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PaymentTypeValidatorContext {

    private Map<String, PaymentTypeValidator> context = new HashMap<>();
    private List<PaymentTypeValidator> paymentTypeValidators;

    @Autowired
    public PaymentTypeValidatorContext(List<PaymentTypeValidator> paymentTypeValidators) {
        this.paymentTypeValidators = paymentTypeValidators;
        createContext();
    }

    public Optional<PaymentTypeValidator> getValidator(String paymentType) {
        return Optional.ofNullable(context.get(paymentType));
    }

    private void createContext() {
        paymentTypeValidators.forEach(m -> context.put(m.getPaymentType().getValue(), m));
    }
}
