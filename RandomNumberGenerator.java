/**
 * Created by nathan on 12/5/18.
 */
public class RandomNumberGenerator {
    public RandomNumberGenerator() {
    }

    public static int generateRandomNumber(int minNumber, int maxNumber) {
        return (int)(Math.random() * (maxNumber - minNumber + 1)) + minNumber;
    }
}
