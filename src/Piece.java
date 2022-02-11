/**
 * Piece --- Abstract class that represents a game piece
 * @author Noah Jean-Baptiste
 */

public abstract class Piece {
    private String name;

    /**
     * Constructor creates a piece with a name
     * @param n name of piece
     */
    public Piece (String n){
        this.name = n;
    }

    /**
     * No-Arg Constructor creates a piece with default no name
     */
    public Piece (){
        this("");
    }

    /**
     * getName method gets name of piece
     * @return name of piece
     */
    public String getName() {
        return name;
    }

    /**
     * setName method set name of piece
     * @param name string to change name to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * toString method returns a string representation of piece
     * @return name of piece or default (unnamed Piece)
     */
    public String toString() {
        if (this.name != "") {
            return name;
        }
        return "(Unnamed Piece)";
    }

    /**
     * equals method determines whether two pieces are equivalent
     * @param other	other Piece object that this is compared to
     * @return true of they have the same name, false otherwise
     */
    public boolean equals(Piece other) {
        if (this.name.equals(other.getName())){
            return true;
        }
        return false;
    }


}
