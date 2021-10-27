import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz6_3_1 {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

//        if (condition.test(T)) {
//            return ifTrue.apply(U);
//        } else {
//            return ifFalse.apply(T);
//        }
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
        //return null; // your implementation here

    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

    }
}
