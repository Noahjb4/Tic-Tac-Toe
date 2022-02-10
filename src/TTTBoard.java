/**
 * TTTBoard --- Class that represents a Board for Tic Tac Toe Game
 * @author Noah Jean-Baptiste
 */

public class TTTBoard extends Board {

    public TTTBoard(int s){
        super(s);
    }

    public boolean addChecker(TTTPlayer p, int loc ){
        loc -=1;
//        int r = loc/super.getHeight();
//        int c = loc%super.getWidth();
        if (this.isValidCell(loc+1)) {
            this.getTiles()[loc] = new Cell(p.getChecker());
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidCell(int loc){
        loc-=1;
        if (this.getTiles()[loc].getContents() == null) {
            return true;
        }
        return false;
    }

    public boolean isWinFor(Player p) {
        return horizontalWin((TTTPlayer) p) || verticalWin((TTTPlayer)p) || diagonalWin((TTTPlayer)p);
    }

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

    private boolean diagonalWin(TTTPlayer p){
        return leftDiagonalWin(p) || rightDiagonalWin(p);
    }

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

    public boolean isTie() {
        for (int i = 0; i < (this.getWidth()*this.getHeight()); i++) {
            if (this.getTiles()[i].getContents() == null){
                return false;
            }
        }
        return true;
    }


}
