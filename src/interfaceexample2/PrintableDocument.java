package interfaceexample2;

public class PrintableDocument implements Printable {
    @Override
    public void printable() {
        System.out.println("Printed document.");
    }
}
