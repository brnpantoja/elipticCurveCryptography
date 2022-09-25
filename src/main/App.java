package main;

public class App {
    public static void main(String[] args) {
        // y^2 = x^3 + ax + b
        // Bitcoin: a = 0, b = 7 (y^2 = x^3+7)
        ECC ecc = new ECC(0, 7);
        Point p = new Point(2, 4);
        Point q = new Point(3, 7);
        Point r = ecc.pointAddition(p, q);
        System.out.println(r);
    }

}
