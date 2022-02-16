import java.util.Scanner;

/**
 * Main --- Game controller that launches specified game
 * @author Noah Jean-Baptiste
 */

public class GameLauncher {

    /**
     * Launch method to begin game selection and running
     */
    public static void launch(){
        Scanner console = new Scanner(System.in);
        System.out.println("Select a Game [1/2]:\n1. Tic Tac Toe\n2. Order and Chaos");
        if (InputValidation.isParams('1','2')){
            TicTacToe.play();
        }else {

        }

    }

}
