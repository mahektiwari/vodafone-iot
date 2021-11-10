package com.vodafone.iot.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vodafone.iot.tracker.beans.CSVDetail;
import com.vodafone.iot.tracker.response.IOTResponse;

public interface IOTUpdateController {
	
	@PostMapping(path="/event",consumes = "application/json", produces = "application/json")
	public ResponseEntity<IOTResponse> loadCSVFile(@RequestBody CSVDetail csvDetail);
}
