import java.util.*;

public class Quiz6_2_1 {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> a = new HashSet(set1);
        a.addAll(set2);

        Set<T> o = new HashSet(set1);
        o.retainAll(set2);

        a.removeAll(o);

        return a;
    }

    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }


}
