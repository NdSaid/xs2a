/*
 * Copyright 2018-2022 adorsys GmbH & Co KG
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

package de.adorsys.psd2.xs2a.web.controller.psd2;

import de.adorsys.psd2.api.CardAccountsApi;
import de.adorsys.psd2.xs2a.core.ais.BookingStatus;
import de.adorsys.psd2.xs2a.domain.ResponseObject;
import de.adorsys.psd2.xs2a.domain.account.*;
import de.adorsys.psd2.xs2a.service.ais.CardAccountBalanceService;
import de.adorsys.psd2.xs2a.service.ais.CardAccountService;
import de.adorsys.psd2.xs2a.service.ais.CardTransactionService;
import de.adorsys.psd2.xs2a.service.mapper.CardAccountModelMapper;
import de.adorsys.psd2.xs2a.service.mapper.ResponseMapper;
import de.adorsys.psd2.xs2a.service.mapper.psd2.ResponseErrorMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.UUID;

@SuppressWarnings("unchecked") // This class implements autogenerated interface without proper return values generated
@Slf4j
@RestController
@AllArgsConstructor
public class CardAccountController implements CardAccountsApi {

    private final HttpServletRequest request;
    private final CardAccountBalanceService cardAccountBalanceService;
    private final CardAccountService cardAccountService;
    private final CardTransactionService cardTransactionService;
    private final ResponseMapper responseMapper;
    private final CardAccountModelMapper cardAccountModelMapper;
    private final ResponseErrorMapper responseErrorMapper;

    @Override
    public ResponseEntity getCardAccountList(UUID xRequestID, String consentID, String digest, String signature, byte[] tpPSignatureCertificate, String psUIPAddress, String psUIPPort, String psUAccept, String psUAcceptCharset, String psUAcceptEncoding, String psUAcceptLanguage, String psUUserAgent, String psUHttpMethod, UUID psUDeviceID, String psUGeoLocation) {
        ResponseObject<Xs2aCardAccountListHolder> accountList = cardAccountService.getCardAccountList(consentID, trimEndingSlash(request.getRequestURI()));

        return accountList.hasError()
                   ? responseErrorMapper.generateErrorResponse(accountList.getError())
                   : responseMapper.ok(accountList, cardAccountModelMapper::mapToCardAccountList);
    }

    @Override
    public ResponseEntity getCardAccountBalances(String accountId, UUID xRequestID, String consentID, String digest, String signature, byte[] tpPSignatureCertificate, String psUIPAddress, String psUIPPort, String psUAccept, String psUAcceptCharset, String psUAcceptEncoding, String psUAcceptLanguage, String psUUserAgent, String psUHttpMethod, UUID psUDeviceID, String psUGeoLocation) {
        ResponseObject<Xs2aBalancesReport> balancesReport = cardAccountBalanceService.getBalancesReport(consentID, accountId, trimEndingSlash(request.getRequestURI()));
        return balancesReport.hasError()
                   ? responseErrorMapper.generateErrorResponse(balancesReport.getError())
                   : responseMapper.ok(balancesReport, cardAccountModelMapper::mapToBalance);
    }

    @Override
    public ResponseEntity getCardAccountTransactionList(String accountId, String bookingStatus, UUID xRequestID, String consentID, LocalDate dateFrom, LocalDate dateTo, String entryReferenceFrom, Boolean deltaList, String digest, String signature, byte[] tpPSignatureCertificate, String psUIPAddress, String psUIPPort, String psUAccept, String psUAcceptCharset, String psUAcceptEncoding, String psUAcceptLanguage, String psUUserAgent, String psUHttpMethod, UUID psUDeviceID, String psUGeoLocation) {
        Xs2aCardTransactionsReportByPeriodRequest xs2aCardTransactionsReportByPeriodRequest = new Xs2aCardTransactionsReportByPeriodRequest(consentID, accountId, request.getHeader("accept"), dateFrom, dateTo, BookingStatus.forValue(bookingStatus), trimEndingSlash(request.getRequestURI()), entryReferenceFrom, deltaList, null, null);
        ResponseObject<Xs2aCardTransactionsReport> cardTransactionsReport = cardTransactionService.getCardTransactionsReportByPeriod(xs2aCardTransactionsReportByPeriodRequest);

        if (cardTransactionsReport.hasError()) {
            return responseErrorMapper.generateErrorResponse(cardTransactionsReport.getError());
        } else if (cardTransactionsReport.getBody().isResponseContentTypeJson()) {
            return responseMapper.ok(cardTransactionsReport, cardAccountModelMapper::mapToTransactionsResponse200Json);
        } else {
            return responseMapper.ok(cardTransactionsReport, cardAccountModelMapper::mapToTransactionsResponseRaw);
        }
    }

    @Override
    public ResponseEntity readCardAccountDetails(String accountId, UUID xRequestID, String consentID, String digest, String signature, byte[] tpPSignatureCertificate, String psUIPAddress, String psUIPPort, String psUAccept, String psUAcceptCharset, String psUAcceptEncoding, String psUAcceptLanguage, String psUUserAgent, String psUHttpMethod, UUID psUDeviceID, String psUGeoLocation) {

        ResponseObject<Xs2aCardAccountDetailsHolder> accountDetails = cardAccountService.getCardAccountDetails(consentID, accountId, trimEndingSlash(request.getRequestURI()));

        return accountDetails.hasError()
                   ? responseErrorMapper.generateErrorResponse(accountDetails.getError())
                   : responseMapper.ok(accountDetails, cardAccountModelMapper::mapToInlineResponse2002);
    }

    private String trimEndingSlash(String input) {
        String result = input;

        while (StringUtils.endsWith(result, "/")) {
            result = StringUtils.removeEnd(result, "/");
        }
        return result;
    }
}
