package hr.pejak.learning.spring.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Working Fine", HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }

}
