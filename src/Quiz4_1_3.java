import java.util.Arrays;

public class Quiz4_1_3 {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] ex = new Throwable().getStackTrace();
//        System.out.println(Arrays.toString(ex));
//        System.out.println(ex.length);
        if (ex.length == 2) {
            return null;
        } else {
        return ex[2].getClassName().toString() + "#" + ex[2].getMethodName().toString();
        }
    }
}
