public abstract class Board {
    private int height;
    private int width;

    private char[][] tiles;

    public Board(int h, int w){
        this.height = h;
        this.width = w;
        this.tiles = new char[height][width];
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

    public char[][] getTiles() {
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
                if (tiles[r][c] == '\0') {
                    b += "   |";
                }else {
                    b += " "+ tiles[r][c]+ " |";
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
