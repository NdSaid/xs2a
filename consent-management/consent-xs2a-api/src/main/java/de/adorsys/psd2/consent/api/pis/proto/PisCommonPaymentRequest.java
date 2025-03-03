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

package de.adorsys.psd2.consent.api.pis.proto;

import de.adorsys.psd2.consent.api.pis.PisPayment;
import de.adorsys.psd2.xs2a.core.pis.TransactionStatus;
import de.adorsys.psd2.xs2a.core.profile.PaymentType;
import de.adorsys.psd2.xs2a.core.psu.PsuIdData;
import de.adorsys.psd2.xs2a.core.tpp.TppInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Pis payment initialisation consent request", name = "PisCommonPaymentRequest")
public class PisCommonPaymentRequest {
    @Schema(description = "Payment data", required = true)
    private List<PisPayment> payments;

    @Schema(description = "Payment product", required = true, example = "sepa-credit-transfers")
    private String paymentProduct;

    @Schema(description = "Payment type: BULK, SINGLE or PERIODIC.", required = true, example = "SINGLE")
    private PaymentType paymentType;

    @Schema(description = "Tpp information", required = true)
    private TppInfo tppInfo;

    @Schema(description = "Corresponding PSU", required = true)
    private List<PsuIdData> psuData;

    @Schema(description = "External Payment Id", example = "32454656712432")
    private String paymentId;

    @Schema(description = "Transaction status", example = "ACCP")
    private TransactionStatus transactionStatus;

    @Schema(description = "Payment info")
    private PisPaymentInfo paymentInfo;
}
