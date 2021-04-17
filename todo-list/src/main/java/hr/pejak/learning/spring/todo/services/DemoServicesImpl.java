package hr.pejak.learning.spring.todo.services;

import hr.pejak.learning.spring.todo.api.DemoServices;
import org.springframework.stereotype.Service;

@Service
public class DemoServicesImpl implements DemoServices {
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application";
    }
}
