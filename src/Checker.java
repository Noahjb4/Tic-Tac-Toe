/**
 * Checker --- Class that extends Piece class and represents an X/O game piece
 * @author Noah Jean-Baptiste
 */

import java.util.Objects;

public class Checker extends Piece{
    private String value;

    public Checker(String c) throws IllegalAccessException {
        if (!c.equals("X") || !c.equals("x") || !c.equals("O") || !c.equals("o")){
            throw new IllegalAccessException("Not Valid Checker: X or O");
        }
        this.value = c.toUpperCase();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean equals(Checker c) {
       if (this.value.equals(c.getValue())){
           return true;
       }
       return false;
    }

}
