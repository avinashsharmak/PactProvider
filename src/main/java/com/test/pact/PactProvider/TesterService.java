package com.test.pact.PactProvider;

import org.springframework.stereotype.Service;

@Service
public class TesterService {

 public Tester getTester(Tester tester){

         return new Tester("myName", "Pune");

 }
}
