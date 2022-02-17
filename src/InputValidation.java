/**
 * TicTacToe --- Class that has static methods that obtain valid user input
 * @author Noah Jean-Baptiste
 */

import java.util.Arrays;
import java.util.Scanner;

public class InputValidation {


    /**
     * validInt method checks and obtains user input that is an int
     * @param lBound lower bound for a valid int
     * @param uBound upper bound for a valid int
     * @return int from user input
     */

    public static int validInt(int lBound, int uBound){
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
     * @return char from user input
     */
    public static char validChar(){
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
     * validInput method checks if a user input is in input list
     * @param checks valid inputs that return
     * @return char of selected input
     */

    public static char validInput(char[] checks){
        char c;
        while(true) {
            c = validChar();
            for (char check : checks) {
                if (c == check) {
                    return c;
                }
            }
            System.out.println("Enter valid input "+ Arrays.toString(checks)+":");

        }
    }
}
