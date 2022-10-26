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

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.4-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package de.adorsys.psd2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.adorsys.psd2.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-06T13:00:42.214155+03:00[Europe/Kiev]")
@Validated
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

    @Operation(summary = "Read a list of card accounts", description = "Reads a list of card accounts with additional information, e.g. balance information.  It is assumed that a consent of the PSU to this access is already given and stored on the ASPSP system.  The addressed list of card accounts depends then on the PSU ID and the stored consent addressed by consentId,  respectively the OAuth2 access token.  ", security = {
        @SecurityRequirement(name = "BearerAuthOAuth")    }, tags={ "Account Information Service (AIS)" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK. In case, no card-account is accessible, the ASPSP shall return an empty array. As this is also considered a positive response, the Response Code must still be 200.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardAccountList.class))),

        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error400NGAIS.class))),

        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error401NGAIS.class))),

        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error403NGAIS.class))),

        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error404NGAIS.class))),

        @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error405NGAIS.class))),

        @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error406NGAIS.class))),

        @ApiResponse(responseCode = "408", description = "Request Timeout"),

        @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error409NGAIS.class))),

        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),

        @ApiResponse(responseCode = "429", description = "Too Many Requests", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error429NGAIS.class))),

        @ApiResponse(responseCode = "500", description = "Internal Server Error"),

        @ApiResponse(responseCode = "503", description = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<CardAccountList> _getCardAccountList(@Parameter(in = ParameterIn.HEADER, description = "ID of the request, unique to the call, as determined by the initiating party." ,required=true,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID, @Parameter(in = ParameterIn.HEADER, description = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true,schema=@Schema()) @RequestHeader(value="Consent-ID", required=true) String consentID, @Parameter(in = ParameterIn.HEADER, description = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ,schema=@Schema()) @RequestHeader(value="Digest", required=false) String digest, @Parameter(in = ParameterIn.HEADER, description = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ,schema=@Schema()) @RequestHeader(value="Signature", required=false) String signature, @Parameter(in = ParameterIn.HEADER, description = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ,schema=@Schema()) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept", required=false) String psUAccept, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent, @Parameter(in = ParameterIn.HEADER, description = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " ,schema=@Schema(allowableValues={ "GET", "POST", "PUT", "PATCH", "DELETE" }
    )) @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod, @Parameter(in = ParameterIn.HEADER, description = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ,schema=@Schema()) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return getCardAccountList(xRequestID, consentID, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<CardAccountList> getCardAccountList(UUID xRequestID,String consentID,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Read card account balances", description = "Reads balance data from a given card account addressed by  \"account-id\".   Remark: This account-id can be a tokenised identification due  to data protection reason since the path information might be  logged on intermediary servers within the ASPSP sphere.  This account-id then can be retrieved by the  \"Get card account list\" call. ", security = {
        @SecurityRequirement(name = "BearerAuthOAuth")    }, tags={ "Account Information Service (AIS)" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReadCardAccountBalanceResponse200.class))),

        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error400NGAIS.class))),

        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error401NGAIS.class))),

        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error403NGAIS.class))),

        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error404NGAIS.class))),

        @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error405NGAIS.class))),

        @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error406NGAIS.class))),

        @ApiResponse(responseCode = "408", description = "Request Timeout"),

        @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error409NGAIS.class))),

        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),

        @ApiResponse(responseCode = "429", description = "Too Many Requests", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error429NGAIS.class))),

        @ApiResponse(responseCode = "500", description = "Internal Server Error"),

        @ApiResponse(responseCode = "503", description = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts/{account-id}/balances",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<ReadCardAccountBalanceResponse200> _getCardAccountBalances(@Parameter(in = ParameterIn.PATH, description = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ", required=true, schema=@Schema()) @PathVariable("account-id") String accountId, @Parameter(in = ParameterIn.HEADER, description = "ID of the request, unique to the call, as determined by the initiating party." ,required=true,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID, @Parameter(in = ParameterIn.HEADER, description = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true,schema=@Schema()) @RequestHeader(value="Consent-ID", required=true) String consentID, @Parameter(in = ParameterIn.HEADER, description = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ,schema=@Schema()) @RequestHeader(value="Digest", required=false) String digest, @Parameter(in = ParameterIn.HEADER, description = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ,schema=@Schema()) @RequestHeader(value="Signature", required=false) String signature, @Parameter(in = ParameterIn.HEADER, description = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ,schema=@Schema()) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept", required=false) String psUAccept, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent, @Parameter(in = ParameterIn.HEADER, description = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " ,schema=@Schema(allowableValues={ "GET", "POST", "PUT", "PATCH", "DELETE" }
    )) @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod, @Parameter(in = ParameterIn.HEADER, description = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ,schema=@Schema()) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
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


    @Operation(summary = "Read transaction list of an account", description = "Reads account data from a given card account addressed by \"account-id\". ", security = {
        @SecurityRequirement(name = "BearerAuthOAuth")    }, tags={ "Account Information Service (AIS)" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardAccountsTransactionsResponse200.class))),

        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error400NGAIS.class))),

        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error401NGAIS.class))),

        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error403NGAIS.class))),

        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error404NGAIS.class))),

        @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error405NGAIS.class))),

        @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error406NGAIS.class))),

        @ApiResponse(responseCode = "408", description = "Request Timeout"),

        @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error409NGAIS.class))),

        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),

        @ApiResponse(responseCode = "429", description = "Too Many Requests", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error429NGAIS.class))),

        @ApiResponse(responseCode = "500", description = "Internal Server Error"),

        @ApiResponse(responseCode = "503", description = "Service Unavailable") })
    @RequestMapping(value = "/v1/card-accounts/{account-id}/transactions",
        produces = { "application/json", "application/problem+json" },
        method = RequestMethod.GET)
    default ResponseEntity<CardAccountsTransactionsResponse200> _getCardAccountTransactionList(@Parameter(in = ParameterIn.PATH, description = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ", required=true, schema=@Schema()) @PathVariable("account-id") String accountId, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Permitted codes are    * \"booked\",   * \"pending\",     * \"both\", \"booked\" shall be supported by the ASPSP. To support the \"pending\" and \"both\" feature is optional for the ASPSP,  Error code if not supported in the online banking frontend. If supported, \"both\" means to request transaction reports of transaction of bookingStatus either \"pending\" or \"booked\". " ,required=true,schema=@Schema(allowableValues={ "booked", "pending", "both" }
    )) @Valid @RequestParam(value = "bookingStatus", required = true) String bookingStatus, @Parameter(in = ParameterIn.HEADER, description = "ID of the request, unique to the call, as determined by the initiating party." ,required=true,schema=@Schema()) @RequestHeader(value="X-Request-ID", required=true) UUID xRequestID, @Parameter(in = ParameterIn.HEADER, description = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. " ,required=true,schema=@Schema()) @RequestHeader(value="Consent-ID", required=true) String consentID, @Parameter(in = ParameterIn.QUERY, description = "Conditional: Starting date (inclusive the date dateFrom) of the transaction list, mandated if no delta access is required and if bookingStatus does not equal \"information\".  For booked transactions, the relevant date is the booking date.   For pending transactions, the relevant date is the entry date, which may not be transparent  neither in this API nor other channels of the ASPSP. " ,schema=@Schema()) @Valid @RequestParam(value = "dateFrom", required = false) LocalDate dateFrom, @Parameter(in = ParameterIn.QUERY, description = "End date (inclusive the data dateTo) of the transaction list, default is \"now\" if not given.   Might be ignored if a delta function is used.  For booked transactions, the relevant date is the booking date.   For pending transactions, the relevant date is the entry date, which may not be transparent  neither in this API nor other channels of the ASPSP. " ,schema=@Schema()) @Valid @RequestParam(value = "dateTo", required = false) LocalDate dateTo, @Parameter(in = ParameterIn.QUERY, description = "This data attribute is indicating that the AISP is in favour to get all transactions after  the transaction with identification entryReferenceFrom alternatively to the above defined period.  This is a implementation of a delta access.  If this data element is contained, the entries \"dateFrom\" and \"dateTo\" might be ignored by the ASPSP  if a delta report is supported.  Optional if supported by API provider. " ,schema=@Schema()) @Valid @RequestParam(value = "entryReferenceFrom", required = false) String entryReferenceFrom, @Parameter(in = ParameterIn.QUERY, description = "This data attribute is indicating that the AISP is in favour to get all transactions after the last report access for this PSU on the addressed account. This is another implementation of a delta access-report. This delta indicator might be rejected by the ASPSP if this function is not supported. Optional if supported by API provider" ,schema=@Schema()) @Valid @RequestParam(value = "deltaList", required = false) Boolean deltaList, @Parameter(in = ParameterIn.HEADER, description = "Is contained if and only if the \"Signature\" element is contained in the header of the request." ,schema=@Schema()) @RequestHeader(value="Digest", required=false) String digest, @Parameter(in = ParameterIn.HEADER, description = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. " ,schema=@Schema()) @RequestHeader(value="Signature", required=false) String signature, @Parameter(in = ParameterIn.HEADER, description = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. " ,schema=@Schema()) @RequestHeader(value="TPP-Signature-Certificate", required=false) byte[] tpPSignatureCertificate, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Address", required=false) String psUIPAddress, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-IP-Port", required=false) String psUIPPort, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept", required=false) String psUAccept, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Charset", required=false) String psUAcceptCharset, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Encoding", required=false) String psUAcceptEncoding, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Accept-Language", required=false) String psUAcceptLanguage, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. " ,schema=@Schema()) @RequestHeader(value="PSU-User-Agent", required=false) String psUUserAgent, @Parameter(in = ParameterIn.HEADER, description = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE " ,schema=@Schema(allowableValues={ "GET", "POST", "PUT", "PATCH", "DELETE" }
    )) @RequestHeader(value="PSU-Http-Method", required=false) String psUHttpMethod, @Parameter(in = ParameterIn.HEADER, description = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. " ,schema=@Schema()) @RequestHeader(value="PSU-Device-ID", required=false) UUID psUDeviceID, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. " ,schema=@Schema()) @RequestHeader(value="PSU-Geo-Location", required=false) String psUGeoLocation) {
        return getCardAccountTransactionList(accountId, bookingStatus, xRequestID, consentID, dateFrom, dateTo, entryReferenceFrom, deltaList, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<CardAccountsTransactionsResponse200> getCardAccountTransactionList(String accountId,String bookingStatus,UUID xRequestID,String consentID,LocalDate dateFrom,LocalDate dateTo,String entryReferenceFrom,Boolean deltaList,String digest,String signature,byte[] tpPSignatureCertificate,String psUIPAddress,String psUIPPort,String psUAccept,String psUAcceptCharset,String psUAcceptEncoding,String psUAcceptLanguage,String psUUserAgent,String psUHttpMethod,UUID psUDeviceID,String psUGeoLocation) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Read details about a card account", description = "Reads details about a card account.  It is assumed that a consent of the PSU to this access is already given  and stored on the ASPSP system. The addressed details of this account depends  then on the stored consent addressed by consentId, respectively the OAuth2  access token. ", security = {
        @SecurityRequirement(name = "BearerAuthOAuth")    }, tags={ "Account Information Service (AIS)" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse2002.class))),

        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error400NGAIS.class))),

        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error401NGAIS.class))),

        @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error403NGAIS.class))),

        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error404NGAIS.class))),

        @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error405NGAIS.class))),

        @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error406NGAIS.class))),

        @ApiResponse(responseCode = "408", description = "Request Timeout"),

        @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error409NGAIS.class))),

        @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),

        @ApiResponse(responseCode = "429", description = "Too Many Requests", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error429NGAIS.class))),

        @ApiResponse(responseCode = "500", description = "Internal Server Error"),

        @ApiResponse(responseCode = "503", description = "Service Unavailable")})
    @RequestMapping(value = "/v1/card-accounts/{account-id}",
        produces = {"application/json", "application/problem+json"},
        method = RequestMethod.GET)
    default ResponseEntity<InlineResponse2002> _readCardAccountDetails(@Parameter(in = ParameterIn.PATH, description = "This identification is denoting the addressed (card) account.  The account-id is retrieved by using a \"Read Account List\" or \"Read Card Account list\" call.  The account-id is the \"resourceId\" attribute of the account structure.  Its value is constant at least throughout the lifecycle of a given consent. ", required = true, schema = @Schema()) @PathVariable("account-id") String accountId, @Parameter(in = ParameterIn.HEADER, description = "ID of the request, unique to the call, as determined by the initiating party.", required = true, schema = @Schema()) @RequestHeader(value = "X-Request-ID", required = true) UUID xRequestID, @Parameter(in = ParameterIn.HEADER, description = "This then contains the consentId of the related AIS consent, which was performed prior to this payment initiation. ", required = true, schema = @Schema()) @RequestHeader(value = "Consent-ID", required = true) String consentID, @Parameter(in = ParameterIn.HEADER, description = "Is contained if and only if the \"Signature\" element is contained in the header of the request.", schema = @Schema()) @RequestHeader(value = "Digest", required = false) String digest, @Parameter(in = ParameterIn.HEADER, description = "A signature of the request by the TPP on application level. This might be mandated by ASPSP. ", schema = @Schema()) @RequestHeader(value = "Signature", required = false) String signature, @Parameter(in = ParameterIn.HEADER, description = "The certificate used for signing the request, in base64 encoding.  Must be contained if a signature is contained. ", schema = @Schema()) @RequestHeader(value = "TPP-Signature-Certificate", required = false) byte[] tpPSignatureCertificate, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Address header field consists of the corresponding HTTP request  IP Address field between PSU and TPP.  It shall be contained if and only if this request was actively initiated by the PSU. ", schema = @Schema()) @RequestHeader(value = "PSU-IP-Address", required = false) String psUIPAddress, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Port header field consists of the corresponding HTTP request IP Port field between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-IP-Port", required = false) String psUIPPort, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-Accept", required = false) String psUAccept, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-Accept-Charset", required = false) String psUAcceptCharset, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-Accept-Encoding", required = false) String psUAcceptEncoding, @Parameter(in = ParameterIn.HEADER, description = "The forwarded IP Accept header fields consist of the corresponding HTTP request Accept header fields between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-Accept-Language", required = false) String psUAcceptLanguage, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Agent header field of the HTTP request between PSU and TPP, if available. ", schema = @Schema()) @RequestHeader(value = "PSU-User-Agent", required = false) String psUUserAgent, @Parameter(in = ParameterIn.HEADER, description = "HTTP method used at the PSU ? TPP interface, if available. Valid values are: * GET * POST * PUT * PATCH * DELETE ", schema = @Schema(allowableValues = {"GET", "POST", "PUT", "PATCH", "DELETE"}
    )) @RequestHeader(value = "PSU-Http-Method", required = false) String psUHttpMethod, @Parameter(in = ParameterIn.HEADER, description = "UUID (Universally Unique Identifier) for a device, which is used by the PSU, if available. UUID identifies either a device or a device dependant application installation. In case of an installation identification this ID needs to be unaltered until removal from device. ", schema = @Schema()) @RequestHeader(value = "PSU-Device-ID", required = false) UUID psUDeviceID, @Parameter(in = ParameterIn.HEADER, description = "The forwarded Geo Location of the corresponding http request between PSU and TPP if available. ", schema = @Schema()) @RequestHeader(value = "PSU-Geo-Location", required = false) String psUGeoLocation) {
        return readCardAccountDetails(accountId, xRequestID, consentID, digest, signature, tpPSignatureCertificate, psUIPAddress, psUIPPort, psUAccept, psUAcceptCharset, psUAcceptEncoding, psUAcceptLanguage, psUUserAgent, psUHttpMethod, psUDeviceID, psUGeoLocation);
    }

    // Override this method
    default ResponseEntity<InlineResponse2002> readCardAccountDetails(String accountId, UUID xRequestID, String consentID, String digest, String signature, byte[] tpPSignatureCertificate, String psUIPAddress, String psUIPPort, String psUAccept, String psUAcceptCharset, String psUAcceptEncoding, String psUAcceptLanguage, String psUUserAgent, String psUHttpMethod, UUID psUDeviceID, String psUGeoLocation) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AccountInformationServiceAisApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
