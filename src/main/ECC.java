package main;

public class ECC {
    // y^2 = x^3 + ax + b
    // Bitcoin: a = 0, b = 7 (y^2 = x^3+7)
    private double a;
    private double b;

    public ECC(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // tem 0(n) complexidade de tempo de execução linear
    public Point doubleAndAdd(Point p, int n) {
        Point r = new Point(0, 0);
        Point q = p;
        while (n > 0) {
            if (n % 2 == 1) {
                r = pointAddition(r, q);
            }
            q = pointAddition(q, q);
            n = n / 2;
        }
        return r;
    }

    public Point pointAddition(Point p, Point q) {

        double x1 = p.getX();
        double y1 = p.getY();
        double x2 = q.getX();
        double y2 = q.getY();

        double m = 0;
        // às vezes temos que fazer a adição de pontos em vez de subtração
        // se P = Q então precisamos fazer ponto dubling
        if(Double.compare(x1, x2) == 0 && Double.compare(y1, y2) == 0) {
            // duplicação de pontos (P=Q)
            m = (3 * x1 * x1 + a) / (2 * y1);
        } else {
            m = (y2 - y1) / (x2 - x1);
        }
        // podemos calcular a adição de pontos usando a fórmula
        double x3 = m*m - x2 -x1;
        double y3 = m*(x1 - x3) - y1;

        return new Point(x3, y3);
    }
}
