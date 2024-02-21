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

package de.adorsys.psd2.xs2a.service.validator.ais.consent;

import de.adorsys.psd2.core.data.ais.AisConsent;
import de.adorsys.psd2.xs2a.core.service.validator.ValidationResult;
import de.adorsys.psd2.xs2a.service.validator.OauthConsentValidator;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * Validator to be used for validating get consent authorisation sca status request according to some business rules
 */
@Component
@RequiredArgsConstructor
public class GetConsentAuthorisationScaStatusValidator extends AbstractAisTppValidator<GetConsentAuthorisationScaStatusPO> {

    private final AisAuthorisationValidator aisAuthorisationValidator;
    private final OauthConsentValidator oauthConsentValidator;

    /**
     * Validates get consent authorisation sca status request
     *
     * @param consentObject consent information object
     * @return valid result if the consent is valid, invalid result with appropriate error otherwise
     */
    @NotNull
    @Override
    protected ValidationResult executeBusinessValidation(GetConsentAuthorisationScaStatusPO consentObject) {
        AisConsent response = consentObject.getAisConsent();
        String authorisationId = consentObject.getAuthorisationId();

        ValidationResult authorisationValidationResult = aisAuthorisationValidator.validate(authorisationId, response);
        if (authorisationValidationResult.isNotValid()) {
            return authorisationValidationResult;
        }

        ValidationResult authAuthorisationValidationResult = oauthConsentValidator.validate(consentObject.getAisConsent());
        if (authAuthorisationValidationResult.isNotValid()) {
            return authAuthorisationValidationResult;
        }

        return ValidationResult.valid();
    }
}
