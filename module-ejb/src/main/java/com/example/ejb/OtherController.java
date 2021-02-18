package com.example.ejb;

import com.example.store.SlowStore;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class OtherController {

  @Asynchronous
  public void saveVisit(String visitInformation) {
    SlowStore.saveVisit(visitInformation);
  }
}
