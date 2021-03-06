package com.vodafone.tracker.iot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vodafone.iot.tracker.controller.CSVUploadController;
import com.vodafone.iot.tracker.controller.TrackerDeviceDataAccessController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IOTSmokeTest {

    @Autowired
    private TrackerDeviceDataAccessController trackerDeviceDataAccessController;
    
    @Autowired
    CSVUploadController csvUploadController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(trackerDeviceDataAccessController).isNotNull();
        assertThat(csvUploadController).isNotNull();
    }
}