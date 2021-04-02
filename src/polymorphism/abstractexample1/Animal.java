package polymorphism.abstractexample1;

public abstract class Animal {
    public String name;

    public abstract void makeSound();

    public void run() {
        System.out.println(name + " runs.");
    }
}
