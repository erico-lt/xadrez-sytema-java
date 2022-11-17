package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Night extends ChessPiece{    
    
    public Night(Board board, Color color) {
        super(board, color);        
    }    
    
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];        
        Position p = new Position(0, 0);
        
        
        p.setValues(position.getRow() - 2, position.getColum() - 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  

        
        p.setValues(position.getRow() - 2, position.getColum() + 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        
        
        p.setValues(position.getRow() - 1, position.getColum() - 2);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  

        
        p.setValues(position.getRow() + 1, position.getColum() - 2);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        
        
        p.setValues(position.getRow() + 2, position.getColum() - 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  
        

        p.setValues(position.getRow() + 2, position.getColum() + 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        
        p.setValues(position.getRow() - 1, position.getColum() + 2);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        
        p.setValues(position.getRow() + 1, position.getColum() + 2);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        return mat;
    }
    
    @Override
    public String toString(){
        return "N";
    }

}
