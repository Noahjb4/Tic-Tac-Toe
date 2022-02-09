public class Player {
    private Checker checker;
    private int wins;
    public Player(char c){
        this.wins = 0;
        this.checker = new Checker(c);
    }

    public char getChecker(){
        return this.checker.getValue();
    }

    public String toString() {
        return "game.Player{" +
                "checker=" + checker +
                ", wins=" + wins +
                '}';
    }
}
