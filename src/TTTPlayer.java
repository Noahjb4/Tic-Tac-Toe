/**
 * TTTPlayer --- Class that represents a Player for Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */

public class TTTPlayer extends Player{
    private Checker checker;

    public TTTPlayer(String c){
        super(c);

        try {
            this.checker = new Checker(c);
        } catch (IllegalArgumentException e) {
            System.out.println("Not Valid Tic Tac Toe PLayer");
        }
    }

    public Checker getChecker(){
        return this.checker;
    }

    public String toString() {
        return "TTTPlayer{" +
                "checker=" + checker.getValue() +
                ", wins=" + this.getWins() +
                '}';
    }

}