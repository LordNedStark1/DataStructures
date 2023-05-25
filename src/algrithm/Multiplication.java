package algrithm;

public class Multiplication {

    public int multiply(int one, int two) {
       int validated = validateNumbers(one, two);

       if (validated == -2) return twoMinusValue(one, two);
       if (validated == -1) return oneMinusValue(one,two);
       if (validated == 0) return 0;

        int sum = getSum(one, two);

        return sum;
    }

    private int oneMinusValue(int one, int two) {
        int result = 0;
        if (one < 0) if ( two > 0) {
            result = singleMinusValue(one, two);
        }
        if (one > 0) if ( two < 0) {
            result = singleMinusValue(two, one);
        }

        return result;
    }

    private int singleMinusValue(int valueToMakePositive, int secondValue) {
        int result;
        int positiveValue = toPositive(valueToMakePositive);
        int sum = getSum(positiveValue, secondValue);
        int negativeValue = toNegative(sum);
        result = negativeValue;
        return result;
    }

    private int toNegative(int number) {
        String stringNumber = "-" + number;
        return Integer.valueOf(stringNumber);
    }

    private int toPositive(int number) {
        String stringNumber = String.valueOf(number);
        return Integer.valueOf(stringNumber.substring(1));
    }

    private static int getSum(int one, int two) {
        int sum = 0;
        for (int j = 0; j < one; j++) {
            sum += two;

        }
        return sum;
    }

    private int twoMinusValue(int one, int two) {
        String stringOne = "" + one;
        String stringTwo = "" +two;
        int firstInteger = Integer.parseInt(stringOne.substring(1));
        int secondInteger = Integer.valueOf(stringTwo.substring(1));
        return getSum(firstInteger, secondInteger);

    }

    private int validateNumbers(int one, int two) {
        if (one == 0 || two == 0) return 0;

        if (one < 0) if ( two > 0) return -1;
        if (one > 0) if ( two < 0) return -1;
        if (one < 0 && two < 0 )return -2;

        return 1;
    }
}
