package com.example.request;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class UpdateUserRequest {

  @NotNull
  private String userId;
  @NotNull
  private String operation;
  private String userStatus;
  private String userRenewal;
  private Long userCreditCardId;
  private String recurringId;

  public String getuserId() {
    return userId;
  }

  public void setuserId(String userId) {
    this.userId = userId;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getuserStatus() {
    return userStatus;
  }

  public void setuserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public String getuserRenewal() {
    return userRenewal;
  }

  public void setuserRenewal(String userRenewal) {
    this.userRenewal = userRenewal;
  }

  public Long getUserCreditCardId() {
    return userCreditCardId;
  }

  public UpdateUserRequest setUserCreditCardId(Long userCreditCardId) {
    this.userCreditCardId = userCreditCardId;
    return this;
  }

  public void setRecurringId(String recurringId) {
    this.recurringId = recurringId;
  }

  public String getRecurringId() {
    return recurringId;
  }

}
