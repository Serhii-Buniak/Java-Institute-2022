public class SinCosCalculator {
    public double angle;

    public SinCosCalculator(double angle) {
        this.angle = Math.toRadians(angle);
    }

    public double GetSinus() {
        return Math.sin(angle);
    }

    public double GetCosinus() {
        return Math.cos(angle);
    }
}