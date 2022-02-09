public class Player {
    private char checker;
    private int wins;
    public Player(char c){
        this.wins = 0;
        this.checker = c;
    }

    public char getChecker(){
        return this.checker;
    }

    public String toString() {
        return "game.Player{" +
                "checker=" + checker +
                ", wins=" + wins +
                '}';
    }
}
