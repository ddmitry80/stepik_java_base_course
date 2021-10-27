import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class experiment6_3_3 {
    static Consumer<String> println = x -> System.out.println(x);
    static Consumer<Integer> intPrintln = x -> System.out.println(x+5);

    public static void main(String[] args) {
        //println("test println");
        println.accept(String.valueOf(11));
        intPrintln.accept(5);
    }
}
