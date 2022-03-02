/**
 * OrderAndChaos --- Class that implements Game interface and runs Order and Chaos Game
 * @author Noah Jean-Baptiste
 */

public class OrderAndChaos implements Game{

    /**
     * Play method to begin game loop sequence for Order and Chaos
     */
    public static void play(){
        OACBoard b;
        OACPlayer player1 = new OACPlayer("1","Order");
        OACPlayer player2 = new OACPlayer("2","Chaos");
        OACPlayer winner;

        while(true) {
            System.out.println("Welcome to the Order and Chaos game");

            b = new OACBoard();
            System.out.println(b);
            winner = moveSequence(player1, player2, b);

            System.out.println( "Player "+winner.getName() + " wins!");
            System.out.println("Would you like to play again?  [y/n]");


            if (InputValidation.validInput(new char[]{'y', 'n'}) == 'n') {
                System.out.println("Wins for Team " + player1.getTeam() + ": " + player1.getWins());
                System.out.println("Wins for Team " + player2.getTeam() + ": " + player2.getWins());
                System.out.println("Thank you for playing Order And Chaos!");
                System.out.print('\n');
                break;
            }
        }
    }

    /**
     * moveSequence begins the turn taking for the two players
     * @param p1 OACPlayer that takes the first turn
     * @param p2 OACPlayer that takes the second turn
     * @param b OACBoard the game is played on
     * @return Winner OACPlayer of the current game
     */
    public static OACPlayer moveSequence(OACPlayer p1, OACPlayer p2, OACBoard b){
        while (true) {
            move(p1, b);
            if (b.isWinFor(p1)) {
                p1.incrementWins();
                return p1;
            }else if (b.isWinFor(p2)){
                p2.incrementWins();
                return p2;
            }

            move(p2, b);
            if (b.isWinFor(p1)) {
                p1.incrementWins();
                return p1;
            }else if (b.isWinFor(p2)){
                p2.incrementWins();
                return p2;
            }
        }
    }

    /**
     * move method completes one move from user input for a player
     * @param p OACPlayer who is moving
     * @param b OACboard the game is played on
     * @return true if the move does not cause a win, false otherwise
     */
    private static void move(OACPlayer p, OACBoard b) {
        Checker checker;
        int move;

        System.out.println("It is the "+p.getTeam()+" team's turn!");
        System.out.println("Player "+p.getName()+" Enter your checker:");

        if (InputValidation.validInput(new char[] {'x','o'},true) == 'x'){
            checker = p.getCheckerX();
        } else {
            checker = p.getCheckerO();
        }

        System.out.println("Player "+p.getName()+" Enter your move:");
        move = validMove(b);

        b.addChecker(checker, move);
        System.out.println(b);
    }

    /**
     * validMove method checks to see if a move is valid or not within a game
     * @param b OACBoard the game is being played on
     * @reutn valid move from user
     */
    private static int validMove(OACBoard b) {
        int move;

        while (true){
            move = InputValidation.validInt(1, (b.getHeight() * b.getWidth()));
            if (b.isValidCell(move)) {
                return move;
            } else {
                System.out.println("Cell already Filled!\nEnter an valid move: ");
            }
        }
    }
}
