/**
 * TTTPlayer --- Class that represents a Player for Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */

public class TTTPlayer extends Player{
    private Checker checker;

    public TTTPlayer(String c){
        super(c);
        this.checker = new Checker(c);

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