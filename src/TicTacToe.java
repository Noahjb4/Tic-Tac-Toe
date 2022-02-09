
import java.util.*;

public class TicTacToe implements Game{


    public static void play(){
        Scanner console = new Scanner(System.in);

//        int height;
//        int width;
        int size;
        TTTBoard b;
        Player player1;
        Player player2;

        System.out.println("Welcome to the Tic-Tac-Toe game \nEnter board size: ");
        size = console.nextInt();
//        while (true) {
//            if (!console.hasNextInt()) {
//                System.out.println("Please enter a valid number: ");
//            } else {
//                height = console.nextInt();
//                break;
//            }
//            console.reset();
//        }

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
        Scanner scan = new Scanner(System.in);
        int move;

        System.out.println("game.Player "+p.getChecker()+" Enter your move:");
        move = scan.nextInt();
        b.addChecker(p, move);
        System.out.println(b);
        return true;
    }
}
