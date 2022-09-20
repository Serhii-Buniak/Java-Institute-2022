public class Hypot {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        Triangle triangle = new Triangle(a, b);

        System.out.println("C: " + triangle.GetC());
        System.out.println("Alpha: " + triangle.GetAAngle());
        System.out.println("Beta: " + triangle.GetBAngle());
    }
}
