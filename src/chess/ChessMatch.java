package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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

    private List<Piece> _piecesOnTheBoard = new ArrayList<>();
    private List<Piece> _capturedPieces = new ArrayList<>();

    public ChessMatch(){
        this.setTurn(1);
        this.setCurrentPlayer(Color.WHITE);
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return this.board.piece(position).possibleMoves();
    }

    //Metodo para mover pecas
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if(testCheck(this.getCurrentPlayer())){
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can`t put yourself in check");
        }

        this.check = testCheck(oponnet(this.getCurrentPlayer()))? true : false;

        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = this.board.removePiece(source);
        Piece capturedPiece = this.board.removePiece(target);
        this.board.placePiece(p, target);
        
        if(capturedPiece != null){
            this._piecesOnTheBoard.remove(capturedPiece);
            this._capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        Piece p = this.getBoard().removePiece(target);
        this.getBoard().placePiece(p, source);

        if(capturedPiece != null) {
            this.getBoard().placePiece(capturedPiece, target);
            this._capturedPieces.remove(capturedPiece);
            this._piecesOnTheBoard.add(capturedPiece);
        }
    }

    private void validateSourcePosition(Position position){
        if(!this.board.thereIsApice(position)){
            throw new ChessException("there is no piece on source position");
        }
        if(this.getCurrentPlayer() != ((ChessPiece)this.getBoard().piece(position)).getColor() ){
            throw new ChessException("The chosen piece in not yours");
        }
        if(!this.board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source,Position target){
        if(!this.board.piece(source).possibleMove(target)){
            throw new ChessException("The chosen piece can`t move to target position");
        }
    }

    private Color newCurrentPlayer(){
        Color aux = (this.getCurrentPlayer() == Color.WHITE) ? Color.BLACK : Color.WHITE;
        return aux;
    }

    private void nextTurn(){
        this.setTurn(this.getTurn() + 1);
        this.setCurrentPlayer(newCurrentPlayer());
    }

    private Color oponnet(Color color){
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color){
        List<Piece> list = this._piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        
        for(Piece p: list){
            if(p instanceof King){
                return (ChessPiece)p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board");
    }  
    
    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponetPieces = this._piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == oponnet(color)).collect(Collectors.toList());
        
        for(Piece p: opponetPieces) {
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColum()]){
                return true;
            }
        }
        return false;
    }

    public void placeNewPiece(char colum, int row, ChessPiece piece){
        this.board.placePiece(piece, new ChessPosition(colum, row).toPosition());
        this._piecesOnTheBoard.add(piece);
    }    

    private void initialSetup(){
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
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

    private void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean getCheck() {
        return check;
    }   

    public boolean getCheckMate() {
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

} 
