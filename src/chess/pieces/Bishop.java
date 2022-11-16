package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;


public class Bishop extends ChessPiece{

    public Bishop(Board board, Color color) {
        super(board, color);        
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];        
        Position p = new Position(0, 0);
        
        //NW
        p.setValues(position.getRow() - 1, position.getColum() -1 );
        while(getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() - 1);          
        }
        if(getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //NE
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //Se
        p.setValues(position.getRow() + 1, position.getColum() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }

        //SW
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }
        return mat;
    }

    @Override 
    public String toString(){
        return "B";
    }
    
    
}
    

