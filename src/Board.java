public abstract class Board {
    private int height;
    private int width;

    private Cell[] tiles;

    public Board(int h, int w){
        this.height = h;
        this.width = w;
        this.tiles = new Cell[height*width];
    }

    public Board(int s){
        this(s, s);
    }

    public Board(){
        this(3);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[] getTiles() {
        return tiles;
    }

    public abstract boolean isWinFor(Player p);

    public String toString() {
        String b = "+";
        for (int c = 0; c < width; c++) {
            b += "---+";
        }
        b+="\n";
        for(int r = 0; r<height; r++){
            b += "|";
            for (int c = 0; c < width; c++) {
                if (tiles[(r*3)+c] == null) {
                    b += "   |";
                }else {
                    b += " "+ tiles[(r*3)+c].getContents() + " |";
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
