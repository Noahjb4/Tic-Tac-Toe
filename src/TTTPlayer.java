/**
 * TTTPlayer --- Class that represents a Player for Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */

public class TTTPlayer extends Player{
    private Checker checker;

    /**
     * Constructor creates a TTTPlayer with a name and wins = 0
     * @param s name of Player
     */
    public TTTPlayer(String s){
        super(s);

        try {
            this.checker = new Checker(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Not Valid Tic Tac Toe PLayer");
        }
    }

    /**
     * Constructor creates a TTTPlayer with a name and wins = 0
     * @param c name of Player
     */
    public TTTPlayer(char c){
        this(""+c);
    }

    /**
     * getChecker method gets the checker a player has
     * @return checker of player
     */
    public Checker getChecker(){
        return this.checker;
    }

    /**
     * toString method returns a string representation of a TTTPlayer
     * @return name of PLayer, their checker, and wins they have
     */
    public String toString() {
        return "TTTPlayer{" +
                "checker=" + checker.getName() +
                ", wins=" + this.getWins() +
                '}';
    }

}