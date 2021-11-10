package com.vodafone.iot.tracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vodafone.iot.tracker.beans.CSVDetail;
import com.vodafone.iot.tracker.constant.IOTConstant;
import com.vodafone.iot.tracker.response.IOTResponse;
import com.vodafone.iot.tracker.service.IOTFileService;


@Controller
@RequestMapping("/v2")
public class CSVUploadController implements IOTUpdateController {
	
	@Autowired
	IOTFileService dataService;

	@Override
	public ResponseEntity<IOTResponse> loadCSVFile(CSVDetail csvDetail) {
		Optional<IOTResponse> resp = dataService.loadCSVFile(csvDetail.getFilepath(),csvDetail.getDelimiter());
		IOTResponse iotResponse = resp.get();
		
		if(iotResponse.getDescription().equals(IOTConstant.DATA_REFRESHED)) {
			return ResponseEntity.ok(iotResponse);
		}
		else if(iotResponse.getDescription().equals(IOTConstant.ERROR_EMPTY_FILE)) {
			return ResponseEntity.badRequest().body(iotResponse);
		}
		else if(iotResponse.getDescription().contains(IOTConstant.ERROR_TECHNICAL_EXCEP)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(iotResponse);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(iotResponse);
	}

}
