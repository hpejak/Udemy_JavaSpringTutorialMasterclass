package hr.pejak.config;

import hr.pejak.GuessCount;
import hr.pejak.MaxNumber;
import hr.pejak.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber:60}")
    private int maxNumber;

    @Value("${game.guessCount:7}")
    private int guessCount;

    @Value("${game.minNumber:2}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){ return minNumber; }

}
