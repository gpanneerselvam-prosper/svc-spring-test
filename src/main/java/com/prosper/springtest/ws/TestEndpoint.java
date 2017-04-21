package com.prosper.springtest.ws;

import com.prosper.platform.springboot.model.dto.PlatformErrorResponseDto;
import com.prosper.springtest.dto.IntroductionDTO;
import com.prosper.springtest.model.GreetingResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gpanneerselvam on 4/18/17.
 */
@RestController
@RequestMapping("/test")
public class TestEndpoint {

    // Use only the SL4J Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(TestEndpoint.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/hello")
    public ResponseEntity<String> sayHello() {
        LOGGER.info("Into sayHello method");
        return ResponseEntity.ok("Hello there stranger!");
    }

}
