/**
 * Cell --- Class that represents a container for an Object
 * @author Noah Jean-Baptiste
 */
public class Cell {
    private Object contents;

    /**
     * Constructor creates Cell with Object contents
     * @param c object that is maintained as cell contents
     */
    public Cell(Object c){
        this.contents = c;

    }

    /**
     * No-Arg Constructor creates Cell with default null contents
     */
    public Cell(){
        this.contents = null;
    }

    /**
     * getContents method gets contents of Cell
     * @return Contents of Cell
     */
    public Object getContents() {
        return contents;
    }

    /**
     * setContents method sets contents of Cell
     * @param c Object to become cell contents
     */
    public void setContents(Object c) {
        this.contents = c;
    }

    /**
     * toString method returns a string representation of a cell
     * @return cell and its contents string representation
     */
    public String toString() {
        return "Cell{" +
                "contents=" + contents +
                '}';
    }
}
