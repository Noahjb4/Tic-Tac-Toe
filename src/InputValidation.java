/**
 * TicTacToe --- Class that has static methods that obtain valid user input
 * @author Noah Jean-Baptiste
 */

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
     * isParams method checks if a user input is check1 or check2
     * @param check1 valid input that returns true
     * @param check2 valid input that returns false
     * @return true if the user selected check1, false if user selected check2
     */

    public static boolean isParams(char check1, char check2){
        char c;
        while(true) {
            c = validChar();
            if (c == check1) {
                return true;
            } else if (c == check2) {
                return false;
            } else {
                System.out.println("Enter valid input ["+check1+"/" +check2+"]:");
                continue;
            }
        }
    }
}
