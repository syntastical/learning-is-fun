package abstractexample1;

public class Bear extends Animal {
    public Bear() {
        name = "bear";
    }

    @Override
    public void makeSound() {
        System.out.println("roar");
    }

}
