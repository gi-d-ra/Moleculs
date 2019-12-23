package ChemicalElements;


public class MyLine extends MyFigure {
    int x1;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    int y1;
    int x2;
    int y2;


    public MyLine() {
    }

    public MyLine(MyLine ln) {
        x1 = ln.getX1();
        y1 = ln.getY1();
        x2 = ln.getX2();
        y2 = ln.getY2();
    }


    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
