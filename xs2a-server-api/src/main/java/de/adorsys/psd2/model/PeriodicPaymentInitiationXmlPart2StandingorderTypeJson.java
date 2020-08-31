package de.adorsys.psd2.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.adorsys.psd2.model.DayOfExecution;
import de.adorsys.psd2.model.ExecutionRule;
import de.adorsys.psd2.model.FrequencyCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The body part 2 of a periodic payment initation request containes the execution related informations  of the periodic payment.
 */
@ApiModel(description = "The body part 2 of a periodic payment initation request containes the execution related informations  of the periodic payment. ")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-31T16:39:54.348465+03:00[Europe/Kiev]")

public class PeriodicPaymentInitiationXmlPart2StandingorderTypeJson   {
  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("executionRule")
  private ExecutionRule executionRule = null;

  @JsonProperty("frequency")
  private FrequencyCode frequency = null;

  @JsonProperty("dayOfExecution")
  private DayOfExecution dayOfExecution = null;

  public PeriodicPaymentInitiationXmlPart2StandingorderTypeJson startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid


  @JsonProperty("startDate")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public PeriodicPaymentInitiationXmlPart2StandingorderTypeJson endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")

  @Valid


  @JsonProperty("endDate")
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public PeriodicPaymentInitiationXmlPart2StandingorderTypeJson executionRule(ExecutionRule executionRule) {
    this.executionRule = executionRule;
    return this;
  }

  /**
   * Get executionRule
   * @return executionRule
  **/
  @ApiModelProperty(value = "")

  @Valid


  @JsonProperty("executionRule")
  public ExecutionRule getExecutionRule() {
    return executionRule;
  }

  public void setExecutionRule(ExecutionRule executionRule) {
    this.executionRule = executionRule;
  }

  public PeriodicPaymentInitiationXmlPart2StandingorderTypeJson frequency(FrequencyCode frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Get frequency
   * @return frequency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid


  @JsonProperty("frequency")
  public FrequencyCode getFrequency() {
    return frequency;
  }

  public void setFrequency(FrequencyCode frequency) {
    this.frequency = frequency;
  }

  public PeriodicPaymentInitiationXmlPart2StandingorderTypeJson dayOfExecution(DayOfExecution dayOfExecution) {
    this.dayOfExecution = dayOfExecution;
    return this;
  }

  /**
   * Get dayOfExecution
   * @return dayOfExecution
  **/
  @ApiModelProperty(value = "")

  @Valid

  @JsonProperty("dayOfExecution")
  public DayOfExecution getDayOfExecution() {
    return dayOfExecution;
  }

  public void setDayOfExecution(DayOfExecution dayOfExecution) {
    this.dayOfExecution = dayOfExecution;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
}    PeriodicPaymentInitiationXmlPart2StandingorderTypeJson periodicPaymentInitiationXmlPart2StandingorderTypeJson = (PeriodicPaymentInitiationXmlPart2StandingorderTypeJson) o;
    return Objects.equals(this.startDate, periodicPaymentInitiationXmlPart2StandingorderTypeJson.startDate) &&
    Objects.equals(this.endDate, periodicPaymentInitiationXmlPart2StandingorderTypeJson.endDate) &&
    Objects.equals(this.executionRule, periodicPaymentInitiationXmlPart2StandingorderTypeJson.executionRule) &&
    Objects.equals(this.frequency, periodicPaymentInitiationXmlPart2StandingorderTypeJson.frequency) &&
    Objects.equals(this.dayOfExecution, periodicPaymentInitiationXmlPart2StandingorderTypeJson.dayOfExecution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate, executionRule, frequency, dayOfExecution);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeriodicPaymentInitiationXmlPart2StandingorderTypeJson {\n");

    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    executionRule: ").append(toIndentedString(executionRule)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    dayOfExecution: ").append(toIndentedString(dayOfExecution)).append("\n");
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

