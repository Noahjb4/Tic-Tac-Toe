public class CFPlayer extends Player{
    private Checker checker;

    /**
     * Constructor creates a CFPlayer with a name and wins = 0
     * @param s name of Player
     */
    public CFPlayer(String s){
        super(s);

        try {
            this.checker = new Checker(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Not Valid Tic Tac Toe PLayer");
        }
    }

    /**
     * Constructor creates a CFPlayer with a name and wins = 0
     * @param c name of Player
     */
    public CFPlayer(char c){
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
     * toString method returns a string representation of a CFPlayer
     * @return name of PLayer, their checker, and wins they have
     */
    public String toString() {
        return "CFPlayer{" +
                "checker=" + checker.getName() +
                ", wins=" + this.getWins() +
                '}';
    }
}
