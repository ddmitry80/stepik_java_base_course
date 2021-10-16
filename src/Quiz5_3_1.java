import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Quiz5_3_1 {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
//        String res = reader.readLine();
//        if ((res==null) || (res.isEmpty()))
//            res = "";
//        return res;
        InputStreamReader isr = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        int i;
        while ((i=isr.read()) != -1) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        byte[] arr = {48, 49, 50, 51};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        //System.setIn(inputStream);
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

}
