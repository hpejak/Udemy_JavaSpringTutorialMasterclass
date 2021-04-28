package hr.pejak.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Decoupled {

    // fields
    private final SpringResourceTemplateResolver templateResolver;


    // constructor
    public Decoupled(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // methods
    @PostConstruct
    public void init() {
        templateResolver.setUseDecoupledLogic(true);
        log.info("Decoupled logic enabled");
    }
}
