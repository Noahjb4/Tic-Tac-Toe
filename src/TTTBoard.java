/**
 * TTTBoard --- Class that represents a Board for Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */

public class TTTBoard extends Board {

    /**
     * Constructor creates Cell array of specified size
     * @param s size of the board
     */
    public TTTBoard(int s){
        super(s);
    }

    /**
     * addChecker method add a TTTChecker to a specified location on the board
     * @param c checker that is being added
     * @param loc location for checker to be added
     * @return true if Checker was added
     */
    public boolean addChecker(Checker c, int loc ){
        loc -=1;
//        int r = loc/super.getHeight();
//        int c = loc%super.getWidth();
        if (this.isValidCell(loc+1)) {
            this.getTiles()[loc] = new Cell(c);
            return true;
        } else {
            return false;
        }
    }

    /**
     * isValidCell method checks if specified cell can be added to
     * @param loc location the is being checked for validity
     * @return true if cell is valid, false otherwise
     */
    public boolean isValidCell(int loc){
        loc-=1;
        if (this.getTiles()[loc].getContents() == null) {
            return true;
        }
        return false;
    }

    /**
     * isWinFor method checks if this board is in a win state for a specified PLayer
     * @param p Player that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    public boolean isWinFor(Player p) {
        return horizontalWin((TTTPlayer) p) || verticalWin((TTTPlayer)p) || diagonalWin((TTTPlayer)p);
    }

    /**
     * horizontalWin method checks if this boared is in a horizontal win state for a specified TTTPLayer
     * @param p TTTPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean horizontalWin(TTTPlayer p){
        boolean isWin = true;
        for(int i = 0; i<(this.getHeight()*this.getWidth()); i++){
            Object cellContents = super.getTiles()[i].getContents();
            if (cellContents != null) {
                isWin = isWin && (cellContents.equals(p.getChecker()));
            } else {
                isWin = false;
            }

            if (i%this.getWidth() == this.getWidth()-1) {
                if (isWin == true) {
                    return true;
                }
                isWin = true;
            }
        }
        return false;
    }


    /**
     * verticalWin method checks if this bored is in a vertical win state for a specified TTTPLayer
     * @param p TTTPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean verticalWin(TTTPlayer p){
        boolean isWin = true;
        int col = 0;
        for(int i = 0; i<(this.getHeight()*this.getWidth()); i++){
            Object cellContents = super.getTiles()[((i%this.getHeight())*this.getHeight())+col].getContents();
            if (cellContents != null) {
                isWin = isWin && (cellContents.equals(p.getChecker()));
            } else {
                isWin = false;
            }
            if (i%this.getHeight() == this.getHeight()-1) {
                if (isWin == true) {
                    return true;
                }
                col++;
                isWin = true;
            }
        }
        return false;
    }

    /**
     * diagonalWin method checks if this bored is in a diagonal win state for a specified TTTPLayer
     * @param p TTTPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean diagonalWin(TTTPlayer p){
        return leftDiagonalWin(p) || rightDiagonalWin(p);
    }

    /**
     * leftDiagonalWin method checks if this bored is in a leftDiagonal win state for a specified TTTPLayer
     * @param p TTTPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean leftDiagonalWin(TTTPlayer p){
        boolean isWin = true;
        int offset = 0;
        for(int i = 0; i<this.getWidth(); i++){
            Object cellContents = this.getTiles()[(i*this.getWidth())+offset].getContents();
            //System.out.println((i*this.getWidth())+offset);
            if (cellContents != null) {
                isWin = isWin && (cellContents.equals(p.getChecker()));
                offset++;
            } else {
                isWin = false;
                break;
            }
        }

        return isWin;
    }

    /**
     * rightDiagonalWin method checks if this bored is in a RightDiagonal win state for a specified TTTPLayer
     * @param p TTTPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean rightDiagonalWin(TTTPlayer p){
        boolean isWin = true;
        int offset = 2;
        for(int i = 0; i<this.getWidth(); i++){
            Object cellContents = this.getTiles()[(i*this.getWidth())+offset].getContents();
            if (cellContents != null) {
                isWin = isWin && (cellContents.equals(p.getChecker()));
                offset--;
            } else {
                isWin = false;
                break;
            }
        }

        return isWin;
    }

    /**
     * isTie method checks if this bored is filled up before a win
     * @return true if the game is a tie
     */
    public boolean isTie() {
        for (Cell c: this.getTiles()) {
            if (c.getContents() == null){
                return false;
            }
        }
        return true;
    }


}
