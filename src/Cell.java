public class Cell {
    private Object contents;

    public Cell(Object c){
        this.contents = c;

    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object c) {
        this.contents = c;
    }

    public String toString() {
        return "Cell{" +
                "contents=" + contents +
                '}';
    }
}
