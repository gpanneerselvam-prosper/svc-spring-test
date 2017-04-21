package com.prosper.springtest.ws;

import com.prosper.platform.springboot.event.PlatformEventService;
import com.prosper.platform.springboot.model.dto.PlatformErrorResponseDto;
import com.prosper.springtest.dto.IntroductionDTO;
import com.prosper.springtest.exception.GreetingException;
import com.prosper.springtest.model.GreetingResponse;
import com.prosper.springtest.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gpanneerselvam on 4/20/17.
 */
@RestController
@RequestMapping("/greeting")
public class GreetingEndpoint {
    // Use only the SL4J Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(TestEndpoint.class);
    @Autowired
    @Qualifier("GreetingServiceImpl")
    private GreetingService greetingService;

    @RequestMapping(method = RequestMethod.GET, path = "/hey")
    public @ResponseBody
    GreetingResponse introduce(IntroductionDTO introduction) {
        LOGGER.info("Into introduce method");
        LOGGER.info("Introducer: {}", introduction.getName());
        return new GreetingResponse(introduction.getName());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rudehey")
    public ResponseEntity<?> badIntroduce(IntroductionDTO introduction){
        try {
            GreetingResponse response = greetingService.greetIntroducers(introduction);
            PlatformEventService.recordEvent("Introduction Succeeded", introduction.toString() + "caused the introduction service to succeed");
            return ResponseEntity.ok(response);
        } catch(GreetingException ex){
            PlatformEventService.recordEvent("Introduction Errored", introduction.toString() + "caused the introduction service to error out");
            PlatformErrorResponseDto errorResponseDto = new PlatformErrorResponseDto("bad introduction","Please introduce properly");
            return ResponseEntity.badRequest().body(errorResponseDto);
        }
    }
}
