package com.example.cdi;

import com.example.store.SlowStore;
import org.apache.log4j.Logger;

import javax.inject.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Singleton
public class TrackingInterceptor {
  static final Logger logger = Logger.getLogger(TrackingInterceptor.class);

  @AroundInvoke
  public Object aroundInvoke(InvocationContext context) throws Exception {
    long startTime = System.currentTimeMillis();

    final String visitInformation = (String) context.getParameters()[1];
    SlowStore.saveVisit(visitInformation);

    long stopTime = System.currentTimeMillis();
    logger.info("tracking took " + (stopTime - startTime));

    return context.proceed();
  }
}
