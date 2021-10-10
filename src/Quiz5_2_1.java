import java.io.*;

public class Quiz5_2_1 {

    public static void main(String[] args) throws IOException {

        InputStream stream = new ByteArrayInputStream ( new byte[] { 0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int b;
        int c = 0;
        while (true) {
            b = inputStream.read();
            if (b==-1)
                break;
            c = Integer.rotateLeft(c, 1) ^ b;
        }
        return c;
    }

}
