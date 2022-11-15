package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

    public Pawn(Board board, Color color) {
        super(board, color);
        
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];        
        Position p = new Position(0, 0);

        if(getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsApice(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColum());
            Position p2 = new Position(position.getRow() - 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsApice(p) && getBoard().positionExists(p) && !getBoard().thereIsApice(p) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColum() - 1);
            if(getBoard().positionExists(p) && isThereOpponetPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColum() + 1);
            if(getBoard().positionExists(p) && isThereOpponetPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

        } 
        //Peças pretas
        else {
            p.setValues(position.getRow() + 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsApice(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColum());
            Position p2 = new Position(position.getRow() + 1, position.getColum());
            if(getBoard().positionExists(p) && !getBoard().thereIsApice(p) && getBoard().positionExists(p) && !getBoard().thereIsApice(p) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColum() - 1);
            if(getBoard().positionExists(p) && isThereOpponetPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColum() + 1);
            if(getBoard().positionExists(p) && isThereOpponetPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }
        }

        return mat;
       
    }  
    
    @Override
    public String toString() {
        return "P";
    }
    
}
