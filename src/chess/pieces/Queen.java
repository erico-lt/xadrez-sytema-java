package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen  extends ChessPiece{    

    public Queen(Board board, Color color) {
        super(board, color);        
    }    

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];        
        Position p = new Position(0, 0);
        
        //above
        p.setValues(position.getRow() - 1, position.getColum());
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() - 1);            
        }
        if(getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }         

        //below
        p.setValues(position.getRow() + 1, position.getColum());
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 
        
        //left
        p.setValues(position.getRow(), position.getColum() - 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() - 1);
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //right
        p.setValues(position.getRow(), position.getColum() + 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setColum(p.getColum() + 1);
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        }         
        
        //diagonal superior esquerda
        p.setValues(position.getRow() - 1 , position.getColum() - 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() - 1);;
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //diagonal superior direita
        p.setValues(position.getRow() - 1 , position.getColum() + 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() + 1);;
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //diagonal inferior esquerda
        p.setValues(position.getRow() + 1 , position.getColum() - 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() - 1);;
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        //diagonal inferior direita
        p.setValues(position.getRow() + 1 , position.getColum() + 1);
        while(this.getBoard().positionExists(p) && !getBoard().thereIsApice(p)){
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() + 1);;
        }
        if(this.getBoard().positionExists(p) && isThereOpponetPiece(p)){
            mat[p.getRow()][p.getColum()] = true;
        } 

        return mat;
    } 
    
    @Override 
    public String toString(){
        return "Q";
    }
}
