/**
 * OACPlayer --- Class that represents a Player for Order and Chaos
 * @author Noah Jean-Baptiste
 */

public class OACPlayer extends Player {
    private static String[] TEAMS = {"Order", "Chaos"};
    private static int ORDERWINS = 0;
    private static int CHAOSWINS = 0;
    private String team;
    private Checker checkerX;
    private Checker checkerO;

    /**
     * Constructor creates a OACPlayer with a name and wins = 0
     * @param name name of Player
     * @param t team of player
     */
    public OACPlayer(String name, String t){
        super(name);

        if (t.equalsIgnoreCase(TEAMS[0])){
            this.team = TEAMS[0];
        } else if (t.equalsIgnoreCase(TEAMS[1])){
            this.team = TEAMS[1];
        }else {
            throw new IllegalArgumentException("Not Valid OACPlayer Team: Order or Chaos");
        }

        this.checkerO = new Checker('O');
        this.checkerX = new Checker('X');
    }

    /**
     * getCheckerX method gets the X checker a player has
     * @return X checker of player
     */
    public Checker getCheckerX(){
        return this.checkerX;
    }

    /**
     * getCheckerO method gets the O checker a player has
     * @return O checker of player
     */
    public Checker getCheckerO(){
        return this.checkerO;
    }

    /**
     * getTeam method gets the team a player is in
     * @return team of player
     */
    public String getTeam() {
        return team;
    }

    /**
     * getTEAMS method gets the list possible teams
     * @return TEAMS list
     */
    public static String[] getTEAMS() {
        return TEAMS;
    }

    /**
     * getWins method gets the Wins a particular team has
     * @return Wins of player team
     */
    public int getWins() {
        if(this.getTeam() == "Order"){
            return ORDERWINS;
        }else {
            return CHAOSWINS;
        }
    }

    /**
     * incrementWins method increases wins for player team by 1
     */
    public void incrementWins() {
        if(this.getTeam() == "Order"){
            ORDERWINS++;
        }else {
            CHAOSWINS++;
        }
    }

    /**
     * setWins method sets the wins for player team
     */
    public void setWins(int wins) {
        if(this.getTeam() == "Order"){
            ORDERWINS = wins;
        }else {
            CHAOSWINS = wins;
        }
    }
}
