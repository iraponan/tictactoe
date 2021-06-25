package br.eti.inovareti.tictactoe.core;

public class Move {

    private int i;
    private int j;

    public Move(String moveStr) {
        moveStr = moveStr.replace(" ", "");
        String[] tokens = moveStr.split(",");
        this.i = Integer.parseInt(tokens[0]);
        this.j = Integer.parseInt(tokens[1]);
        //TODO Validar se a estrutura moveStr esta correta.
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
