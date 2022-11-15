package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color){
        super(board);
        this.setColor(color);        
    }       

    public void increaseMoveCount(){
        this.setMoveCount(this.getMoveCount() + 1);
    }

    public void decreseMoveCount() {
        this.setMoveCount(this.getMoveCount() - 1);
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponetPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    } 

    //metodos acessores
    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }   

    public int getMoveCount() {
        return moveCount;
    }

    private void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

}
