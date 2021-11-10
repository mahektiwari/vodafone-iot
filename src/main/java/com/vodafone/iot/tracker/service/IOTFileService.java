package com.vodafone.iot.tracker.service;

import java.util.Optional;

import com.vodafone.iot.tracker.response.IOTResponse;

/***
 * 
 * 
 */

public interface IOTFileService {
	
	public Optional<IOTResponse> loadCSVFile(String filePath, Character separator);
	
}
