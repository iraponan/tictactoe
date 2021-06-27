package br.eti.inovareti.tictactoe;

import br.eti.inovareti.tictactoe.core.Game;

import java.io.IOException;

public class TicTacToe {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.play();
    }
}
