package com.example.rest;

import com.example.request.UpdateUserRequest;
import com.example.cdi.AsyncTrackingInterceptor;
import com.example.cdi.TrackingInterceptor;
import com.example.ejb.UserController;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;

@RequestScoped
public class UserServiceImpl implements UserService {

  @EJB
  UserController userController;

  @Override
  public String listAllMembers() {
    return "ejb call: " + userController.whoAmI();
  }

  @Override
  @Interceptors({TrackingInterceptor.class})
  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUser(updateUserRequest, visitInformation);
  }

  @Override
  @Interceptors({AsyncTrackingInterceptor.class})
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUserAsync(updateUserRequest, visitInformation);
  }
}
