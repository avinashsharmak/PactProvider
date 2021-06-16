package com.test.pact.PactProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TesterController {
    @Autowired
    TesterService testerService;

    @PostMapping (value = "/tester", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tester fetchTester(@RequestBody Tester tester){

        return testerService.getTester(tester);

    }


}
