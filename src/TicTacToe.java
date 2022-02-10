
import java.util.*;

public class TicTacToe implements Game{


    public static void play(){


//        int height;
//        int width;
        int size;
        TTTBoard b;
        Player player1 = new Player("X");
        Player player2 = new Player("O");
        Player winner;

        while(true) {
            System.out.println("Welcome to the Tic-Tac-Toe game \nEnter board size: ");
            size = validInt(3, Integer.MAX_VALUE);

//        System.out.println("Enter board width: ");
//        width = console.nextInt();
            b = new TTTBoard(size);
            System.out.println(b);
            winner = moveSequence(player1, player2, b);

            if(winner == null) {
                System.out.println("No winner, The game was a tie");
                System.out.println("Would you like to play again?  [y/n]");

            } else {
                System.out.println("Player " + winner.getChecker().getValue() + " wins!");
                System.out.println("Would you like to play again?  [y/n]");
            }

            if (isYesNo() == false) {
                System.out.println("Wins for Player " + player1.getChecker().getValue() + ": " + player1.getWins());
                System.out.println("Wins for Player " + player2.getChecker().getValue() + ": " + player2.getWins());
                System.out.println("Thank you for playing Tic Tac Toe!");
                break;
            }
        }
    }

    public static Player moveSequence(Player p1, Player p2, TTTBoard b){
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

    private static boolean move(Player p, TTTBoard b) {
        int move;

        System.out.println("Player "+p.getChecker().getValue()+" Enter your move:");

        move = validMove(b);
        b.addChecker(p, move);
        System.out.println(b);
        if (b.isWinFor(p)){
            return false;
        }
        return true;
    }

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
