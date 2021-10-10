import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Quiz5_2_2 {

    public static void main(String[] args) throws IOException {

        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);

        int prevR;
        int r = System.in.read();
        if (r == -1)
            return;
        //int r = 0;
        while (true) {
            prevR = r;
            r = System.in.read();
            //System.out.println(new Integer(r).toString());
            if (r == -1) {
                System.out.print(" "+prevR);
                //System.out.write(prevR);
                break;
            }
            if ((prevR==13) && (r==10))
                continue;
            System.out.print(" "+prevR);
            //System.out.write(prevR);
        }
        System.out.flush();
    }
}
