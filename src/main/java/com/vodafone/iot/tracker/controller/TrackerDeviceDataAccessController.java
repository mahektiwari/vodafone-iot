package com.vodafone.iot.tracker.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vodafone.iot.tracker.constant.IOTConstant;
import com.vodafone.iot.tracker.response.DeviceInfoResponse;
import com.vodafone.iot.tracker.response.IOTResponse;
import com.vodafone.iot.tracker.service.IOTDeviceInfoService;

@Controller
@RequestMapping("/v2")
public class TrackerDeviceDataAccessController implements IOTDataAccessController{
		
	
	@Autowired
	IOTDeviceInfoService deviceInfoService;
	
	public ResponseEntity<?> getDeviceInfo(String ProductId, Long tstmp ){
		
		Optional<?> resp = deviceInfoService.getDeviceInfo(ProductId, tstmp);
		
		if (resp.get() instanceof DeviceInfoResponse ){
			return ResponseEntity.ok(resp.get());
		}
		//if it is not a DeviceInfoResponse definitely it is IOTResponse
		
		IOTResponse iotResponse = (IOTResponse)resp.get();
		
		HttpStatus httpstatus = HttpStatus.NOT_FOUND;
		
		if(iotResponse.getDescription().equals(IOTConstant.ERROR_DEVICE_NOT_LOCATED)) {
			httpstatus = HttpStatus.BAD_REQUEST;
		}
		else if(iotResponse.getDescription().equals(IOTConstant.ERROR_DB_EMPTY)) {
			httpstatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(httpstatus).body(iotResponse);

	}	
	

}
