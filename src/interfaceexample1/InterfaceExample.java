package interfaceexample1;

import java.util.ArrayList;
import java.util.List;

public class InterfaceExample {
    public void run() {
        // Environment 1 is ocean
        // Environment 2 is above water

        var env = new UnderWater();

        var fox = new Fox();
        var bird = new Bird();
        var fish = new Fish();

        List<Animal> animals = new ArrayList<>();
        animals.add(fox);
        animals.add(bird);
        animals.add(fish);

        for(Animal animal: animals) {
            env.canBreath(animal);
        }
    }
}
