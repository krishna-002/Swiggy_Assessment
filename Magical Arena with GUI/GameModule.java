import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameModule {
    // Components for the game module
    private static JPanel gamePanel;
    private static JTextArea resultArea;
    private static JScrollPane scrollPane;
    private static Player currentPlayer;
    private static Player otherPlayer;
    private static JButton rollButton;

    // Method to start the game
    public static void startGame(JFrame frame) {
        // Create a panel for the game
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create players
        Player player1 = new Player("Player A", 50, 5, 10);
        Player player2 = new Player("Player B", 100, 10, 5);

        // Create roll button and result area
        rollButton = new JButton("Roll Dice");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        scrollPane = new JScrollPane(resultArea);

        // Create game panel
        gamePanel = createGamePanel(player1, player2);

        // Add components to the panel
        panel.add(gamePanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        panel.add(rollButton, BorderLayout.EAST);

        // Add panel to the frame
        frame.add(panel);
        frame.revalidate();
        frame.repaint();

        // Set current and other players
        currentPlayer = player1;
        otherPlayer = player2;

        // Add action listener to roll button
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Roll dice for both players
                Random random = new Random();
                int currentPlayerRoll = MathModule.rollDice();
                int otherPlayerRoll = MathModule.rollDice();

                // Calculate attack damage and defending strength
                int attackDamage = currentPlayerRoll * currentPlayer.getAttackPoints();
                int defendingStrength = otherPlayerRoll * otherPlayer.getStrength();
                int damageTaken = Math.max(0, attackDamage - defendingStrength);

                // Apply damage to the other player
                otherPlayer.takeDamage(damageTaken);

                // Update result area
                resultArea.append(currentPlayer.getName() + " attacks and rolls: " + currentPlayerRoll +
                        ". " + otherPlayer.getName() + " defends and rolls: " + otherPlayerRoll + "\n");
                resultArea.append("Attack damage: " + attackDamage + ". Defending strength: " + defendingStrength + "\n");

                // Display damage taken
                if (damageTaken > 0) {
                    resultArea.append(otherPlayer.getName() + " takes " + damageTaken + " damage.\n");
                } else {
                    resultArea.append("No damage taken.\n");
                }

                // Update player panels
                updatePlayerPanel(currentPlayer, currentPlayer.getName(), currentPlayer.getHealth());
                updatePlayerPanel(otherPlayer, otherPlayer.getName(), otherPlayer.getHealth());

                // Switch players
                Player temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;

                // Check for game over
                if (currentPlayer.getHealth() <= 0 || otherPlayer.getHealth() <= 0) {
                    rollButton.setEnabled(false);
                    resultArea.append("\nGame over!");
                    if (currentPlayer.getHealth() <= 0) {
                        resultArea.append("\n" + otherPlayer.getName() + " wins!");
                    } else {
                        resultArea.append("\n" + currentPlayer.getName() + " wins!");
                    }
                }

                // Scroll to the end of the result area
                resultArea.setCaretPosition(resultArea.getDocument().getLength());
            }
        });
    }

// Method to create the game panel
private static JPanel createGamePanel(Player player1, Player player2) {
    // Create a panel to hold player information
    JPanel playerPanel = new JPanel();
    playerPanel.setLayout(new GridLayout(2, 1)); // Set layout for two players

    // Panel for player 1
    JPanel player1Panel = new JPanel();
    player1Panel.setLayout(new GridLayout(1, 3)); // Set layout for player 1's stats
    player1Panel.setBorder(BorderFactory.createTitledBorder(player1.getName())); // Set border with player name

    // Labels for player 1's stats
    JLabel healthLabel1 = new JLabel("Health: " + player1.getHealth());
    JLabel strengthLabel1 = new JLabel("Strength: " + player1.getStrength());
    JLabel attackLabel1 = new JLabel("Attack: " + player1.getAttackPoints());

    // Add labels to player 1's panel
    player1Panel.add(healthLabel1);
    player1Panel.add(strengthLabel1);
    player1Panel.add(attackLabel1);

    // Panel for player 2 (similar to player 1)
    JPanel player2Panel = new JPanel();
    player2Panel.setLayout(new GridLayout(1, 3));
    player2Panel.setBorder(BorderFactory.createTitledBorder(player2.getName()));

    JLabel healthLabel2 = new JLabel("Health: " + player2.getHealth());
    JLabel strengthLabel2 = new JLabel("Strength: " + player2.getStrength());
    JLabel attackLabel2 = new JLabel("Attack: " + player2.getAttackPoints());

    player2Panel.add(healthLabel2);
    player2Panel.add(strengthLabel2);
    player2Panel.add(attackLabel2);

    // Add player panels to the main panel
    playerPanel.add(player1Panel);
    playerPanel.add(player2Panel);

    return playerPanel; // Return the panel containing player information
}

    // Method to update player panel
    private static void updatePlayerPanel(Player player, String name, int health) {
        if (player.getName().equals("Player A")) {
            Component[] components = ((JPanel) gamePanel.getComponent(0)).getComponents();
            ((JLabel) components[0]).setText("Health: " + health);
        } else {
            Component[] components = ((JPanel) gamePanel.getComponent(1)).getComponents();
            ((JLabel) components[0]).setText("Health: " + health);
        }
    }
}