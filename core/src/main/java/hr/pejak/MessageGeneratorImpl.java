package hr.pejak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void init() {
        log.info("Game value is : {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() +
                " and " + game.getBiggest() + ". Guess which number is?";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return "Congratulation!!!! You won the game by guessing the number " + game.getNumber();
        } else if (game.isGameLost()) {
            return "Sorry. You lost the game, the number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "You're choice is not in valid range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess ?";
        } else {
            String direction = "Lower";
            String finishMessage = " guess left";

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }


            if (game.getRemainingGuesses() > 1) {
                finishMessage = " guesses left";
            }

            return direction + "! You have " + game.getRemainingGuesses() + finishMessage;
        }

    }
}
