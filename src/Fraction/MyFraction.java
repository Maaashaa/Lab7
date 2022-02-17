package Fraction;

public class MyFraction {
    private int numerator;
    private int denominator;

    public MyFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public MyFraction() {
        this.numerator = 1;
        this.denominator = 1;
    }
    public static MyFraction sumFraction(MyFraction fraction1, MyFraction fraction2) {
        int newDenominator = fraction1.denominator * fraction2.denominator;
        int newNumerator = fraction1.numerator * fraction2.denominator + fraction2.numerator * fraction1.denominator;
        return new MyFraction(newNumerator, newDenominator);
    }

    public void sumWithFraction(MyFraction fraction) {
        int newDenominator = fraction.denominator * this.denominator;
        int newNumerator = fraction.numerator * this.denominator + this.numerator * fraction.denominator;
        this.denominator = newDenominator;
        this.numerator = newNumerator;
    }

    public static MyFraction difFraction(MyFraction fraction1, MyFraction fraction2) {
        int newDenominator = fraction1.denominator * fraction2.denominator;
        int newNumerator = fraction1.numerator * fraction2.denominator - fraction2.numerator * fraction1.denominator;
        return new MyFraction(newNumerator, newDenominator);
    }

    public void difWithFraction(MyFraction fraction) {
        int newDenominator = fraction.denominator * this.denominator;
        int newNumerator = fraction.numerator * this.denominator - this.numerator * fraction.denominator;
        this.denominator = newDenominator;
        this.numerator = newNumerator;
    }

    public static MyFraction multiplicFraction(MyFraction fraction1, MyFraction fraction2) {
        int newDenominator = fraction1.denominator * fraction2.denominator;
        int newNumerator = fraction1.numerator * fraction2.numerator;
        return new MyFraction(newNumerator, newDenominator);
    }

    public void multiplicWithFraction(MyFraction fraction) {
        int newDenominator = fraction.denominator * this.denominator;
        int newNumerator = fraction.numerator * this.numerator;
        this.denominator = newDenominator;
        this.numerator = newNumerator;
    }

    public static MyFraction divFraction(MyFraction fraction1, MyFraction fraction2) {
        int newDenominator = fraction1.denominator * fraction2.numerator;
        int newNumerator = fraction1.numerator * fraction2.denominator;
        return new MyFraction(newNumerator, newDenominator);
    }

    public void divWithFraction(MyFraction fraction) {
        int newDenominator = fraction.denominator * this.numerator;
        int newNumerator = fraction.numerator * this.denominator;
        this.denominator = newDenominator;
        this.numerator = newNumerator;
    }

    @Override
    public String toString() {
        return "fraction=" + numerator +
                "/"+ denominator;
    }
}