import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Quiz5_3_2 {

    public static void main(String[] args) throws IOException {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                sum += scanner.nextDouble();
            }
            catch (java.util.InputMismatchException e) { scanner.next(); }
        }
        System.out.printf("%.6f", sum);
    }
}
