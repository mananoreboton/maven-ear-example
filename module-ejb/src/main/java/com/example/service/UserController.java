package com.example.service;

import com.example.request.UpdateUserRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Stateless
public class UserController {
  @Inject
  TrackingController trackingController;
  @Inject
  AsyncTrackingController asyncTrackingController;

  public String whoAmI() {
    return "i'm ExampleService";
  }

  @Interceptors({TrackingController.class})
  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    long startTime = System.currentTimeMillis();
    trackingController.trackVisit(visitInformation);

    long stopTime = System.currentTimeMillis();
    System.out.println(stopTime - startTime);

    return false;
  }

  @Interceptors({AsyncTrackingController.class})
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    long startTime = System.currentTimeMillis();
    asyncTrackingController.trackVisitAsync(visitInformation);

    long stopTime = System.currentTimeMillis();
    System.out.println(stopTime - startTime);

    return true;
  }
}
