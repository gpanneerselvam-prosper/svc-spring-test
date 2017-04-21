package com.prosper.springtest.service.impl;

import com.prosper.springtest.dto.IntroductionDTO;
import com.prosper.springtest.exception.GreetingException;
import com.prosper.springtest.model.GreetingResponse;
import com.prosper.springtest.service.GreetingService;
import org.springframework.stereotype.Service;

/**
 * Created by gpanneerselvam on 4/20/17.
 */
@Service("GreetingServiceImpl")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public GreetingResponse greetIntroducers(IntroductionDTO introduction) throws GreetingException {
        throw new GreetingException();
    }
}
