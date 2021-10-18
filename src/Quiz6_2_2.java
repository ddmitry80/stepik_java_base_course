import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz6_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        int v;
        while (scanner.hasNext()){
            v = scanner.nextInt();
            if (count%2!=0) {
                list.add(v);
                System.out.print(v + " ");
            }
            count++;
        }
        Collections.reverse(list);

        //System.out.println(list);
        for (Integer val: list
             ) {
            System.out.print(val);
            System.out.print(" ");
        }
    }
}
