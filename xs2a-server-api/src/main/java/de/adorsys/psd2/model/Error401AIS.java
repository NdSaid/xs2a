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

package de.adorsys.psd2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Standardised definition of reporting error information according to [RFC7807]  in case of a HTTP error code 401 for AIS.
 */
@Schema(description = "Standardised definition of reporting error information according to [RFC7807]  in case of a HTTP error code 401 for AIS. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-26T13:16:54.081225+03:00[Europe/Kiev]")


public class Error401AIS   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("detail")
  private String detail = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("additionalErrors")
  @Valid
  private List<Error401AISAdditionalErrors> additionalErrors = null;

    @JsonProperty("_links")
    private Map _links = null;

  public Error401AIS type(String type) {
    this.type = type;
    return this;
  }

    /**
     * A URI reference [RFC3986] that identifies the problem type.  Remark For Future: These URI will be provided by NextGenPSD2 in future.
     *
     * @return type
     **/
    @Schema(required = true, description = "A URI reference [RFC3986] that identifies the problem type.  Remark For Future: These URI will be provided by NextGenPSD2 in future. ")
    @JsonProperty("type")
    @NotNull

    @Size(max = 70)
    public String getType() {
        return type;
    }

  public void setType(String type) {
    this.type = type;
  }

  public Error401AIS title(String title) {
    this.title = title;
    return this;
  }

    /**
     * Short human readable description of error type.  Could be in local language.  To be provided by ASPSPs.
     *
     * @return title
     **/
    @Schema(description = "Short human readable description of error type.  Could be in local language.  To be provided by ASPSPs. ")
    @JsonProperty("title")

    @Size(max = 70)
    public String getTitle() {
        return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Error401AIS detail(String detail) {
    this.detail = detail;
      return this;
  }

    /**
     * Detailed human readable text specific to this instance of the error.  XPath might be used to point to the issue generating the error in addition. Remark for Future: In future, a dedicated field might be introduced for the XPath.
     *
     * @return detail
     **/
    @Schema(description = "Detailed human readable text specific to this instance of the error.  XPath might be used to point to the issue generating the error in addition. Remark for Future: In future, a dedicated field might be introduced for the XPath. ")
    @JsonProperty("detail")

    @Size(max = 500)
    public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Error401AIS code(String code) {
    this.code = code;
      return this;
  }

    /**
     * Message codes defined for AIS for HTTP Error code 401 (UNAUTHORIZED).
     *
     * @return code
     **/
    @Schema(required = true, description = "Message codes defined for AIS for HTTP Error code 401 (UNAUTHORIZED).")
    @JsonProperty("code")
    @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error401AIS additionalErrors(List<Error401AISAdditionalErrors> additionalErrors) {
    this.additionalErrors = additionalErrors;
    return this;
  }

  public Error401AIS addAdditionalErrorsItem(Error401AISAdditionalErrors additionalErrorsItem) {
    if (this.additionalErrors == null) {
      this.additionalErrors = new ArrayList<>();
    }
    this.additionalErrors.add(additionalErrorsItem);
      return this;
  }

    /**
     * Array of Error Information Blocks.  Might be used if more than one error is to be communicated
     *
     * @return additionalErrors
     **/
    @Schema(description = "Array of Error Information Blocks.  Might be used if more than one error is to be communicated ")
    @JsonProperty("additionalErrors")
    @Valid
    public List<Error401AISAdditionalErrors> getAdditionalErrors() {
    return additionalErrors;
  }

  public void setAdditionalErrors(List<Error401AISAdditionalErrors> additionalErrors) {
      this.additionalErrors = additionalErrors;
  }

    public Error401AIS _links(Map _links) {
        this._links = _links;
        return this;
    }

    /**
     * Get _links
     *
     * @return _links
     **/
    @Schema(description = "")
    @JsonProperty("_links")

    @Valid
    public Map getLinks() {
        return _links;
  }

  public void setLinks(Map _links) {
    this._links = _links;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error401AIS error401AIS = (Error401AIS) o;
    return Objects.equals(this.type, error401AIS.type) &&
        Objects.equals(this.title, error401AIS.title) &&
        Objects.equals(this.detail, error401AIS.detail) &&
        Objects.equals(this.code, error401AIS.code) &&
        Objects.equals(this.additionalErrors, error401AIS.additionalErrors) &&
        Objects.equals(this._links, error401AIS._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, detail, code, additionalErrors, _links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error401AIS {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    additionalErrors: ").append(toIndentedString(additionalErrors)).append("\n");
    sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
