public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = Math.hypot(a, b);
    }

    public double GetAAngle() {
        double aAngleRadians = Math.asin(a / c);
        return Math.toDegrees(aAngleRadians);
    }

    public double GetBAngle() {
        double bAngleRadians = Math.asin(b / c);
        return Math.toDegrees(bAngleRadians);
    }

    public double GetC() {
        return c;
    }
}
