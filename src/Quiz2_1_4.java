public class Quiz2_1_4 {
    public static int flipBit(int value, int bitIndex) {
        return value ^ ( 1 << (bitIndex-1));
    }

    public static void main(String[] args) {
        System.out.println(flipBit(0,1));
    }
}
