package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
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
        
        //above
        p.setValues(position.getRow() - 1, position.getColum());
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  

        //below
        p.setValues(position.getRow() + 1, position.getColum());
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        
        //left
        p.setValues(position.getRow(), position.getColum() - 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  

        //right
        p.setValues(position.getRow(), position.getColum() + 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        
        //diagonal superior esquerda
        p.setValues(position.getRow() - 1, position.getColum() - 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        }  
        //diagonal superior direita
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //diagonal inferior esquerda
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //diagonal inferior direita
        p.setValues(position.getRow() + 1, position.getColum() + 1);
        if(this.getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        return mat;
    }

    @Override
    public String toString(){
        return "K";
    }
    
}
