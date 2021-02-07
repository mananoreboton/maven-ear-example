package com.example.rest;

import com.example.request.UpdateUserRequest;
import com.example.service.AsyncTrackingController;
import com.example.service.TrackingController;
import com.example.service.UserController;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;

@RequestScoped
public class MemberResourceRESTService implements UserService {

  @EJB
  UserController userController;

  @Override
  public String listAllMembers() {
    return "ejb call: " + userController.whoAmI();
  }

  @Override
  @Interceptors({TrackingController.class})
  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUser(updateUserRequest, visitInformation);
  }

  @Override
  @Interceptors({AsyncTrackingController.class})
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUserAsync(updateUserRequest, visitInformation);
  }
}
