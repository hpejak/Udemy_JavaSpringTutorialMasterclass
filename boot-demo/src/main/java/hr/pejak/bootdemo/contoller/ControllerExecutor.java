package hr.pejak.bootdemo.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ControllerExecutor {

    @ResponseBody
    @GetMapping("health_check")
    public String healthCheck(){
        log.info("Health check done!");
        return "It Works";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("welcome method called");
        model.addAttribute("message", "Welcome to Spring Boot");

        return "welcome";
    }

}
