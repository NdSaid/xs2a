package de.adorsys.psd2.model;

import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * An identification provided by the ASPSP for the later identification of the authentication method selection.
 */
@ApiModel(description = "An identification provided by the ASPSP for the later identification of the authentication method selection. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-24T13:41:46.273636+03:00[Europe/Kiev]")

public class AuthenticationMethodId   {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
}
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationMethodId {\n");

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

