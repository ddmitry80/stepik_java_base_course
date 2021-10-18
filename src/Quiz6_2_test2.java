import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Quiz6_2_test2 {

    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();
        Object object = new Object();

        collection.toArray();
        collection.contains(object);
        collection.iterator();
        collection.size();
        collection.remove(object);
        collection.clear();
        //collection.addAll(Arrays.asList(object));
        //collection.add(object);

    }
}
