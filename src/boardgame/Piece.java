package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.setBoard(board);
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColum()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for(int row = 0; row < mat.length; row++){
            for(int colum = 0; colum < mat.length; colum++){
                if(mat[row][colum]){
                    return true;
                }
            }
        }
        return false;
    }

    protected Board getBoard() {
        return board;
    }

    private void setBoard(Board board) {
        this.board = board;
    }

}
