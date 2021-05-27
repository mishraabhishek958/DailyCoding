import java.util.function.Function;

public class Solution005 {

    public static void main(String s[]) {

        System.out.println(car(cons(3, 4)));
        System.out.println(cdr(cons(3, 4)));
    }


    public static Function<Function<Pair, Integer>, Integer> cons(int a, int b) {
        return func -> func.apply(new Pair(a, b));
    }

    public static int car(Function<Function<Pair, Integer>, Integer> abc) {
        return abc.apply(pair -> pair.a);
    }

    public static int cdr(Function<Function<Pair, Integer>, Integer> abc) {
        return abc.apply(pair -> pair.b);
    }

    private static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
