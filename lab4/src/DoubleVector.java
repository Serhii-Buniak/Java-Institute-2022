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

    public static void main(String[] args) {
        double[] a = { 1, 2, 3, 4 };
        double[] b = { 1, 1, 1, 1 };
        double[] c = { 2, 2, 2, 2 };
        DoubleVector v1 = new DoubleVector(a);
        DoubleVector v2 = new DoubleVector(b);
        DoubleVector v3 = new DoubleVector(c);
        System.out.println("v1*v2=" + v1.mult(v2));
        System.out.println("v1*v2=" + DoubleVector.mult(v1, v2));
        System.out.println("v1*v3=" + v1.mult(v3));

        System.out.println("v1+v2=" + v1.sum(v2));
        System.out.println("v1+v2=" + DoubleVector.sum(v1, v2));
        System.out.println("v1+v3=" + v1.sum(v3));

        System.out.println("v1-v2=" + v1.diff(v2));
        System.out.println("v1-v2=" + DoubleVector.diff(v1, v2));
        System.out.println("v1-v3=" + v1.diff(v3));

        System.out.println("v1*3=" + v1.mult(3));
        System.out.println("v2*3=" + DoubleVector.mult(v2, 3));
        System.out.println("v3*3=" + v3.mult(3));
    }
}