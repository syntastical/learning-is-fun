package abstractexample1;

import java.util.ArrayList;
import java.util.List;

public class AbstractExample1 {
    public void run() {
        var bear = new Bear();
        var dog = new Dog();

        List<Animal> animals = new ArrayList<>();
        animals.add(bear);
        animals.add(dog);

        for(Animal animal: animals) {
            animal.run();
            animal.makeSound();
        }
    }
}
