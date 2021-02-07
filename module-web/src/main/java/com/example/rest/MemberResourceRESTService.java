package com.example.rest;

import com.example.request.UpdateUserRequest;
import com.example.service.UserController;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/members")
@RequestScoped
public class MemberResourceRESTService {

  public static final String JSON_MIME_TYPE = "application/json; charset=UTF-8";

  @EJB
  UserController userController;

  @GET
  public String listAllMembers() {
    return "ejb call: " + userController.whoAmI();
  }

  @PUT
  @Path("/updateUser")
  @Consumes({JSON_MIME_TYPE})
  @Produces({JSON_MIME_TYPE})
  public Boolean updateUser(UpdateUserRequest updateUserRequest, @HeaderParam("visitInformation") String visitInformation) {
    return userController.updateUser(updateUserRequest, visitInformation);
  }

  @PUT
  @Path("/updateUserAsync")
  @Consumes({JSON_MIME_TYPE})
  @Produces({JSON_MIME_TYPE})
  public Boolean updateUserAsync(UpdateUserRequest updateUserRequest, @HeaderParam("visitInformation") String visitInformation) {
    return userController.updateUserAsync(updateUserRequest, visitInformation);
  }
}
