
import java.util.*;

public class TicTacToe implements Game{


    public static void play(){


//        int height;
//        int width;
        int size;
        TTTBoard b;
        Player player1;
        Player player2;

        System.out.println("Welcome to the Tic-Tac-Toe game \nEnter board size: ");
        size = validInt(3,Integer.MAX_VALUE);

//        System.out.println("Enter board width: ");
//        width = console.nextInt();
        b = new TTTBoard(size);
        System.out.println(b);

        player1 = new Player('X');
        player2 = new Player('O');

        while (true) {
            if (move(player1, b) == false || move(player2, b) == false){
                break;
            }

        }
//        System.out.println(player1);
//        System.out.println(player2);

        //b.addChecker('X', 4);
    }

    private static boolean move(Player p, TTTBoard b) {
        int move;

        System.out.println("Player "+p.getChecker()+" Enter your move:");

        move = validInt(1,(b.getHeight()*b.getWidth()));

        b.addChecker(p, move);
        System.out.println(b);
        return true;
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
}
