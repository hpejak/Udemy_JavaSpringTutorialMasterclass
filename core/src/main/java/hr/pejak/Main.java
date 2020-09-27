package hr.pejak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Game test");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(NumberConfiguration.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        int number = numberGenerator.next();

        log.info("Number is: {}", number);


        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        String mainMessage = messageGenerator.getMainMessage();
        String resultMessage = messageGenerator.getResultMessage();

        log.info("Main message is: {} and result message is {}", mainMessage, resultMessage);


        context.close();
    }
}
