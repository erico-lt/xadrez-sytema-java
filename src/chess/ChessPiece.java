package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.setColor(color);
    }       

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }

}
