package br.eti.inovareti.tictactoe.core;

public class Player {

    private String name;
    private Board board;
    private char symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Move inputMove() {
        return null;
    }

    public void play() {

    }
}
