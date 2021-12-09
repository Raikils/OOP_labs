package game;

import java.lang.Math;

public class AI {
    private BattleField opponentField;

    public AI(BattleField opponentField) {
        this.opponentField = opponentField;
    }

    public int[] move() {
        int[] move = new int[2];
        int i = 0;
        int j = 0;
        while (true) {
            i = (int)Math.round(Math.random() * 10);
            j = (int)Math.round(Math.random() * 10);
            if (opponentField.getCellValue(i, j) >= 0) break;
        }
        move[0] = i;
        move[1] = j;
        return move;
    }
}
