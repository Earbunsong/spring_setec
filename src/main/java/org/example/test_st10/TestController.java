package org.example.test_st10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String test() {
        return "Hello bunsong ST10";
    }

    public static void main(String[] args) {

    }
}
