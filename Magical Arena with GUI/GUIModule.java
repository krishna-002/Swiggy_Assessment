import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUIModule {
    private static JFrame frame;
    private static JPanel infoPanel;
    private static JButton startButton;

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        // Create the main frame
        frame = new JFrame("Magical Arena Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 350);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Info Panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        // Label to display welcome message
        JLabel infoLabel = new JLabel("Welcome to the Magical Arena Game!");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Button to start the game
        startButton = new JButton("Start Game");
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(); // Call the method to start the game
            }
        });

        // Add components to the info panel
        infoPanel.add(infoLabel, BorderLayout.CENTER);
        infoPanel.add(startButton, BorderLayout.SOUTH);

        // Add the info panel to the frame
        frame.add(infoPanel);
        frame.setVisible(true); // Make the frame visible
    }

    // Method to start the game
    private static void startGame() {
        frame.remove(infoPanel); // Remove the info panel
        // Call method from another module to start the game
        GameModule.startGame(frame);
    }
}