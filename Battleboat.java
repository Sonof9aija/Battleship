public class Battleboat {
    private int size;
    private  boolean  orientation;
    private Cell[] spaces;

    public Battleboat(int length){
        this.size = length;
    }

    public boolean getOrientation() {
        return orientation;
    }

    public Cell[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Cell[] spaces) {
        this.spaces = spaces;
    }

    public int getSize() {
        return size;
    }
}
