/**
 * Board --- Abstract class that represents a grid of Cells
 * @author Noah Jean-Baptiste
 */

public abstract class Board {
    private int height;
    private int width;

    private Cell[] tiles;

    /**
     * Constructor creates Cell array of specified size
     * @param h height of the board
     * @param w width of the board
     */
    public Board(int h, int w){
        this.height = h;
        this.width = w;
        this.tiles = new Cell[height*width];

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Cell();
        }
    }

    /**
     * Constructor creates Cell array of specified size
     * @param s width and height (size) of board
     */
    public Board(int s){
        this(s, s);
    }

    /**
     * No-Arg Constructor creates Cell array of default size (3x3)
     */
    public Board(){
        this(3);
    }

    /**
     * getHeight method gets height of board
     * @return height cell array
     */
    public int getHeight() {
        return height;
    }

    /**
     * getWidth method gets width of board
     * @return width of cell array
     */
    public int getWidth() {
        return width;
    }

    /**
     * getTiles method gets contents of board
     * @return Cell array of board
     */
    public Cell[] getTiles() {
        return tiles;
    }

    /**
     * isWinFor abstract method checks for a win
     * @param p Player that is being checked for winning
     * @return true if specified Player has won the game
     */
    public abstract boolean isWinFor(Player p);

    /**
     * isTie abstract method returns true if the game is tied
     */
    public abstract boolean isTie();

    /**
     * toString method returns a string representation of board and its contents
     * @return contents of cell array divided by ASCII boarders
     */
    public String toString() {
        String b = "+";
        for (int c = 0; c < width; c++) {
            b += "---+";
        }
        b+="\n";
        for(int r = 0; r<height; r++){
            b += "|";
            for (int c = 0; c < width; c++) {
                if (tiles[(r*width)+c].getContents() == null) {
                    b += "   |";
                }else {
                    b += " "+ tiles[(r*width)+c].getContents() + " |";
                }
            }

            b +="\n+";
            for (int c = 0; c < width; c++) {
                b += "---+";
            }
            b+="\n";

        }

        return b;
    }
}
