/**
 * Player --- Abstract class that represents a Player in a Game
 * @author Noah Jean-Baptiste
 */

public abstract class Player {
    private int wins;
    private String name;

    public Player(String n){
        this.wins = 0;
        this.name = n;
    }

    public Player(){
        this.wins = 0;
        this.name = "";
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        this.wins++;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Player " + name + ": \nWins = "+wins;
    }
}
