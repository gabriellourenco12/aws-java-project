package br.com.gabriellourenco12.awsproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/dog")
    public ResponseEntity<?> dogTest() {
        LOGGER.info("Test controller - dog");

        return ResponseEntity.ok("Welcome to the dogs party!");
    }

    @GetMapping("/dog/{name}")
    public ResponseEntity<?> dogTestName(@PathVariable String name) {
        LOGGER.info("Test controller - name: {}", name);

        return ResponseEntity.ok("Hello " + name + "!");
    }

    @GetMapping("/dog/{name}/{age}")
    public ResponseEntity<?> dogTestNameAge(@PathVariable String name, @PathVariable int age) {
        LOGGER.info("Test controller - name: {}, age: {}", name, age);

        if (age < 0) {
            return ResponseEntity.badRequest().body("Age must be greater than 0");
        } else if (age > 5) {
            return ResponseEntity.ok("Hello " + name + "!" + " You are very old!");
        } else {
            return ResponseEntity.ok("Hello " + name + "!" + " You are so puppy!");
        }
    }
}
