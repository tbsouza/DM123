package br.com.siecola.aws_project01.controller;

import br.com.siecola.aws_project01.AwsProject01Application;
import br.com.siecola.aws_project01.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(AwsProject01Application.class);

    //@Autowired
    private TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @RequestMapping("/dog/{name}")
    public ResponseEntity<?> dogTest(@PathVariable String name){
        log.info("Thiago Souza Controller - dog name: {}", name);
        log.info("Is matilde? - {}", testService.isUserMatilde(name));

        return ResponseEntity.ok("Dog name: " + name);
    }

    @RequestMapping("/dogcolor/{color}")
    public ResponseEntity<?> dogColor(@PathVariable String color){
        log.info("Thiago Souza Controller - dog color: {}", color);
        //log.info("Is black? - {}", testService.isUserMatilde(color));

        return ResponseEntity.ok("Dog color: " + color);
    }

}
