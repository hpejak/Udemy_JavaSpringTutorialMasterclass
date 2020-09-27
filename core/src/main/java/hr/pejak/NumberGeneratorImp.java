package hr.pejak;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImp implements NumberGenerator{

    private final Random random = new Random();
    private final int maxNumber = 100;

//    Public Methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
