package hr.pejak.controller;

import hr.pejak.api.GameService;
import hr.pejak.util.AttributeNames;
import hr.pejak.util.GameMappings;
import hr.pejak.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class GameController {

    // fields
    private final GameService gameService;

    //constructor
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //request methods
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE,gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE,gameService.getResultMessage());
        log.info("model {}", model);

        return  gameService.isGameOver() ? ViewNames.GAME_OVER : ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processPost(int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);

        return GameMappings.REDIRECT_PLAY;

    }

    @GetMapping(GameMappings.RESTART)
    public String restartGame() {
        log.info("Starting game again");
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }

}
