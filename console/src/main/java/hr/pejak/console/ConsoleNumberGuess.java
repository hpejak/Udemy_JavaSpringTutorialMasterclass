package hr.pejak.console;

import hr.pejak.Game;
import hr.pejak.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class ConsoleNumberGuess {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    private final Game game;

    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Container ConsoleNumberGuess ready for use!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            log.info(messageGenerator.getMainMessage());
            log.info(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();


            if (game.isGameWon() || game.isGameLost()) {
                log.info(messageGenerator.getResultMessage());
                log.info("Do yoo wont to play again? y/N?");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
    }
}
