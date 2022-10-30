package boardgame;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums){
        this.setRows(rows);
        this.setColums(colums);
        this.setPieces(this.getRows(), this.getColums());
    }

    public Piece piece(int row, int colum){
        return pieces[row][colum];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColum()];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
    }
    
    public void setPieces(int rows, int colums) {
        this.pieces = new Piece[rows][colums];
    }

    public Piece[][] getPieces() {
        return pieces;
    }

}
