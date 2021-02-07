package com.example.service;

import com.example.request.UpdateUserRequest;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;

@Stateless
public class UserController {
  static final Logger logger = Logger.getLogger(UserController.class);

  public String whoAmI() {
    return "i'm ExampleService";
  }

  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    logger.info("updateUserRequest = " + updateUserRequest);
    return false;
  }

  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    logger.info("updateUserRequest = " + updateUserRequest);
    return true;
  }
}
