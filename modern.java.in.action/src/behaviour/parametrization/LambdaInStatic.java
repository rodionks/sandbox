package behaviour.parametrization;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


class STRATEGY {
    static Consumer<String> PRINT_TWICE = (String s) -> {System.out.println(s + " " + s);};
}

public class LambdaInStatic {

    static int a;

    static Consumer<String> STRATEGY_PRINT = (String s) -> {System.out.println(s);};
    static Consumer<String> STRATEGY_PRINT_LENGTH = (String s) -> {System.out.println("String length: " + s.length());};

    static void fire(List<String> arr, Consumer<String> strategy) {
        for (String s : arr ) {
            strategy.accept(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(a);

        fire(List.of("aaaa","bbb"), STRATEGY_PRINT);
        fire(List.of("aaaa","bbb"), STRATEGY_PRINT_LENGTH);
        fire(List.of("aaaa","bbb"), STRATEGY.PRINT_TWICE);
    }
}
