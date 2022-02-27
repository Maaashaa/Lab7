package fraction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionStatementParser {
    public enum Operations {
        SUM, DIF, MULTIPLICATION, DIVISION
    }
    /**
     Пример: " + " " - " " * " " / "
     */
    private static final String OPERATION_FROM_FRACTION_STATEMENT_REGEXP = "\\s[\\+\\-\\*\\/]?\\s";

    /**
     * Пример (возможная размерность): "1" "12" "123" "1234" "12345"
     */
    private static final String NUMERATOR_DENOMINATOR_REGEXP = "\\d{1,5}";

    /**
     * Пример:
     *  1) Число пробелов "3/4" or "3 / 4" or "3/ 4" or "3 /4"
     *  2) Возможная размерность числителя и знаменателя - "1" "12" "123" "1234" "12345"
     */
    //private static final String CORRECT_FRACTION_WITH_SPACES_REGEXP = "^\\d{1,5}\\s?/\\s?\\d{1,5}$";

    /**
     * Пример:
     *  1) Число пробелов "3/4"
     *  2) Возможная размерность числителя и знаменателя - "1" "12" "123" "1234" "12345"
     */
    private static final String CORRECT_FRACTION_WITHOUT_SPACES_REGEXP = "\\d{1,5}/\\d{1,5}";

    /**
     * Пример: "22/4123 + 1/2"
     */
    private static final String CORRECT_FRACTION_STATEMENT = "^\\d{1,5}/\\d{1,5}\\s[\\+\\-\\*\\/]?\\s\\d{1,5}/\\d{1,5}$";


    private static List<String> matchInputByUsingRegexp(String input, String regexp) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
        List<String> result = new ArrayList<>();
            while (matcher.find()) {
                result.add(input.substring(matcher.start(), matcher.end()));
            }
        return result;
    }
    private static boolean isInputCorrect(String input) {
        boolean isCorrect = input.matches(CORRECT_FRACTION_STATEMENT);
        if(!isCorrect){
            System.out.println("Формат введенного выражения не соответсвует необходимому!");
            System.out.println("Введите выражнение ещё раз. Для этого перезапустите программу) ");
            System.exit(1);
        }
       return isCorrect;
    }

    private static List<String> parseInputIntoFractions(String input) {
        return matchInputByUsingRegexp(input, CORRECT_FRACTION_WITHOUT_SPACES_REGEXP);
    }

    private static List<String> parseFractionStringIntoNumeratorAndDenominator(String fraction) {
        return matchInputByUsingRegexp(fraction, NUMERATOR_DENOMINATOR_REGEXP);
    }

    private static String parseInputIntoOperation(String input) {
        List<String> operationFromStatement = matchInputByUsingRegexp(input, OPERATION_FROM_FRACTION_STATEMENT_REGEXP);
        return operationFromStatement.get(0).substring(1,2);
    }
    private static MyFraction getFractionFromString(String fraction){
            List<String> el = parseFractionStringIntoNumeratorAndDenominator(fraction);
              int numerator = Integer.parseInt(el.get(0));
              int denominator = Integer.parseInt(el.get(1));
        return new MyFraction(numerator, denominator);
    }
    private static Operations operationsIntoEnum (String operation){
        switch (operation){
            case("+"):
                return Operations.SUM;
            case("-"):
                return Operations.DIF;
            case("*"):
                return Operations.MULTIPLICATION;
            case("/"):
                return Operations.DIVISION;
            default:
                throw new IllegalArgumentException("Такой операции нет");
        }
    }
    public static FractionStatement parseInputAndReturnFractions(String input) {
        if(isInputCorrect(input)) {
            List<String> fractions = parseInputIntoFractions(input);
            MyFraction fraction1 = getFractionFromString(fractions.get(0));
            MyFraction fraction2 = getFractionFromString(fractions.get(1));
            Operations operation = operationsIntoEnum(parseInputIntoOperation(input));
            return new FractionStatement(fraction1, fraction2, operation);
        }
        return null;
    }

    public static class FractionStatement {
        private final MyFraction fraction1;
        private final MyFraction fraction2;
        private final Operations operation;
        @Override
        public String toString() {
            String numerator = new String();
            String denominator = new String();
            return "fraction=" + numerator +
                    "/"+ denominator;
        }
        public FractionStatement(MyFraction fraction1, MyFraction fraction2, Operations operation) {
            this.fraction1 = fraction1;
            this.fraction2 = fraction2;
            this.operation = operation;
        }

        public MyFraction getFraction1() {
            return fraction1;
        }

        public MyFraction getFraction2() {
            return fraction2;
        }

        public Operations getOperation() {
            return operation;
        }
    }
}