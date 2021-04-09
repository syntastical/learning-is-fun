package autoboxing;

public class Autoboxing {
    static int myInt;
    static Integer myInteger = 0;
    public static void main(String[] args) {
        System.out.println(myInt == 0);
        System.out.println(myInteger == null);

        char c;
        Character ch;

        /*
         * Primitives
         * Don't have methods
         * Can only be concrete values and not null
         */
        int i = 0;
        long l = 0;
        double d = 0.0;
        float f = 0.0f;
        boolean b = false;
        short s = 0;


        /*
          * Object representations of primitives
          * Have methods
          * Can be null
          * Can be extended
         */
        Integer objectI = 0;
        Long objectL = 0L;
        Double objectD = 0.0;
        Float objectF = 0.0F;
        Boolean objectB = false;

    }
}