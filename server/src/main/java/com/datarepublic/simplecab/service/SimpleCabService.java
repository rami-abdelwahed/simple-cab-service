package com.datarepublic.simplecab.service;

import java.text.ParseException;


public interface SimpleCabService {

  void deleteCache();
  Integer getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions) throws ParseException;
  Integer getMedallionsSummary(String pickupDate, String... medallions) throws ParseException;
}
