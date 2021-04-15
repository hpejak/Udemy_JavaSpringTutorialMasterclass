package hr.pejak.learning.spring.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
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
    public String welcome(Model model) {
        model.addAttribute("user", "Jack");

        log.info("Model is {}",model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcome Message called");
        return "Welcome to this test";
    }

}
