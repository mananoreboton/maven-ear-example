package com.example.service;

import com.example.request.UpdateUserRequest;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class UserController {
  static final Logger logger = Logger.getLogger(UserController.class);

  public String whoAmI() {
    return "i'm ExampleService";
  }

  @Interceptors({TrackingController.class})
  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    logger.info("updateUserRequest = " + updateUserRequest);
    return false;
  }

  @Interceptors({AsyncTrackingController.class})
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    logger.info("updateUserRequest = " + updateUserRequest);
    return true;
  }
}
