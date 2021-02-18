package com.example.cdi;

import com.example.ejb.OtherController;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Singleton
public class AsyncTrackingInterceptor {
  static final Logger logger = Logger.getLogger(AsyncTrackingInterceptor.class);
  @EJB
  OtherController otherController;

  @AroundInvoke
  public Object aroundInvoke(InvocationContext context) throws Exception {
    Object proceed = context.proceed();
    long startTime = System.currentTimeMillis();

    final String visitInformation = (String) context.getParameters()[1];
    otherController.saveVisit(visitInformation);

    long stopTime = System.currentTimeMillis();
    logger.info("Async tracking returning " + (stopTime - startTime));

    return proceed;
  }
}
