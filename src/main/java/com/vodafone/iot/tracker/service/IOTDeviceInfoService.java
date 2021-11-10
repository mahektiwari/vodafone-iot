package com.vodafone.iot.tracker.service;

import java.util.Optional;


public interface IOTDeviceInfoService {
	
	public Optional<?> getDeviceInfo(String productId, Long tstmp);

}
