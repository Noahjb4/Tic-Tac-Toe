public class TTTBoard extends Board {

    public TTTBoard(int s){
        super(s);
    }

    public boolean addChecker(Player p, int loc ){
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
        return horizontalWin(p) || verticalWin(p) || diagonalWin(p);
    }

    private boolean horizontalWin(Player p){
        boolean isWin = true;
        for(int r = 0; r<this.getHeight(); r++){
            isWin = true;
            for (int c = 0; c < this.getWidth(); c++) {
                Object cellContents = super.getTiles()[(r*this.getWidth())+c].getContents();
                if (cellContents != null) {
                    isWin = isWin && (cellContents.equals(p.getChecker()));
                } else {
                    isWin = false;
                }
            }
            if (isWin == true){
                return true;
            }
        }
        return isWin;
    }

    private boolean verticalWin(Player p){
        boolean isWin = true;
        for(int c = 0; c< this.getWidth(); c++){
            isWin = true;
            for (int r = 0; r < this.getHeight(); r++) {
                //System.out.println((r*getHeight())+c);
                Object cellContents = super.getTiles()[(r*this.getHeight())+c].getContents();
                if (cellContents != null) {
                    isWin = isWin && (cellContents.equals(p.getChecker()));
                } else {
                    isWin = false;
                }
            }
            if (isWin == true){
                return true;
            }
        }
        return isWin;
    }

    private boolean diagonalWin(Player p){
        return leftDiagonalWin(p) || rightDiagonalWin(p);
    }

    private boolean leftDiagonalWin(Player p){
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

    private boolean rightDiagonalWin(Player p){
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
