package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessmtch;

    public King(Board board, Color color, ChessMatch chessmatch) {
        super(board, color);   
        this.chessmtch = chessmatch;     
    }    
    
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == this.getColor() && p.getMoveCount() == 0;
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

        //movimento especial roque pequeno
        if(getMoveCount() == 0 && !chessmtch.getCheck()) {
            Position posiT1 = new Position(position.getRow(), position.getColum() + 3);
            if(testRookCastling(posiT1)) {
                Position p1 = new Position(position.getRow(),position.getColum() + 1);
                Position p2 = new Position(position.getRow(),position.getColum() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColum() + 2] = true;
                }
            }
        }

        //movimento especial roque grande
        if(getMoveCount() == 0 && !chessmtch.getCheck()) {
            Position posiT1 = new Position(position.getRow(), position.getColum() - 4);
            if(testRookCastling(posiT1)) {
                Position p1 = new Position(position.getRow(),position.getColum() - 1);
                Position p2 = new Position(position.getRow(),position.getColum() - 2);
                Position p3 = new Position(position.getRow(),position.getColum() - 3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColum() - 2] = true;
                }
            }
        }

        return mat;
    }

    @Override
    public String toString(){
        return "K";
    }
    
}
