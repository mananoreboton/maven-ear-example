package com.example.store;

import org.apache.log4j.Logger;

public class SlowStore {
  static final Logger logger = Logger.getLogger(SlowStore.class);
  public static void saveVisit(String visitInformation) {
    try {
      Thread.sleep(1_000);
      logger.info(visitInformation);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
