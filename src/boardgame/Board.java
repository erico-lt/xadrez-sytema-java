package boardgame;

import chess.ChessPosition;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums){
        if(rows < 1 || colums < 1){
            throw new BoardException("Erro creating board: there must be at least 1 row and 1 colum");
        }
        this.setRows(rows);
        this.setColums(colums);
        this.setPieces(this.getRows(), this.getColums());
    }

    public Piece piece(int row, int colum){
        if(!positionExists(row, colum)){
            throw new BoardException("Erro: position not on the board");
        }
        return pieces[row][colum];
    }

    public Piece piece(Position position){  
        if(!positionExists(position)){
            throw new BoardException("Erro: position not on the board");
        }      
        return pieces[position.getRow()][position.getColum()];
    }    

    public void placePiece(Piece piece, Position position){
        if(thereIsApice(position)){
            throw new BoardException("Erro: there is already a piece on position " + position);
        }
        this.pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Erro: position not on the board");
        }
        if(piece(position) == null){
            return null;
        }

        Piece aux = piece(position);
        aux.position = null;
        this.pieces[position.getRow()][position.getColum()] = null;
        return aux;
    }    

    public boolean positionExists(int row, int colum){
       return  row >= 0 && row < this.getRows() && colum >= 0 && colum < this.getColums();
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColum());
    }

    public boolean thereIsApice(Position position){
        if(!positionExists(position)){
            throw new BoardException("Erro: position not on the board");
        }   
       return  piece(position) != null;
    }

    // Metodos acessores
    public int getRows() {
        return rows;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return colums;
    }

    private void setColums(int colums) {
        this.colums = colums;
    }
    
    private void setPieces(int rows, int colums) {
        this.pieces = new Piece[rows][colums];
    }   

}
