package br.eti.inovareti.tictactoe.core;

import br.eti.inovareti.tictactoe.Constantes;
import br.eti.inovareti.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];
    private int currentPlayerIndex = 0;

    public void play() {
        UI.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }
    }

    private Player createPlayer(int index) {
        String name = UI.readInput("Jogador " + (index + 1) + " =>");
        char symbol = Constantes.SYMBOL_PLAYERS[index];
        Player player = new Player(name, board, symbol);

        UI.printText("O Jogador '" + name + "' vai usar o símbolo '" + symbol + "'.");

        return player;
    }

    private Player nextPlayer() {
        // Implementação 1
        /*currentPlayerIndex++;
        if (currentPlayerIndex >= players.length) {
            currentPlayerIndex = 0;
        }
        return players[currentPlayerIndex];
        */

        // Implementação 2
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[currentPlayerIndex];
    }
}
