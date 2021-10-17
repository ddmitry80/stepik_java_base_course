import java.io.*;
import java.util.Objects;
import java.lang.IllegalArgumentException;

class Animal implements Serializable {
    final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}

public class Quiz5_4_1 {

    public static Animal[] deserializeAnimalArray(byte[] data) throws Exception {
        try {
            ByteArrayInputStream bai = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bai);

            int animalsCount = ois.readInt();

            Animal[] res = new Animal[animalsCount];
            Animal animal;
            //System.out.println(animalsCount);
            for (int i = 0; i < animalsCount; i++) {
                    animal = (Animal) ois.readObject();
                    res[i] = animal;
            }
            return res;
        } catch (Exception e) { throw new IllegalArgumentException(); }
    }



    public static void main(String[] args) throws Exception {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentacles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (Animal animal : animalM1) {
            oos.writeObject(animal);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());

        for (Animal animal: animalM2
             ) {
            System.out.println(animal.name);
        }
    }
}
