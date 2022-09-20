import java.util.ArrayList;
import java.util.List;

public class MathFunction {
    private double a;
    private double h;
    private int n;

    public MathFunction(double a, double h, int n) {
        this.a = a;
        this.h = h;
        this.n = n;
    }

    public PointXY getPoint(double x) {
        double y = a * Math.sqrt(x) * Math.sin(a * x);
        return new PointXY(x, y);
    }

    public List<PointXY> getPoints() {
        double x = 0;
        List<PointXY> points = new ArrayList<PointXY>();
        for (int i = 0; i < n; i++) {
            PointXY point = getPoint(x);
            points.add(point);
            x += h;
        }
        return points;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
}