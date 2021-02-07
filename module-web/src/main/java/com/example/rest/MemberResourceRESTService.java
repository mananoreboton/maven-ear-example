package com.example.rest;

import com.example.request.UpdateUserRequest;
import com.example.service.UserController;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MemberResourceRESTService implements UserService {

  @EJB
  UserController userController;

  @Override
  public String listAllMembers() {
    return "ejb call: " + userController.whoAmI();
  }

  @Override
  public Boolean updateUser(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUser(updateUserRequest, visitInformation);
  }

  @Override
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, String visitInformation) {
    return userController.updateUserAsync(updateUserRequest, visitInformation);
  }
}
