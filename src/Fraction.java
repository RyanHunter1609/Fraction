import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1; // denominator must never be zero
    }

    public Fraction(int numerator, int denominator) {
        int div = gcd(numerator, denominator);
        this.numerator = numerator / div;
        if (denominator != 0)
            this.denominator = denominator / div;
        else
            this.denominator = 1;
    }

    @Override
    public String toString() {
        String format_str = "%d/%d";
        return String.format(format_str, numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction rhs) {
        return new Fraction(
                numerator * rhs.denominator + rhs.numerator * denominator,
                denominator * rhs.denominator);
    }

    public Fraction multiply(Fraction rhs) {
        return new Fraction(
                numerator * rhs.numerator,
                denominator * rhs.denominator);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
