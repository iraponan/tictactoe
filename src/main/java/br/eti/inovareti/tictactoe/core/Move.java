package br.eti.inovareti.tictactoe.core;

public class Move {

    private int i;
    private int j;

    public Move(String moveStr) throws InvalidMoveException {
        try {
            moveStr = moveStr.replace(" ", "");
            String[] tokens = moveStr.split(",");
            this.i = Integer.parseInt(tokens[0]);
            this.j = Integer.parseInt(tokens[1]);
        } catch (Exception e) {
            throw new InvalidMoveException("A jogada é invalida.\n Informe corretamente as posições do tabuleiro: x, y.");
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
