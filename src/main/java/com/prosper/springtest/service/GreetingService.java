package com.prosper.springtest.service;

import com.prosper.springtest.dto.IntroductionDTO;
import com.prosper.springtest.exception.GreetingException;
import com.prosper.springtest.model.GreetingResponse;

/**
 * Created by gpanneerselvam on 4/20/17.
 */
public interface GreetingService {
    GreetingResponse greetIntroducers(IntroductionDTO introduction) throws GreetingException;
}
