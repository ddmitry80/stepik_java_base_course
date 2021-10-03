import java.lang.reflect.Array;
import java.util.Arrays;

public class Quiz2_4_2 {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] r = new int[a1.length + a2.length];
        int a1Pos = 0 ; int a2Pos = 0;
        int i;
        int currPos;
        for (currPos=0; currPos<a1.length+a2.length; currPos++) {
            if (a1[a1Pos] < a2[a2Pos]) {
                r[currPos] = a1[a1Pos];
                a1Pos++;
            } else {
                r[currPos] = a2[a2Pos];
                a2Pos++ ;
            }
            //System.out.println("currPos="+ currPos + " a1Pos="+a1Pos + " a2Pos="+a2Pos + ": " + Arrays.toString(r));
            if (a1Pos>a1.length-1 | a2Pos>a2.length-1) {
                //System.out.println("break!");
                break;
            }
        }
        if (a1Pos>a1.length-1) {
            //System.out.println("a1Pos>a1.length-1 a2Pos=" + a2Pos + " a2.length=" + a2.length);
            for (i=0; i<a2.length-a2Pos; i++) {
                r[currPos+i+1] = a2[i+a2Pos];
            }
        } else {
            for (i=0; i<a1.length-a1Pos; i++) {
                r[currPos + i + 1] = a1[i+a1Pos];
            }
        }
        return r; // your implementation here
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 1, 2, 3};
        int[] arr2 = new int[] {0, 2, 4};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
//        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
    }
}
