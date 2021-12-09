package game;

public class BattleField {
    private int[][] field;

    public BattleField() {
        field = new int[10][10];
        int i = 0;
        int j = 0;
        for(i = 0; i < 10; i++)
            for(j = 0; j < 10; j++) field[i][j] = 0;
        //Arrays.fill(field, 0);
    }

    public int getCellValue(int i, int j) {
        return field[i][j];
    }

    public void setCellValue(int i, int j, int value) {
        field[i][j] = value;
    }

    public int shootCell(int i, int j) {
        switch (field[i][j]) {
            case -2: return -1;
            case -1: return -1;
            case 0:
                field[i][j] = -1;
                return 0;
            case 1:
                field[i][j] = -2;
                return 1;
        }
        return -1;
    }

    public boolean checkLose() {
        int i = 0;
        int j = 0;
        for(i = 0; i < 10; i++)
            for(j = 0; j < 10; j++) {
                if(field[i][j] == 1) return false;
            }
        return true;
    }

    public boolean addShip(int i, int j, int numberOfDeck, boolean vertical) {
        int k = 0;
        int l = 0;
        if (i < 0 || i > 9 || j < 0 || j > 9) return false;
        if (vertical) {
            if (i > 10 - numberOfDeck) return false;
            for(k = i - 1; k <= i + numberOfDeck; k++)
                for (l = j - 1; l <= j + 1; l++) {
                    if (k > -1 && k < 10 && l > -1 && l < 10)
                        if (field[k][l] == 1) return false;
                }
            for(k = i; k < i + numberOfDeck; k++) field[k][j] = 1;
            return true;
        }
        else {
            if (j > 10 - numberOfDeck) return false;
            for(k = i - 1; k <= i + 1; k++)
                for (l = j - 1; l <= j + numberOfDeck; l++) {
                    if (k > -1 && k < 10 && l > -1 && l < 10)
                        if (field[k][l] == 1) return false;
                }
            for(l = j; l < j + numberOfDeck; l++) field[i][l] = 1;
            return true;
        }
    }


}
