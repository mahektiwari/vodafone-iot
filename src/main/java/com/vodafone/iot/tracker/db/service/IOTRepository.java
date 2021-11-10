/**
 * 
 */
package com.vodafone.iot.tracker.db.service;

import java.util.List;

import com.vodafone.iot.tracker.beans.DeviceDetails;
import com.vodafone.iot.tracker.exception.IOTException;

/**
 * This is repository interface to retrieve and save device list for this application
 */
public interface IOTRepository {
	
	public int saveOrUpdate(List<DeviceDetails> deviceDetailList);
	
	public List<DeviceDetails> getDeviceList(String productId) throws IOTException;	

}
