/**
 * OACBoard --- Class that represents a Board for Order and Chaos
 * @author Noah Jean-Baptiste
 */

import java.util.Arrays;

public class OACBoard extends Board{

    private int lastMove;

    public OACBoard (){
        super(6);
        this.lastMove = -1;

    }

    /**
     * addChecker method add a OACChecker to a specified location on the board
     * @param c checker that is being added
     * @param loc location for checker to be added
     * @return true if Checker was added
     */
    public boolean addChecker(Checker c, int loc ){
        loc -=1;
        this.lastMove = loc;
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
        if (((OACPlayer) p).getTeam() == "Order"){
            return isWinForOrder();
        } else {
            return isWinForChaos();
        }

    }

    /**
     * isWinForChaos method checks if this board is in a win state for team chaos
     * @return true if all tiles are filled
     */
    public boolean isWinForChaos(){
        for (Cell c : this.getTiles()) {
            if(c.getContents() == null){
                return false;
            }
        }

        return true;
    }

    /**
     * isWinForChaos method checks if this board is in a win state for team Order
     * @return true if there is 5 or 6 in a row anywhere for any checker
     */
    public boolean isWinForOrder(){
        Checker checkerO = new Checker('O');
        Checker checkerX = new Checker('X');
        boolean xWin = horizontalWin(checkerX) || verticalWin(checkerX)||diagonalWin(checkerX);
        boolean oWin = horizontalWin(checkerO) || verticalWin(checkerO)||diagonalWin(checkerO);
        return xWin || oWin;
    }

    /**
     * horizontalWin method checks if this board is in a horizontal win state for a specified OACPLayer
     * @param check OACPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */

    private boolean horizontalWin(Checker check){
        Checker cellContents;
        int start = this.lastMove-(this.lastMove%this.getWidth());
        boolean isWin = true;

        for (int offset = 0; offset<2; offset++) {
            start +=offset;
            for (int i = start; i < (start + (this.getWidth() - 1)); i++) {
                cellContents = (Checker) this.getTiles()[i].getContents();
                if (cellContents == null || !cellContents.equals(check)) {
                    isWin = false;
                    break;
                }
            }
            if (isWin){
                return true;
            }isWin = true;
        }

        return false;
    }
    /**
     * verticalWin method checks if this board is in a vertical win state for a specified OACPLayer
     * @param check OACPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean verticalWin(Checker check){
        Checker cellContents;
        int start = this.lastMove%this.getWidth();
        boolean isWin = true;

        for (int offset = 0; offset<2; offset++) {
            start +=(offset*this.getHeight());
            for (int i = 0; i < (this.getHeight() - 1); i++) {
                cellContents = (Checker) this.getTiles()[(i*this.getHeight())+start].getContents();
                if (cellContents == null || !cellContents.equals(check)) {
                    isWin = false;
                    break;
                }
            }
            if (isWin){
                return true;
            }isWin = true;
        }

        return false;
    }

    /**
     * diagonalWin method checks if this board is in a diagonal win state for a specified OACPLayer
     * @param check OACPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean diagonalWin(Checker check){
        return leftDiagonalWin(check) || rightDiagonalWin(check);
    }

    /**
     * leftDiagonalWin method checks if this board is in a leftDiagonal win state for a specified OACPLayer
     * @param check OACPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean leftDiagonalWin(Checker check){
        Checker cellContents;
        boolean isWin = true;
        int[] possible = {0,1,this.getWidth(), this.getWidth()+1};
        for (int start : possible) {
            for (int i = 0; i < (this.getWidth() - 1); i++) {
                cellContents = (Checker) this.getTiles()[(i*(this.getWidth()+1))+start].getContents();
                if (cellContents == null || !cellContents.equals(check)) {
                    isWin = false;
                    break;
                }
            }
            if(isWin) {
                return true;
            } isWin = true;
        }
        return false;

    }

    /**
     * rightDiagonalWin method checks if this board is in a RightDiagonal win state for a specified OACPLayer
     * @param check OACPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean rightDiagonalWin(Checker check){
        Checker cellContents;
        boolean isWin = true;
        int[] possible = {this.getWidth()-1, this.getWidth()-2,(this.getWidth()*2)-1,(this.getWidth()*2)-2};
        for (int start : possible) {
            for (int i = 0; i < (this.getWidth() - 1); i++) {
                cellContents = (Checker) this.getTiles()[(i*(this.getWidth()-1))+start].getContents();
                if (cellContents == null || !cellContents.equals(check)) {
                    isWin = false;
                    break;
                }
            }
            if(isWin) {
                return true;
            } isWin = true;
        }
        return false;
    }


    /**
     * isTie method checks if the game ended in a tie
     * @return false as there are no ties in OAC
     */
    public boolean isTie() {
        return false;
    }
}
