/*
 * Copyright 2018-2020 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.4-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package de.adorsys.psd2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.adorsys.psd2.model.*;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-28T17:58:21.648494+03:00[Europe/Kiev]")

@Api(value = "card-accounts", description = "the card-accounts API")
public interface CardAccountsApi {

    Logger log = LoggerFactory.getLogger(CardAccountsApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Read a list of card accounts", nickname = "getCardAccount", notes = "Reads a list of card accounts with additional information, e.g. balance information.  It is assumed that a consent of the PSU to this access is already given and stored on the ASPSP system.  The addressed list of card accounts depends then on the PSU ID and the stored consent addressed by consentId,  respectively the OAuth2 access token.  ", response = CardAccountList.class, authorizations = {
        @Authorization(value = "BearerAuthOAuth")
    }, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = CardAccountList.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error400NGAIS.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error401NGAIS.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error403NGAIS.class),
        @ApiResponse(code = 404, message = "Not found", response = Error404NGAIS.class),
        @ApiResponse(code = 405, message = "Method Not Allowed", response = Error405NGAIS.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = Error406NGAIS.class),
        @ApiResponse(code = 408, message = "Request Timeout"),
        @ApiResponse(code = 409, message = "Conflict", response = Error409NGAIS.class),
        @ApiResponse(code = 415, message = "Unsupported Media Type"),
        @ApiResponse(code = 429, message = "Too Many Requests", response = Error429NGAIS.class),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 503, message = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<CardAccountList> _getCardAccount(@ApiParam(value = "ID of the request, unique to the call, as determined by the initiating party." ,required=true) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID,@ApiParam(value = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true) @RequestHeader(value="Consent-ID", required=true) String consentID,@ApiParam(value = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ) @RequestHeader(value="Digest", required=false) String digest,@ApiParam(value = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ) @RequestHeader(value="Signature", required=false) String signature,@ApiParam(value = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate,@ApiParam(value = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress,@ApiParam(value = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept", required=false) String psUAccept,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage,@ApiParam(value = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent,@ApiParam(value = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " , allowableValues="GET, POST, PUT, PATCH, DELETE") @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod,@ApiParam(value = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID,@ApiParam(value = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return getCardAccount(xRequestID, consentID, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<CardAccountList> getCardAccount(UUID xRequestID,String consentID,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Read card account balances", nickname = "getCardAccountBalances", notes = "Reads balance data from a given card account addressed by  \"account-id\".   Remark: This account-id can be a tokenised identification due  to data protection reason since the path information might be  logged on intermediary servers within the ASPSP sphere.  This account-id then can be retrieved by the  \"Get card account list\" call. ", response = ReadCardAccountBalanceResponse200.class, authorizations = {
        @Authorization(value = "BearerAuthOAuth")
    }, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = ReadCardAccountBalanceResponse200.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error400NGAIS.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error401NGAIS.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error403NGAIS.class),
        @ApiResponse(code = 404, message = "Not found", response = Error404NGAIS.class),
        @ApiResponse(code = 405, message = "Method Not Allowed", response = Error405NGAIS.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = Error406NGAIS.class),
        @ApiResponse(code = 408, message = "Request Timeout"),
        @ApiResponse(code = 409, message = "Conflict", response = Error409NGAIS.class),
        @ApiResponse(code = 415, message = "Unsupported Media Type"),
        @ApiResponse(code = 429, message = "Too Many Requests", response = Error429NGAIS.class),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 503, message = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts/{account-id}/balances",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<ReadCardAccountBalanceResponse200> _getCardAccountBalances(@ApiParam(value = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ",required=true) @PathVariable("account-id") String accountId,@ApiParam(value = "ID of the request, unique to the call, as determined by the initiating party." ,required=true) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID,@ApiParam(value = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true) @RequestHeader(value="Consent-ID", required=true) String consentID,@ApiParam(value = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ) @RequestHeader(value="Digest", required=false) String digest,@ApiParam(value = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ) @RequestHeader(value="Signature", required=false) String signature,@ApiParam(value = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate,@ApiParam(value = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress,@ApiParam(value = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept", required=false) String psUAccept,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage,@ApiParam(value = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent,@ApiParam(value = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " , allowableValues="GET, POST, PUT, PATCH, DELETE") @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod,@ApiParam(value = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID,@ApiParam(value = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return getCardAccountBalances(accountId, xRequestID, consentID, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<ReadCardAccountBalanceResponse200> getCardAccountBalances(String accountId,UUID xRequestID,String consentID,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Read transaction list of an account", nickname = "getCardAccountTransactionList", notes = "Reads account data from a given card account addressed by \"account-id\". ", response = CardAccountsTransactionsResponse200.class, authorizations = {
        @Authorization(value = "BearerAuthOAuth")
    }, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = CardAccountsTransactionsResponse200.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error400NGAIS.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error401NGAIS.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error403NGAIS.class),
        @ApiResponse(code = 404, message = "Not found", response = Error404NGAIS.class),
        @ApiResponse(code = 405, message = "Method Not Allowed", response = Error405NGAIS.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = Error406NGAIS.class),
        @ApiResponse(code = 408, message = "Request Timeout"),
        @ApiResponse(code = 409, message = "Conflict", response = Error409NGAIS.class),
        @ApiResponse(code = 415, message = "Unsupported Media Type"),
        @ApiResponse(code = 429, message = "Too Many Requests", response = Error429NGAIS.class),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 503, message = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts/{account-id}/transactions",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<CardAccountsTransactionsResponse200> _getCardAccountTransactionList(@ApiParam(value = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ",required=true) @PathVariable("account-id") String accountId,@NotNull @ApiParam(value = "Permitted codes are    * \"information\",   * \"booked\",   * \"pending\", and    * \"both\" \"booked\" shall be supported by the ASPSP. To support the \"information\", \"pending\" and \"both\" feature is optional for the ASPSP, Error code if not supported in the online banking frontend ", required = true, allowableValues = "information, booked, pending, both") @Valid @RequestParam(value = "bookingStatus", required = true) String bookingStatus,@ApiParam(value = "ID of the request, unique to the call, as determined by the initiating party." ,required=true) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID,@ApiParam(value = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true) @RequestHeader(value="Consent-ID", required=true) String consentID,@ApiParam(value = "Conditional: Starting date (inclusive the date dateFrom) of the transaction list, mandated if no delta access is required and if bookingStatus does not equal \"information.  For booked transactions, the relevant date is the booking date.   For pending transactions, the relevant date is the entry date, which may not be transparent  neither in this API nor other channels of the ASPSP. ") @Valid @RequestParam(value = "dateFrom", required = false) LocalDate dateFrom,@ApiParam(value = "End date (inclusive the data dateTo) of the transaction list, default is \"now\" if not given.   Might be ignored if a delta function is used.  For booked transactions, the relevant date is the booking date.   For pending transactions, the relevant date is the entry date, which may not be transparent  neither in this API nor other channels of the ASPSP. ") @Valid @RequestParam(value = "dateTo", required = false) LocalDate dateTo,@ApiParam(value = "This data attribute is indicating that the AISP is in favour to get all transactions after  the transaction with identification entryReferenceFrom alternatively to the above defined period.  This is a implementation of a delta access.  If this data element is contained, the entries \"dateFrom\" and \"dateTo\" might be ignored by the ASPSP  if a delta report is supported.  Optional if supported by API provider. ") @Valid @RequestParam(value = "entryReferenceFrom", required = false) String entryReferenceFrom,@ApiParam(value = "This data attribute is indicating that the AISP is in favour to get all transactions after the last report access for this PSU on the addressed account. This is another implementation of a delta access-report. This delta indicator might be rejected by the ASPSP if this function is not supported. Optional if supported by API provider") @Valid @RequestParam(value = "deltaList", required = false) Boolean deltaList,@ApiParam(value = "If contained, this function reads the list of accessible payment accounts including the booking balance,  if granted by the PSU in the related consent and available by the ASPSP.  This parameter might be ignored by the ASPSP.  ") @Valid @RequestParam(value = "withBalance", required = false) Boolean withBalance,@ApiParam(value = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ) @RequestHeader(value="Digest", required=false) String digest,@ApiParam(value = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ) @RequestHeader(value="Signature", required=false) String signature,@ApiParam(value = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate,@ApiParam(value = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress,@ApiParam(value = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept", required=false) String psUAccept,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage,@ApiParam(value = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent,@ApiParam(value = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " , allowableValues="GET, POST, PUT, PATCH, DELETE") @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod,@ApiParam(value = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID,@ApiParam(value = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return getCardAccountTransactionList(accountId, bookingStatus, xRequestID, consentID, dateFrom, dateTo, entryReferenceFrom, deltaList, withBalance, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<CardAccountsTransactionsResponse200> getCardAccountTransactionList(String accountId,String bookingStatus,UUID xRequestID,String consentID,LocalDate dateFrom,LocalDate dateTo,String entryReferenceFrom,Boolean deltaList,Boolean withBalance,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Read details about a card account", nickname = "readCardAccount", notes = "Reads details about a card account.  It is assumed that a consent of the PSU to this access is already given  and stored on the ASPSP system. The addressed details of this account depends  then on the stored consent addressed by consentId, respectively the OAuth2  access token. ", response = InlineResponse2002.class, authorizations = {
        @Authorization(value = "BearerAuthOAuth")
    }, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = InlineResponse2002.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error400NGAIS.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error401NGAIS.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error403NGAIS.class),
        @ApiResponse(code = 404, message = "Not found", response = Error404NGAIS.class),
        @ApiResponse(code = 405, message = "Method Not Allowed", response = Error405NGAIS.class),
        @ApiResponse(code = 406, message = "Not Acceptable", response = Error406NGAIS.class),
        @ApiResponse(code = 408, message = "Request Timeout"),
        @ApiResponse(code = 409, message = "Conflict", response = Error409NGAIS.class),
        @ApiResponse(code = 415, message = "Unsupported Media Type"),
        @ApiResponse(code = 429, message = "Too Many Requests", response = Error429NGAIS.class),
        @ApiResponse(code = 500, message = "Internal Server Error"),
        @ApiResponse(code = 503, message = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts/{account-id}",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<InlineResponse2002> _readCardAccount(@ApiParam(value = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ",required=true) @PathVariable("account-id") String accountId,@ApiParam(value = "ID of the request, unique to the call, as determined by the initiating party." ,required=true) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID,@ApiParam(value = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true) @RequestHeader(value="Consent-ID", required=true) String consentID,@ApiParam(value = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ) @RequestHeader(value="Digest", required=false) String digest,@ApiParam(value = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ) @RequestHeader(value="Signature", required=false) String signature,@ApiParam(value = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate,@ApiParam(value = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress,@ApiParam(value = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept", required=false) String psUAccept,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding,@ApiParam(value = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage,@ApiParam(value = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent,@ApiParam(value = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " , allowableValues="GET, POST, PUT, PATCH, DELETE") @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod,@ApiParam(value = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID,@ApiParam(value = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return readCardAccount(accountId, xRequestID, consentID, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<InlineResponse2002> readCardAccount(String accountId,UUID xRequestID,String consentID,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
