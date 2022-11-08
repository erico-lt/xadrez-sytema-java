package chess;

import boardgame.Position;

public class ChessPosition{
    private char colum;
    private int row;

    public ChessPosition(char colum, int row){
        if(colum < 'a' || colum > 'h' || row < 1 || row > 8){
            throw new ChessException("Erro instatiang ChessPosition. valid values are from a1 to h8");
        }
        this.setColum(colum);
        this.setRow(row);
    }

    //Posição de matriz
    protected Position toPosition(){
        return new Position(8 - this.getRow(), this.getColum() - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char) ('a' - position.getColum()), 8 - position.getRow());
    }

    public char getColum() {
        return colum;
    }

    private void setColum(char colum) {
        this.colum = colum;
    }

    public int getRow() {
        return row;
    }

    private void setRow(int row) {
        this.row = row;
    }

    @Override 
    public String toString(){
        return "" + this.getColum() + this.getRow();
    }

}