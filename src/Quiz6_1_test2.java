import java.util.Optional;

class Example<X> {
    public void someMethod(Object obj) {
        //X a = new X();
        //obj instanceof Optional<X>;
        //X[] arr = new X[] {};
        //X[3] arr;
        Optional<X> optX = Optional.empty();
        //if (obj instanceof X) {};
        X castType = (X) obj;
    }
}

public class Quiz6_1_test2 {

    public static void main(String[] args) {

    }
}
