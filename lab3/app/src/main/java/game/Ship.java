package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ship {
    private ArrayList<Point> cells = new ArrayList();
    private int numberOfDecks;
    boolean vertical;

    public Ship(int i, int j, BattleField field) {
        int k = 0;
        int l = 0;
        int n = 0;
        int m = 0;
        boolean inArray = false;
        boolean sort = true;
        cells.add(new Point(i, j));
        while(n < cells.size()) {
            for (k = cells.get(n).getI() - 1; k <= cells.get(n).getI() + 1; k++)
                for (l = cells.get(n).getJ() - 1; l <= cells.get(n).getJ() + 1; l++) {
                    if (k > -1 && k < 10 && l > -1 && l < 10)
                        if (field.getCellValue(k, l) == -1) {
                            inArray = false;
                            for (m = 0; m < cells.size(); m++)
                                if (cells.get(m).getI() == k && cells.get(m).getJ() == l) inArray = true;
                            if (inArray) continue;
                            cells.add(new Point(k, l));
                        }
                }
            n++;
        }
        while (sort) {
            sort = false;
            for (n = 1; n < cells.size(); n++) {
                if (cells.get(0).getI() > cells.get(n).getI()) {
                    Collections.swap(cells, 0, n);
                    sort = true;
                }
            }
        }
        sort = true;
        while (sort) {
            sort = false;
            for (n = 1; n < cells.size(); n++) {
                if (cells.get(0).getJ() > cells.get(n).getJ()) {
                    Collections.swap(cells, 0, n);
                    sort = true;
                }
            }
        }
        numberOfDecks = cells.size();
        vertical = true;
        if (cells.size() > 1) {
            if (cells.get(0).getI() == cells.get(1).getI()) vertical = false;
            else vertical = true;
        }
    }

    public ArrayList<Point> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Point> cells) {
        this.cells = cells;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isUnblocked(BattleField field) {
        boolean result = false;
        int k = 0;
        for (k = 0; k < numberOfDecks; k++) {
            if (vertical) {
                if (cells.get(k).getI() - 1 >= 0 && field.getCellValue(cells.get(k).getI() - 1, cells.get(k).getJ()) >= 0) result = true;
                if (cells.get(k).getI() + 1 < 10 && field.getCellValue(cells.get(k).getI() + 1, cells.get(k).getJ()) >= 0) result = true;
            } else {
                if (cells.get(k).getJ() - 1 >= 0 && field.getCellValue(cells.get(k).getI(), cells.get(k).getJ() - 1) >= 0) result = true;
                if (cells.get(k).getJ() + 1 < 10 && field.getCellValue(cells.get(k).getI(), cells.get(k).getJ() + 1) >= 0) result = true;
            }
        }
        return result;
    }

    public int[] shipContinue(BattleField field) {
        int[] result = new int[2];
        if (!isUnblocked(field)) return result;
        int k = 0;
        if (vertical) {
            if (cells.get(0).getI() - 1 >= 0 && field.getCellValue(cells.get(0).getI() - 1, cells.get(0).getJ()) >= 0) {
                result[0] = cells.get(0).getI() - 1;
                result[1] = cells.get(0).getJ();
                return result;
            }
            if (cells.get(numberOfDecks - 1).getI() + 1 < 10 && field.getCellValue(cells.get(numberOfDecks - 1).getI() + 1, cells.get(numberOfDecks - 1).getJ()) >= 0) {
                result[0] = cells.get(numberOfDecks - 1).getI() + 1;
                result[1] = cells.get(numberOfDecks - 1).getJ();
                return result;
            }
        } else {
            if (cells.get(0).getJ() - 1 >= 0 && field.getCellValue(cells.get(0).getI(), cells.get(0).getJ() - 1) >= 0) {
                result[0] = cells.get(0).getI();
                result[1] = cells.get(0).getJ() - 1;
                return result;
            }
            if (cells.get(numberOfDecks - 1).getJ() + 1 < 10 && field.getCellValue(cells.get(numberOfDecks - 1).getI(), cells.get(numberOfDecks - 1).getJ() + 1) >= 0) {
                result[0] = cells.get(numberOfDecks - 1).getI();
                result[1] = cells.get(numberOfDecks - 1).getJ() + 1;
                return result;
            }
        }
        return result;
    }
}
