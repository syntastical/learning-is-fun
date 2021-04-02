package polymorphism.abstractexample1;

public class Dog extends Animal {
    public Dog() {
        name = "dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Wooof");
    }

}
