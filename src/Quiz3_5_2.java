import java.lang.CharSequence;
import java.util.Arrays;

class AsciiCharSequence implements CharSequence/* extends/implements */ {

    private byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array.clone();
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i=0; i< array.length; i++) {
            r.append(charAt(i));
        }
        return r.toString();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] r = new byte[end-start];
        for (int i=start; i<end; i++) {
            r[i-start] = this.array[i];
        }
        return new AsciiCharSequence(r);
    }

}

public class Quiz3_5_2 {

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }
}
