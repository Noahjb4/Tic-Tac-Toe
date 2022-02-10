/**
 * Cell --- Class that represents a container for an Object
 * @author Noah Jean-Baptiste
 */

public class Cell {
    private Object contents;

    public Cell(Object c){
        this.contents = c;

    }

    public Cell(){
        this.contents = null;
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
