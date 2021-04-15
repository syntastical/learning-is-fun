package exceptions;

import java.nio.file.Files;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
//        try {
//            throwException();
//        } catch (RuntimeException exception) {
//            System.out.println("Caught exception");
//        }
        while(true) {
            try {
                complexMethod();
            } catch (MyException1 myException1) {
                System.out.println("Caught myException1");
            } catch (MyException2 myException2) {
                System.out.println("Caught myException2");
                throw myException2;
            } finally {
                System.out.println("In finally");
            }
        }

        //try(File file = ...) {

    }

    public static void throwException() {
        throw new RuntimeException("Could find what you're looking for.");
    }

    public static void complexMethod() {
        int rand = (int)((Math.random() * 3) + 1);
        if(rand == 1) {
            throw new MyException1();
        }
        if(rand == 2) {
            throw new MyException2();
        }
        System.out.println("Ran without issue.");
    }
}

class MyException1 extends RuntimeException {}
class MyException2 extends RuntimeException {}
