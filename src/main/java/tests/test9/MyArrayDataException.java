package tests.test9;

public class MyArrayDataException extends Exception {

    private final int row;

    private final int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public MyArrayDataException(int row, int col) {
        this.row = row;
        this.col = col;
    }

}
