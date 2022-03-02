/**
 * ConnectFour --- Class that implements Game interface and runs Connect Four Game
 * @author Noah Jean-Baptiste
 */

public class ConnectFour implements Game{

    /**
     * Play method to begin game loop sequence for Connect Four
     */
    public static void play(){

        CFBoard b;
        CFPlayer player1 = new CFPlayer("X");
        CFPlayer player2 = new CFPlayer("O");
        CFPlayer winner;

        while(true) {
            System.out.println("Welcome to the Connect Four game");

            b = new CFBoard();
            System.out.println(b);
            winner = moveSequence(player1, player2, b);

            if(winner == null) {
                System.out.println("No winner, The game was a tie");
                System.out.println("Would you like to play again?  [y, n]");

            } else {
                System.out.println( "Player "+winner.getName() + " wins!");
                System.out.println("Would you like to play again?  [y, n]");
            }

            if (InputValidation.validInput(new char[]{'y', 'n'}) == 'n') {
                System.out.println("Wins for Player " + player1.getName() + ": " + player1.getWins());
                System.out.println("Wins for Player " + player2.getName() + ": " + player2.getWins());
                System.out.println("Thank you for playing Tic Tac Toe!");
                break;
            }
        }
    }

    /**
     * moveSequence begins the turn taking for the two players
     * @param p1 CFPlayer that takes the first turn
     * @param p2 CFPlayer that takes the second turn
     * @param b CFboard the game is played on
     * @return Winner CFPlayer of the current game
     */
    public static CFPlayer moveSequence(CFPlayer p1, CFPlayer p2, CFBoard b){
        while (true) {
            if (move(p1, b) == false) {
                p1.incrementWins();
                return p1;
            }else if (b.isTie()){
                return null;
            }

            if (move(p2, b) == false) {
                p2.incrementWins();
                return p2;
            }else if (b.isTie()){
                return null;
            }
        }
    }

    /**
     * move method completes one move from user input for a player
     * @param p CFPlayer who is moving
     * @param b CFboard the game is played on
     * @return true if the move does not cause a win, false otherwise
     */
    private static boolean move(CFPlayer p, CFBoard b) {
        int move;

        System.out.println("Player "+p.getName()+" Enter your move:");

        move = validMove(b);
        b.addChecker(p.getChecker(), move);
        System.out.println(b);
        if (b.isWinFor(p)){
            return false;
        }
        return true;
    }

    /**
     * validMove method checks to see if a move is valid or not within a game
     * @param b CFboard the game is being played on
     * @reutn valid move from user
     */
    private static int validMove(CFBoard b) {
        int move;

        while (true){
            move = InputValidation.validInt(1, (b.getWidth()));
            if (b.isValidRow(move)) {
                return move;
            } else {
                System.out.println("Cell already Filled!\nEnter an valid move: ");
            }
        }
    }
}
