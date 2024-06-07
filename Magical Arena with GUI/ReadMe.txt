# Magical Arena Game

This project implements a simple turn-based game where two players battle each other in a magical arena. 
Players take turns rolling dice to determine their attack and defense strengths, and the game ends when one 
player's health reaches zero.

## Features

- Graphical user interface (GUI) built with Swing.
- Players have attributes such as health, strength, and attack points.
- Randomized dice rolls simulate attacks and defense.
- Game outcome displayed in a scrollable text area.
- Player panels dynamically update with health information during the game.

## Usage

1. **Run the Game**: Compile and run the `main` class to start the game. The GUI will open, displaying a 
     welcome message and a button to start the game.

2. **Start the Game**: Click the "Start Game" button to begin. Two players are created with predefined 
     attributes, and the game interface is displayed.

3. **Roll the Dice**: Click the "Roll Dice" button to roll the dice for your turn. The game will calculate 
     attack damage and defense strength based on the dice rolls and display the outcome in the result area.

4. **Game Over**: The game continues until one player's health reaches zero. At that point, the game declares 
     the winner and disables the "Roll Dice" button.

## Project Structure

- `main.java`: Main class to start the game.
- `GUIModule.java`: GUI module responsible for creating and displaying the game interface.
- `GameModule.java`: Game module containing the logic for starting and playing the game.
- `MathModule.java`: Utility module for generating random numbers (simulating dice rolls).
- `Player.java`: Class representing a player with attributes and methods for taking damage.

## Dependencies

This project uses the following dependencies:

- **Java Swing**: For building the graphical user interface.
- **JUnit**: For unit testing (not included in the provided code snippets).
- **Mockito**: For mocking objects in unit tests (not included in the provided code snippets).

##To run the game:

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE or text editor.
3. Compile and run the `Main.java` file.

## Contributor

- Chinni Krishna Kumari.
