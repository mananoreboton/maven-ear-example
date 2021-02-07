package com.example.service;

import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Singleton
public class AsyncTrackingController {
  static final Logger logger = Logger.getLogger(AsyncTrackingController.class);
  @EJB
  OtherController otherController;

  @AroundInvoke
  public Object aroundInvoke(InvocationContext context) throws Exception {
    long startTime = System.currentTimeMillis();

    final String visitInformation = (String) context.getParameters()[1];
    otherController.saveVisit(visitInformation);

    long stopTime = System.currentTimeMillis();
    logger.info("tracking took " + (stopTime - startTime));

    return context.proceed();
  }
}
