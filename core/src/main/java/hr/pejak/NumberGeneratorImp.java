package hr.pejak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImp implements NumberGenerator{

    private final Random random = new Random();
    private final int maxNumber;
    private final int minNumber;

    //  Constructor
    @Autowired
    public NumberGeneratorImp(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //  Public Methods
    @Override
    public int next() {
        return random.nextInt((maxNumber-minNumber) + minNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
