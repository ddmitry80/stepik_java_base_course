import java.util.Objects;

class Pair<T1, T2> {
    private T1 v1;
    private T2 v2;

    private Pair(T1 t1, T2 t2) {
        v1 = t1;
        v2 = t2;
    }

    public T1 getFirst() {
        return v1;
    }

    public T2 getSecond() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(v1, pair.v1) && Objects.equals(v2, pair.v2);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pair<?, ?> pair = (Pair<?, ?>) o;
//        return v1.equals(pair.v1) && v2.equals(pair.v2);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }

    public static <T1, T2> Pair of(T1 t1, T2 t2) {
        return new Pair(t1, t2);
    }
}


public class Quiz6_1_1 {


    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println("mustBeTrue: " + String.valueOf(mustBeTrue));
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("mustAlsoBeTrue: " + String.valueOf(mustAlsoBeTrue));
    }
}
