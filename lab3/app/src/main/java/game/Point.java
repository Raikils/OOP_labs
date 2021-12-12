package game;

public class Point {
    private int i;
    private int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Point() {
        this.i = -1;
        this.j = -1;
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
