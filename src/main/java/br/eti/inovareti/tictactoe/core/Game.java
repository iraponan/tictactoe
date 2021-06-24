package br.eti.inovareti.tictactoe.core;

import br.eti.inovareti.tictactoe.Constantes;
import br.eti.inovareti.tictactoe.ui.UI;

public class Game {

    public Board board = new Board();
    public Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];

    public void play() {
        UI.printGameTitle();
        board.print();
        //UI.readInput("Nome do Jogador: ");
    }
}
