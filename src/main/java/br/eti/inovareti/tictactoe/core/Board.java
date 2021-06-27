package br.eti.inovareti.tictactoe.core;

import br.eti.inovareti.tictactoe.Constantes;
import br.eti.inovareti.tictactoe.ui.UI;

public class Board {
    private char[][] matrix;

    public Board() {
        matrix = new char[Constantes.BOARD_SIZE][Constantes.BOARD_SIZE];
        clear();
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            UI.printTextWithNoNewLine((i + 1) + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                UI.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
                if (j < matrix[i].length - 1) {
                    UI.printTextWithNoNewLine("|");
                }
            }
            UI.printNewLine();
            if (i < matrix.length - 1) {
                UI.printText("   -----------");
            }
        }
        UI.printText("    1   2   3 ");
    }

    public boolean isFull(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean play(Player player, Move move) throws InvalidMoveException{
        int i = move.getI() - 1;
        int j = move.getJ() - 1;

        if (i < 0 || j < 0 || i >= Constantes.BOARD_SIZE || j > Constantes.BOARD_SIZE) {
            throw new InvalidMoveException("O intervado da jogada é invalido!\nIntervalods permitidos de x: 1 a " + (Constantes.BOARD_SIZE) + " e y: 1 a " + (Constantes.BOARD_SIZE) + ".");
        }

        if (matrix[i][j] != ' ') {
            throw new InvalidMoveException("Esta jogada já foi realizada!");
        }

        matrix[i][j] = player.getSymbol();

        return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
    }

    private boolean checkRows(Player player) {
        for (int i = 0; i < Constantes.BOARD_SIZE; i++) {
            if (checkRow(i, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int i, Player player){
        char symbol = player.getSymbol();

        for (int j = 0; j < Constantes.BOARD_SIZE; j++) {
            if (matrix[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(Player player) {
        for (int j = 0; j < Constantes.BOARD_SIZE; j++) {
            if (checkCol(j, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int j, Player player){
        char symbol = player.getSymbol();

        for (int i = 0; i < Constantes.BOARD_SIZE; i++) {
            if (matrix[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal1(Player player) {
        char symbol = player.getSymbol();

        for (int i = 0; i < Constantes.BOARD_SIZE; i++) {
            if (matrix[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal2(Player player) {
        char symbol = player.getSymbol();
        int lastLine = Constantes.BOARD_SIZE - 1;

        for (int i = lastLine, j = 0; i >= 0 ; i--, j++) {
            if (matrix[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }
}
