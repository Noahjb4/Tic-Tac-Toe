/**
 * TicTacToe --- Class that implements Game interface and
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
            size = validInt(3, Integer.MAX_VALUE);

            b = new TTTBoard(size);
            System.out.println(b);
            winner = moveSequence(player1, player2, b);

            if(winner == null) {
                System.out.println("No winner, The game was a tie");
                System.out.println("Would you like to play again?  [y/n]");

            } else {
                System.out.println( "Player "+winner.getName() + " wins!");
                System.out.println("Would you like to play again?  [y/n]");
            }

            if (isYesNo() == false) {
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
        b.addChecker(p, move);
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
            move = validInt(1, (b.getHeight() * b.getWidth()));
            if (b.isValidCell(move)) {
                return move;
            } else {
                System.out.println("Cell already Filled!\nEnter an valid move: ");
            }
        }
    }


    /**
     * validInt method checks and obtains user input that is an int
     * @param lBound lower bound for a valid int
     * @param uBound upper bound for a valid int
     * @reutn int from user input
     */

    private static int validInt(int lBound, int uBound){
        Scanner console = new Scanner(System.in);
        int num;

        while (true) {
            try {
                num = console.nextInt();
                if (num < lBound || num > uBound) {
                    throw new Exception("");
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number: ");
                console.nextLine();
            }
        }

        return num;
    }


    /**
     * validInt char checks and obtains user input that is an cahr
     * @reutn char from user input
     */
    private static char validChar(){
        Scanner console = new Scanner(System.in);
        char c;

        while (true) {
            try {
                c = console.next().charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid input: ");
                console.nextLine();
            }
        }

        return c;
    }

    /**
     * isYesNo method checks if a user input is y or n
     * @reutn trye if the user selected yes, false otherwise
     */

    private static boolean isYesNo(){
        char c;
        while(true) {
            c = validChar();
            if (c == 'y' || c == 'Y') {
                return true;
            } else if (c == 'n' || c == 'N') {
                return false;
            } else {
                System.out.println("Enter valid input [y/n]:");
                continue;
            }
        }
    }


}
