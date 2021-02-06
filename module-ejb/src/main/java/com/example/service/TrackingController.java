package com.example.service;

import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class TrackingController {
  static final Logger logger = Logger.getLogger(TrackingController.class);

  public void trackVisit(String visitInformation) {
    try {
      Thread.sleep(5_000);
      logger.info(visitInformation);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @AroundInvoke
  public Object aroundInvoke(InvocationContext context) throws Exception {
    String visitInformation = (String) context.getParameters()[0];
    trackVisit(visitInformation);
    return context.proceed();
  }
}
