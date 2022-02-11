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
        if (!c.equals("X") && !c.equals("x") && !c.equals("O") && !c.equals("o")){
            throw new IllegalArgumentException("Not Valid Checker: X or O");
        }
        this.setName(c.toUpperCase());
    }

    /**
     * No-Arg Constructor Throws Illegal Argument Exception
     */
    public Checker(){
        this("");
    }


}
