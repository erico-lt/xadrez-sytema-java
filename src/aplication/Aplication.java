package aplication;

import chess.ChessMatch;

public class Aplication {
    public static void main(String[] args) throws Exception {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
