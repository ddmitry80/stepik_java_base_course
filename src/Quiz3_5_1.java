import java.util.function.DoubleUnaryOperator;

public class Quiz3_5_1 {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double r = 0;
        double delta = 1e-6;
        for (double i=a; i<b; i += delta) {
            r += f.applyAsDouble(i)*delta;
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println(integrate(x->1, 0, 10));
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }

}
