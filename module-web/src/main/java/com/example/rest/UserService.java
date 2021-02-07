package com.example.rest;

import com.example.request.UpdateUserRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/members")
public interface UserService {
  String JSON_MIME_TYPE = "application/json; charset=UTF-8";

  @GET
  String listAllMembers();

  @PUT
  @Path("/updateUser")
  @Consumes({JSON_MIME_TYPE})
  @Produces({JSON_MIME_TYPE})
  Boolean updateUser(UpdateUserRequest updateUserRequest, @HeaderParam("visitInformation") String visitInformation);

  @PUT
  @Path("/updateUserAsync")
  @Consumes({JSON_MIME_TYPE})
  @Produces({JSON_MIME_TYPE})
  Boolean updateUserAsync(UpdateUserRequest updateUserRequest, @HeaderParam("visitInformation") String visitInformation);
}
