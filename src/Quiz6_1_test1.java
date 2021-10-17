class MyOpt<T> {
    private T value;

    MyOpt (T val ) {
        this.value = val;
    }

    MyOpt() {
        this.value = null;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyOpt{" +
                "value=" + value +
                '}';
    }
}

public class Quiz6_1_test1 {
    enum Season { WINTER, SPRING, SUMMER, AUTUMN };

    public static void main(String[] args) {
        MyOpt<Integer> a = new MyOpt<Integer>(5);
        System.out.println(a.getValue());

        MyOpt<Cloneable> b = new MyOpt<Cloneable>();


        MyOpt<Season> c = new MyOpt<>(Season.AUTUMN);
        System.out.println(c);

        //MyOpt<Object::toString> d = new MyOpt<>();

        MyOpt e = new MyOpt<String>();
        System.out.println(e);

    }
}
