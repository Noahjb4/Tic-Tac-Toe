public abstract class Board {
    private int height;
    private int width;

    private Cell[] tiles;

    public Board(int h, int w){
        this.height = h;
        this.width = w;
        this.tiles = new Cell[height*width];

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Cell();
        }
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

    public abstract boolean isTie();

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
