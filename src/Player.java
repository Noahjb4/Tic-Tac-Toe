public class Player {
    private Checker checker;
    private int wins;
    public Player(String c){
        this.wins = 0;
        this.checker = new Checker(c);
    }

    public Checker getChecker(){
        return this.checker;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        this.wins++;
    }

    public String toString() {
        return "Player{" +
                "checker=" + checker.getValue() +
                ", wins=" + wins +
                '}';
    }
}
