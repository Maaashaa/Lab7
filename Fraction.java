import java.util.InputMismatchException;
import java.util.Scanner;
import fraction.FractionStatementParser;
import fraction.MyFraction;

public class Fraction {
    private static Scanner in = new Scanner(System.in);

    private static FractionStatementParser.FractionStatement getStringFractionFromConsole() {
        System.out.println("Введите строку с двумя дробями и операцией,которую необходимо выполнить.\nСтрока должна быть введена в формате n/m(пробел)операция(пробел)k/l: ");
        String str = in.nextLine();
        return FractionStatementParser.parseInputAndReturnFractions(str);
    }

    private static void calculateFractionsInStringForm(fraction.FractionStatementParser.FractionStatement fractions) {
            FractionStatementParser.Operations operation = fractions.getOperation();
            MyFraction fraction1 = fractions.getFraction1();
            MyFraction fraction2 = fractions.getFraction2();

            switch (operation) {
                case SUM:
                    MyFraction sumResult = MyFraction.sumFraction(fraction1, fraction2);
                    System.out.println(sumResult);
                    break;
                case DIF:
                    MyFraction difResult = MyFraction.difFraction(fraction1, fraction2);
                    System.out.println(difResult);
                    break;
                case MULTIPLICATION:
                    MyFraction multiplicResult = MyFraction.multiplicFraction(fraction1, fraction2);
                    System.out.println(multiplicResult);
                    break;
                case DIVISION:
                    MyFraction divResult = MyFraction.divFraction(fraction1, fraction2);
                    System.out.println(divResult);
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    break;
            }
    }

    private static MyFraction getFractionFromConsole(String message) {
        System.out.println(message);
        try {
            System.out.println("Введите числитель дроби: ");
            int n = in.nextInt();
            System.out.println("Введите знаменатель дроби: ");
            int m = in.nextInt();
            MyFraction fraction = null;
            if (m != 0) {
                fraction = new MyFraction(n, m);
            } else {
                System.out.println("Знаменатель дроби не может быть равным нулю!");
                System.exit(1);
            }
            return fraction;
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести целое число!");
            System.exit(1);
        }
        return null;
    }

    private static void calculateFractions(MyFraction fraction1, MyFraction fraction2) {
        try {
            System.out.println("Выберите операцию для выполнения:сложение, вычитание, умножение, деление.\nВведите её словами: ");
            String operation = in.next();
            switch (operation) {
                case ("сложение"):
                    MyFraction sumResult = MyFraction.sumFraction(fraction1, fraction2);
                    System.out.println(sumResult);
                    break;
                case ("вычитание"):
                    MyFraction difResult = MyFraction.difFraction(fraction1, fraction2);
                    System.out.println(difResult);
                    break;
                case ("умножение"):
                    MyFraction multiplicResult = MyFraction.multiplicFraction(fraction1, fraction2);
                    System.out.println(multiplicResult);
                    break;
                case ("деление"):
                    MyFraction divResult = MyFraction.divFraction(fraction1, fraction2);
                    System.out.println(divResult);
                    break;
                default:
                    System.out.println("Такой операции нет!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Числитель и знаменатель дроби - целые числа!");
        }
    }

    public static void main(String args[]) {
        System.out.println("Выберите в каком формате вы хотите вводить выражение:\n Если в формате строки, то введите 1,\n Если числовом формате,то введите 2 ");
        System.out.println("Введите выбранное число: ");
        try {
            int n = Integer.parseInt(in.nextLine());
            if (n == 1) {
                calculateFractionsInStringForm(getStringFractionFromConsole());
            } else if (n == 2) {
                MyFraction fraction1 = getFractionFromConsole("Введите данные для первой дроби");
                MyFraction fraction2 = getFractionFromConsole("Введите данные для второй дроби");
                calculateFractions(fraction1, fraction2);
            } else {
                System.out.println("Других возможноcтей ввода нет!");
            }
        } catch (NumberFormatException e){
            System.out.println("Введите число!");
        }
        in.close();
    }
}