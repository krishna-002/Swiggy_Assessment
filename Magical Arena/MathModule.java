import java.util.Random;

// MathModule class for mathematical operations related to the game
public class MathModule {
    // Method to simulate rolling a dice
    // Returns a random number between 1 and 6
    public static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }
}