public class Player {
    private String name;
    private int health;
    private int strength;
    private int attackPoints;

    // Constructor to initialize player attributes
    Player(String name, int health, int strength, int attackPoints) {
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

    // Method to reduce player's health by the given damage amount
    public void takeDamage(int damage) {
        health -= damage;
    }
}