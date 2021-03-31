package interfaceexample2;

import java.util.ArrayList;
import java.util.List;

public class InterfaceExample2 {
    public void run() {
        var privateDoc = new PrivateDocument();
        var printableDoc = new PrintableDocument();
//        var printableDoc = new FunDocument();
//        var printableDoc = new SadDocument();

        List<Object> docs = new ArrayList<>();
        docs.add(printableDoc);
        docs.add(privateDoc);

        for(Object doc: docs) {
            if(doc instanceof Printable) {
                System.out.println("found a printable doc.");
            }

            if(!(doc instanceof Printable)) {
                System.out.println("found a non-printable doc.");
            }

            if(doc instanceof PrivateDocument) {

            }
        }
    }
}
