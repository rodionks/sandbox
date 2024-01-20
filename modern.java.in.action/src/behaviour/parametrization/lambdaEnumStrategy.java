package behaviour.parametrization;

import java.util.function.DoubleBinaryOperator;

public class lambdaEnumStrategy {
    enum Calculate {
        ADD ((x, y) -> (x + y), "+"),
        SUBTRACT ((x, y) -> ( x - y), "-"),
        MULTIPLY ( (x, y) -> ( x * y), "*") ,
        DIVIDE ((x, y) -> ( x / y), "/"),
        POWER (Math::pow, "^");

        private final DoubleBinaryOperator function;
        private final String Op;


        Calculate(DoubleBinaryOperator function, String Op) {
            this.function = function;
            this.Op = Op;
        }

        public DoubleBinaryOperator getFunction() {
            return function;
        }

        public String getOp() { return Op; }

    }

    static final String OPERATORS = "+-*/^";

    public static Calculate getOperator(String s) {
        // check validity
        if (!OPERATORS.contains(s)) return null;

        // this creates an array of the enums and loops through each, very handy!!!
        for (Calculate each : Calculate.values()) {
            if (s.equals(each.getOp())) return each;
        }
        return null;
    }

    public static double calcString(String input) {
        String[] vals = input.split(" ");
        if (vals.length != 3) return 0;
        double x = Double.parseDouble(vals[0]);
        double y = Double.parseDouble(vals[2]);
        Calculate op = getOperator(vals[1]);
        if (op == null) return 0;
        return calc(x, y, op);
    }

    public static double calc(double x, double y, Calculate operation) {
        return operation.getFunction().applyAsDouble(x, y);
    }

    public static void main(String[] args) {
        String test = "123.456 / 2.8";
        String test2 = "2 ^ 10";
        String test3 = "200 - 34.5";
        System.out.println(calcString(test));
        System.out.println(calcString(test2));
        System.out.println(calcString(test3));

    }

}
