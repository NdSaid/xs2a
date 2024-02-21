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

package de.adorsys.psd2.event.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.adorsys.psd2.event.core.model.EventOrigin;
import de.adorsys.psd2.event.core.model.EventType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Contains information about the event.
 */
@Setter
@Getter
@Builder
@EqualsAndHashCode
public class AspspEvent {
    /**
     * Date and time indicating when the event has occurred.
     */
    private OffsetDateTime timestamp;

    /**
     * Id of the consent that can be associated with this event.
     * Can be null if the event isn't connected with the specific consent.
     */
    private String consentId;

    /**
     * Id of the payment that can be associated with this event.
     * Can be null if the event isn't connected with the specific payment.
     */
    private String paymentId;

    /**
     * Indicates the origin of the event.
     */
    private EventOrigin eventOrigin;

    /**
     * Indicates what happened in this event.
     */
    private EventType eventType;

    /**
     * The id of particular service instance.
     */
    private String instanceId;

    /**
     * List of PSU data
     */
    private List<AspspPsuIdData> psuIdData;

    /**
     * Authorization number of the TPP
     */
    private String tppAuthorisationNumber;

    /**
     * ID of the request, provided by the TPP
     */
    private UUID xRequestId;

    /**
     * Internal ID of the request, generated by the XS2A
     */
    @JsonProperty("InR-ID")
    private UUID internalRequestId;

    /**
     * Object that may contain additional information about the event.
     * Can be null if the event doesn't provide any additional information.
     */
    private Object payload;
}
