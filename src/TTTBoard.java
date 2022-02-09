public class TTTBoard extends Board {

    public TTTBoard(int s){
        super(s);
    }

    public void addChecker(Player p, int loc ){
        loc -=1;
        int r = loc/super.getHeight();
        int c = loc%super.getWidth();
        super.getTiles()[r][c] = p.getChecker();
    }

    public boolean isWinFor(Player p) {

        return false;
    }


}
