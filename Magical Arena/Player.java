// Player class represents a player in the game
public class Player {
    private String name;
    private int health;
    private int strength;
    private int attackPoints;

    // Constructor to initialize player attributes
    public Player(String name, int health, int strength, int attackPoints) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attackPoints = attackPoints;
    }

    // Getter method for player name
    public String getName() {
        return name;
    }

    // Getter method for player health
    public int getHealth() {
        return health;
    }

    // Getter method for player strength
    public int getStrength() {
        return strength;
    }

    // Getter method for player attack points
    public int getAttackPoints() {
        return attackPoints;
    }

    // Method to apply damage to the player
    public void takeDamage(int damage) {
        health -= damage;
    }
}