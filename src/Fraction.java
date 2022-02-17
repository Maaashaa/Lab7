import java.util.InputMismatchException;
import java.util.Scanner;
import Fraction.MyFraction;
    public class Fraction {
        private static Scanner in = new Scanner(System.in);
        private static MyFraction getFractionFromConsole(String message){
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
            } catch (InputMismatchException e){
                System.out.println("Необходимо ввести целое число!");
                System.exit(1);
            }
            return null;
        }
        private static void calculateFractions(MyFraction fraction1,MyFraction fraction2){
            try {
                System.out.println("Выберите операцию для выполнения:сложение, вычитание, умножение, деление");
                String operation = in.next();
                switch (operation) {
                    case ("сложение"):
                        MyFraction sumResult = MyFraction.sumFraction(fraction1,fraction2);
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
                        System.out.println("Такой команды нет!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Числитель и знаменатель дроби - целые числа!");
            }
        }
        public static void main(String args[]) {
            MyFraction fraction1 = getFractionFromConsole("Введите данные для первой дроби");
            MyFraction fraction2 = getFractionFromConsole("Введите данные для второй дроби");
            calculateFractions(fraction1,fraction2);
            in.close();
        }
    }