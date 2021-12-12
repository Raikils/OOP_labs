package game;

import java.lang.Math;
import java.util.ArrayList;

public class AI {
    private BattleField opponentField;
    private int numberOfFourDeck = 1;
    private int numberOfThreeDeck = 2;
    private int numberOfTwoDeck = 3;
    private int numberOfOneDeck = 4;

    public AI(BattleField opponentField) {
        this.opponentField = opponentField;
    }

    public void setOpponentField(BattleField opponentField) {
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

    public int[] smartMove() {
        int[] move = new int[2];
        int i = 0;
        int j = 0;
        Ship ship;
        for(i = 0; i < 10; i++)
            for(j = 0; j < 10; j++) {
                if (opponentField.getCellValue(i, j) == -1) {
                    ship = new Ship(i, j, opponentField);
                    if (ship.isUnblocked(opponentField)) {
                        move = ship.shipContinue(opponentField);
                        return move;
                    }
                }
            }
        move = this.move();
        return move;
    }

    /*private ArrayList<int[]> fieldAnalysis() {
        ArrayList<int[]> moments;
        int[] moment = new int[2];
        int i = 0;
        int j = 0;
        int k = 0;
        int numberOfDecks = 0;
        boolean vertical = true;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (opponentField.getCellValue(i, j) < 0) {
                    numberOfDecks = defineShipType(i, j);
                    if (numberOfDecks > 1) {
                        if ((i - 1 > 0 && opponentField.getCellValue(i - 1, j) == -1) || (i + 1 < 10 && opponentField.getCellValue(i + 1, j) == -1)) vertical = true;
                        else vertical = false;
                    } else {
                        if ((i - 1 > 0 && opponentField.getCellValue(i - 1, j) >= 0) || (i + 1 < 10 && opponentField.getCellValue(i + 1, j) >= 0)) vertical = true;
                        else vertical = false;
                    }
                    if (!isShipBlocked(i, j, vertical)) {
                        if (vertical) {

                        }
                    }
                }
            }
        }
    }

    private int defineShipType(int i, int j) {
        int neighbours = 0;
        int k = 0;
        int l = 0;
        for (k = i - 1; k <= i + 1; k++)
            for (l = j - 1; l <= j + 1; l++) {
                if (k > -1 && k < 10 && l > -1 && l < 10)
                    if (opponentField.getCellValue(k, l) < 0) {
                        neighbours++;
                        neighbours += defineShipType(k, l) - 1;
                    }
            }
        return neighbours;
    }

    private boolean isShipBlocked(int i, int j, boolean vertical) {
        boolean firstSide = false;
        boolean secondSide = false;
        if (vertical) {
            if ((i - 1 < 0) || opponentField.getCellValue(i - 1, j) == -2) firstSide = true;
            else {
                if (opponentField.getCellValue(i - 1, j) >= 0) return false;
                firstSide = isShipBlocked(i - 1, j, vertical);
            }
            if ((i + 1 > 9) || opponentField.getCellValue(i + 1, j) == -2) secondSide = true;
            else {
                if (opponentField.getCellValue(i + 1, j) >= 0) return false;
                secondSide = isShipBlocked(i + 1, j, vertical);
            }
        } else {
            if ((j - 1 < 0) || opponentField.getCellValue(i, j - 1) == -2) firstSide = true;
            else {
                if (opponentField.getCellValue(i, j - 1) >= 0) return false;
                firstSide = isShipBlocked(i, j - 1, vertical);
            }
            if ((j + 1 > 9) || opponentField.getCellValue(i, j + 1) == -2) secondSide = true;
            else {
                if (opponentField.getCellValue(i, j + 1) >= 0) return false;
                secondSide = isShipBlocked(i, j + 1, vertical);
            }
        }
        return (firstSide && secondSide);
    }*/
}
