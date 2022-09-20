import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleVector {
    private double[] vector = null;

    public DoubleVector(double[] vector) {
        this.vector = vector;
    }

    public double mult(DoubleVector anotherVector) {
        double s = 0;
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] * anotherVector.vector[i];
        }
        return s;
    }

    public static double mult(DoubleVector a, DoubleVector b) {
        return a.mult(b);
    }

    public DoubleVector sum(DoubleVector anotherVector) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < vector.length; i++) {
            list.add(vector[i] + anotherVector.vector[i]);
        }

        double[] vector = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            vector[i] = list.get(i);
        }

        return new DoubleVector(vector);
    }

    public static DoubleVector sum(DoubleVector a, DoubleVector b) {
        return a.sum(b);
    }

    public DoubleVector diff(DoubleVector anotherVector) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < vector.length; i++) {
            list.add(vector[i] - anotherVector.vector[i]);
        }

        double[] vector = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            vector[i] = list.get(i);
        }

        return new DoubleVector(vector);
    }

    public static DoubleVector diff(DoubleVector a, DoubleVector b) {
        return a.diff(b);
    }

    public DoubleVector mult(double multiplier) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < vector.length; i++) {
            list.add(vector[i] * multiplier);
        }

        double[] vector = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            vector[i] = list.get(i);
        }

        return new DoubleVector(vector);
    }

    public static DoubleVector mult(DoubleVector a, double multiplier) {
        return a.mult(multiplier);
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}