/**
 * TicTacToe --- Class that implements Game interface and runs Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */
import java.util.*;

public class TicTacToe implements Game{

    /**
     * Play method to begin game loop sequence for Tic Tac Toe
     */
    public static void play(){

        int size;
        TTTBoard b;
        TTTPlayer player1 = new TTTPlayer("X");
        TTTPlayer player2 = new TTTPlayer("O");
        TTTPlayer winner;

        while(true) {
            System.out.println("Welcome to the Tic-Tac-Toe game \nEnter board size: ");
            size = InputValidation.validInt(3, Integer.MAX_VALUE);

            b = new TTTBoard(size);
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
     * @param p1 TTTPlayer that takes the first turn
     * @param p2 TTTPlayer that takes the second turn
     * @param b TTTboard the game is played on
     * @return Winner TTTPlayer of the current game
     */
    public static TTTPlayer moveSequence(TTTPlayer p1, TTTPlayer p2, TTTBoard b){
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
     * @param p TTTPlayer who is moving
     * @param b TTTboard the game is played on
     * @return true if the move does not cause a win, false otherwise
     */
    private static boolean move(TTTPlayer p, TTTBoard b) {
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
     * @param b TTTboard the game is being played on
     * @reutn valid move from user
     */
    private static int validMove(TTTBoard b) {
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
