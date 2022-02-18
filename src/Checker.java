/**
 * Checker --- Class that extends Piece class and represents an X/O game piece
 * @author Noah Jean-Baptiste
 */

import java.util.Objects;

public class Checker extends Piece{

    /**
     * Constructor creates Cell with Object contents
     * @param c checker type
     */
    public Checker(String c) throws IllegalArgumentException {
        if (!c.equalsIgnoreCase("X") && !c.equalsIgnoreCase("O")){
            throw new IllegalArgumentException("Not Valid Checker: X or O");
        }
        this.setName(c.toUpperCase());
    }

    public Checker(char c){
        this(""+c);
    }

    /**
     * No-Arg Constructor Throws Illegal Argument Exception
     */
    public Checker(){
        this("");
    }

    public void setName(String n) {
        if (!n.equalsIgnoreCase("X") && !n.equalsIgnoreCase("O")){
            throw new IllegalArgumentException("Not Valid Checker: X or O");
        }
        super.setName(n.toUpperCase());
    }
}
