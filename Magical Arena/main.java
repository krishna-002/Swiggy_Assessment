// Main class to execute the game
public class main {
    public static void main(String[] args) {
        // Create two players with their respective attributes.
        // These values can be changed as per user demand for testing purposes
        Player player1 = new Player("Player A", 50, 5, 10); // Player A with health 50, attack points 5, and strength 10
        Player player2 = new Player("Player B", 100, 10, 5); // Player B with health 100, attack points 10, and strength 5
        
        // Start the game with the created players
        GameModule.startGame(player1, player2);
    }
}
