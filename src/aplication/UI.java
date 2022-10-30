package aplication;

import chess.ChessPiece;

public class UI {
    public static void printBoard(ChessPiece[][] pieces){
        for(int row = 0; row < pieces.length; row++){
            System.out.print((8 - row) + " ");
            for(int colum = 0; colum < pieces.length; colum++){
                printPiece(pieces[row][colum]);
            } 
            System.out.println();          
        }
        System.out.println("  a b c d e f g h");        
    }

    public static void printPiece(ChessPiece piece){
        if(piece == null){
            System.out.print("-");
        }else{
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
