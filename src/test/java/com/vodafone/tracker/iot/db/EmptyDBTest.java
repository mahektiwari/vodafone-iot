package com.vodafone.tracker.iot.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vodafone.iot.tracker.response.IOTResponse;
import com.vodafone.iot.tracker.service.IOTDeviceInfoService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmptyDBTest {

	
	@Autowired
	IOTDeviceInfoService deviceInfoService;

	

	@Test
	void shouldReturnError_Message_Database_not_yet_loaded_WhenDatabaseEmpty(){

		Long tstmp = 1582605077000L;
		
		Optional<?> response = deviceInfoService.getDeviceInfo("WG11155639", tstmp);
		IOTResponse iotResp = (IOTResponse) response.get();
		assertEquals("ERROR: Database not yet loaded", iotResp.getDescription());

	}
	
}
