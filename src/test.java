import java.io.*;
import java.nio.charset.StandardCharsets;

public class test {

    public static void main(String[] args) throws IOException {
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        //Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        //Writer writer = new OutputStreamWriter(new FileOutputStream("out.txt"), StandardCharsets.US_ASCII);
        writer.write((int)'Ж');
        writer.flush();
        writer.close();
    }

}


