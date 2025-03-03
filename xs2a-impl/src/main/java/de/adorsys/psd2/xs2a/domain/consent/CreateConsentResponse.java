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

package de.adorsys.psd2.xs2a.domain.consent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.adorsys.psd2.xs2a.core.authorisation.AuthenticationObject;
import de.adorsys.psd2.xs2a.core.domain.TppMessageInformation;
import de.adorsys.psd2.xs2a.core.profile.NotificationSupportedMode;
import de.adorsys.psd2.xs2a.core.profile.ScaApproach;
import de.adorsys.psd2.xs2a.core.sca.ChallengeData;
import de.adorsys.psd2.xs2a.core.sca.ScaStatus;
import de.adorsys.psd2.xs2a.domain.Links;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CreateConsentResponse {
    private final String consentStatus;

    private final String consentId;

    private final List<AuthenticationObject> scaMethods;

    private final AuthenticationObject chosenScaMethod;

    private final ChallengeData challengeData;

    @JsonProperty("_links")
    private Links links = new Links();

    private String psuMessage;

    private final boolean multilevelScaRequired;

    //For Embedded approach Implicit case
    @JsonIgnore
    private String authorizationId;

    @JsonIgnore
    private final String internalRequestId;

    private final List<NotificationSupportedMode> tppNotificationContentPreferred;

    private final Set<TppMessageInformation> tppMessageInformation = new HashSet<>();

    @Nullable
    private ScaStatus scaStatus;
    @Nullable
    private ScaApproach scaApproach;
}
