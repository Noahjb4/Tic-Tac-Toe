import java.util.Objects;

/**
 * Player --- Abstract class that represents a Player in a Game
 * @author Noah Jean-Baptiste
 */

public abstract class Player {
    private int wins;
    private String name;

    /**
     * Constructor creates a Player with a name and wins = 0
     * @param n name of Player
     */
    public Player(String n){
        this.wins = 0;
        this.name = n;
    }

    /**
     * No-Arg Constructor creates a Player with default wins and name
     */
    public Player(){
        this.wins = 0;
        this.name = "";
    }

    /**
     * getWins method gets wins a player has
     * @return wins of player
     */
    public int getWins() {
        return wins;
    }

    /**
     * setWins method sets wins for player
     * @param wins number player wins should be set to
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * incrementWins method increases wins for player by 1
     */
    public void incrementWins() {
        this.wins++;
    }

    /**
     * getName method gets name of a player
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * setName method sets name of a player
     * @param name string player should be renamed to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * toString method returns a string representation of a Player
     * @return name of PLayer and wins they have
     */
    public String toString() {
        return "Player " + name + ": \nWins = "+wins;
    }

    /**
     * equals method determines whether two Players are equivalent
     * @param other	other Player that a player is compared to
     * @return true of they have the same name and wins, false otherwise
     */
    public boolean equals(Player other) {
        if(this.name != other.getName() || this.wins != other.getWins()){
            return false;
        }

        return true;
    }

}
