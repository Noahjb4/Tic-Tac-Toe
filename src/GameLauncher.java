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

        while (true) {
            Scanner console = new Scanner(System.in);
            System.out.println("Select a Game:\n1. Tic Tac Toe\n2. Order and Chaos\n3. Connect Four\n4. Quit");
            char input = InputValidation.validInput(new char[]{'1', '2', '3', '4'});
            if (input == '1') {
                TicTacToe.play();
            } else if (input == '2') {
                OrderAndChaos.play();
            } else if (input == '3') {
                ConnectFour.play();
            } else if (input == '4') {
                System.out.println("Thank you for Playing!");
                break;
            }
        }

    }

}
