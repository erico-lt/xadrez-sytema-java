package chess;

import boardgame.Board;
import boardgame.Position;
import boardgame.Piece;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVunerable;
    private ChessPiece promoted;

    public ChessMatch(){
        this.setBoard();
        this.initialSetup();
    }      
    
    // Metodos para retornar matriz de xadrez
    public ChessPiece[][] getPieces(){
        ChessPiece[][] matAux = new ChessPiece[this.getBoard().getRows()][this.getBoard().getColums()];
        for(int row = 0; row < this.getBoard().getRows(); row++){
            for(int colum = 0; colum < this.getBoard().getColums(); colum++){
                matAux[row][colum] = (ChessPiece) this.getBoard().piece(row, colum);
            }
        }
        return matAux;
    }

    // Metodos acessores
    public Board getBoard() {
        return board;
    }

    private void setBoard() {
        this.board = new Board(8,8);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVunerable() {
        return enPassantVunerable;
    }

    public void setEnPassantVunerable(ChessPiece enPassantVunerable) {
        this.enPassantVunerable = enPassantVunerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }

    private void initialSetup(){
        this.board.placePiece(new Rook(this.board, Color.WHITE), new Position(2,1));
        this.board.placePiece(new King(this.board, Color.BLACK), new Position(0,4));
        this.board.placePiece(new Rook(this.board, Color.WHITE), new Position(7,4));
    }
}
