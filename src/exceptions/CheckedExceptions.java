package exceptions;

public class CheckedExceptions {
    public static void main(String[] args)  {
        try {
            throwException();
        } catch (MyCheckedException1 myCheckedException1) {
            myCheckedException1.printStackTrace();
        } catch (MyCheckedException2 myCheckedException2) {
            myCheckedException2.printStackTrace();
            System.out.println("");
        }
    }

    public static void throwException() throws MyCheckedException1, MyCheckedException2 {
        throw new MyCheckedException1();
    }
}

class MyCheckedException1 extends Exception {}
class MyCheckedException2 extends Exception {}
