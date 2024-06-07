import java.util.Random;

public class MathModule {
    // Method to simulate rolling a dice and returning the result
    public static int rollDice() {
        return new Random().nextInt(6) + 1; // Generating a random number between 1 and 6
    }
}
