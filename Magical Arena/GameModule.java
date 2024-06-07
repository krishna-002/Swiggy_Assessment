import java.util.Random;

// GameModule class represents the core logic of the game
public class GameModule {
    private static Player currentPlayer;
    private static Player otherPlayer;

    // Method to start the game
    public static void startGame(Player p1, Player p2) {
        // Initialize players
        currentPlayer = p1;
        otherPlayer = p2;

        // Continue game until one player's health reaches 0
        while (currentPlayer.getHealth() > 0 && otherPlayer.getHealth() > 0) {
            Random random = new Random();
            // Roll dice for both players
            int currentPlayerRoll = rollDice(random);
            int otherPlayerRoll = rollDice(random);

            // Calculate attack damage and defending strength
            int attackDamage = currentPlayerRoll * currentPlayer.getAttackPoints();
            int defendingStrength = otherPlayerRoll * otherPlayer.getStrength();
            int damageTaken = Math.max(0, attackDamage - defendingStrength);

            // Apply damage to the defending player
            otherPlayer.takeDamage(damageTaken);

            // Display attack and defense rolls, attack damage, and damage taken
            System.out.println(currentPlayer.getName() + " attacks and rolls: " + currentPlayerRoll +
                    ". " + otherPlayer.getName() + " defends and rolls: " + otherPlayerRoll);
            System.out.println("Attack damage: " + attackDamage + ". Defending strength: " + defendingStrength);

            if (damageTaken > 0) {
                System.out.println(otherPlayer.getName() + " takes " + damageTaken + " damage.");
            } else {
                System.out.println("No damage taken.");
            }

            // Update player panels with current health
            updatePlayerPanel(currentPlayer, currentPlayer.getName(), currentPlayer.getHealth());
            updatePlayerPanel(otherPlayer, otherPlayer.getName(), otherPlayer.getHealth());

            // Swap players for the next turn
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }

        // Game over, determine winner
        System.out.println("\nGame over!");
        if (currentPlayer.getHealth() <= 0) {
            System.out.println(otherPlayer.getName() + " wins!");
        } else {
            System.out.println(currentPlayer.getName() + " wins!");
        }
    }

    // Method to simulate rolling a dice
    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }

    // Method to update player panel with current health
    private static void updatePlayerPanel(Player player, String name, int health) {
        System.out.println(name + " health: " + health);
    }
}