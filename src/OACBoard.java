public class OACBoard extends Board{


    public OACBoard (){
        super(6);

    }

    /**
     * addChecker method add a TTTChecker to a specified location on the board
     * @param p player whose checker is being added
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
    public boolean isWinFor(Player p) {
        return false;
    }

    public boolean isTie() {
        return false;
    }
}
