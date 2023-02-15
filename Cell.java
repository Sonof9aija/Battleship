public class Cell {
    private int row;
    private int col;
    private char status;

    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char c) {
        this.status = c;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}
