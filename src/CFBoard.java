public class CFBoard extends Board{
    private int lastMove;
    private int lastCol;
    private int totalCells;
    private int winCondition;

    public CFBoard (){
        super(6, 7);
        this.lastMove = -1;
        this.lastCol = -1;
        this.totalCells = this.getHeight()*this.getWidth();
        this.winCondition = 4;

    }

    /**
     * addChecker method add a CFChecker to a specified location on the board
     * @param c checker that is being added
     * @param loc location for checker to be added
     * @return true if Checker was added
     */
    public boolean addChecker(Checker c, int loc ){
        loc -=1;
        this.lastCol = loc;
        if (this.isValidRow(loc+1)) {
            for(int i = loc; i < (this.getHeight()*this.getWidth()); i+=this.getWidth()){
                int next = i+this.getWidth();

                if(this.isValidCell(next) == false || this.getTiles()[next].getContents() != null){
                    this.lastMove = i;
                    this.getTiles()[i] = new Cell(c);
                    break;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    /**
     * isValidCell method checks if specified cell is inside the range of the CFBoard
     * @param loc location the is being checked for validity
     * @return true if cell is valid, false otherwise
     */
    public boolean isValidCell(int loc){
        loc-=1;
        if ( 0 <= loc && loc < this.totalCells-1) {
            return true;
        }
        return false;
    }

    /**
     * isValidRow method checks if specified cell can be added to
     * @param loc row that is being checked for validity
     * @return true if cell is valid, false otherwise
     */
    public boolean isValidRow(int loc){
        loc-=1;
        if (this.getTiles()[loc].getContents() == null && loc < this.getWidth()) {
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
        return horizontalWin(((CFPlayer) p).getChecker()) || verticalWin(((CFPlayer) p).getChecker()) || diagonalWin(((CFPlayer) p).getChecker());

    }

    /**
     * horizontalWin method checks if this board is in a horizontal win state for a specified CFPLayer
     * @param check CFPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */

    private boolean horizontalWin(Checker check){
        Checker cellContents;
        int start = this.lastMove-(this.lastMove%this.getWidth());
        boolean isWin = true;

        for (int i = start; i<(start+this.getWidth()-4); i++) {
            for (int j = i; j < (i + this.winCondition); j++) {
                cellContents = (Checker) this.getTiles()[j].getContents();
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
     * verticalWin method checks if this board is in a vertical win state for a specified CFPLayer
     * @param check CFPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean verticalWin(Checker check){
        Checker cellContents;
        int start = this.lastCol;
        int end = start+((this.getHeight()-1)*this.getWidth()) - (this.getWidth()*(this.winCondition-1));
        boolean isWin = true;

        for (int i = start; i<=end; i+=this.getWidth()) {
            for (int j = i; j < (i + (this.winCondition*this.getWidth())); j+=this.getWidth()) {
                cellContents = (Checker) this.getTiles()[j].getContents();
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
     * diagonalWin method checks if this board is in a diagonal win state for a specified CFPLayer
     * @param check CFPlayer that is being checked for winning
     * @return true if specified player won, false otherwise
     */
    private boolean diagonalWin(Checker check){
        return leftDiagonalWin(check) || rightDiagonalWin(check);
    }

    /**
     * leftDiagonalWin method checks if this board is in a leftDiagonal win state for a specified CFPLayer
     * @param check CFPlayer that is being checked for winning
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
     * rightDiagonalWin method checks if this board is in a RightDiagonal win state for a specified CFPLayer
     * @param check CFPlayer that is being checked for winning
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
