package br.eti.inovareti.tictactoe.core;

import br.eti.inovareti.tictactoe.Constantes;
import br.eti.inovareti.tictactoe.score.FileScoreManager;
import br.eti.inovareti.tictactoe.score.ScoreManager;
import br.eti.inovareti.tictactoe.ui.UI;

import java.io.IOException;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];
    private int currentPlayerIndex = -1;
    private ScoreManager scoreManager;

    public void play() throws IOException {
        scoreManager = createScoreManager();

        UI.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;
        Player currentPlayer = nextPlayer();
        Player winner = null;

        while (!gameEnded) {
            board.print();
            boolean sequenceFound;
            try {
                sequenceFound = currentPlayer.play();
            }
            catch (InvalidMoveException e) {
                UI.printText("Erro: " + e.getMessage());
                continue;
            }
            if (sequenceFound) {
                gameEnded = true;
                winner = currentPlayer;
            }
            else if (board.isFull()) {
                gameEnded = true;
            } else {
                currentPlayer = nextPlayer();
            }
        }

        if (winner == null) {
            UI.printText("O Jogo terminou empatado!");
        }
        else {
            UI.printText("O jogador '" + winner.getName() + "' venceu o jogo!!!");
            scoreManager.saveScore(winner);
        }

        board.print();
        UI.printText("Fim do Jogo!");
    }

    private Player createPlayer(int index) {
        String name = UI.readInput("Jogador " + (index + 1) + " =>");
        char symbol = Constantes.SYMBOL_PLAYERS[index];
        Player player = new Player(name, board, symbol);

        Integer score = scoreManager.getScore(player);

        if (score != null) {
            UI.printText("O jogador '" + player.getName() + "' já possui " + score + " vitória(s)!");
        }

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

    private ScoreManager createScoreManager() throws IOException {
        return new FileScoreManager();
    }
}
