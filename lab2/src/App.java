public class App {
    public static void main(String[] args) throws Exception {
        double angle = Double.parseDouble(args[0]);
        SinCosCalculator calculator = new SinCosCalculator(angle);

        System.out.println(calculator.GetSinus());
        System.out.println(calculator.GetCosinus());
    }
}