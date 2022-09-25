package main;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        // y^2 = x^3 + ax + b
        // Bitcoin: a = 0, b = 7 (y^2 = x^3+7)
        ECC ecc = new ECC(3, 7);
        Point generator = new Point(-2,1);
        Random random = new Random();

        // Algoritmo Difie-Hellman de Curva Elíptica
        // Número aleatório para Alice
        System.out.println(ecc.doubleAndAdd(generator, 2));
        int a = random.nextInt(10000);
        // Número aleatório para Bob
        int b = random.nextInt(10000);
        // Alice envia a chave pública para Bob
        Point alicePublicKey = ecc.doubleAndAdd(generator, a);
        // Bob envia a chave pública para Alice
        Point bobPublicKey = ecc.doubleAndAdd(generator, b);
        // Alice calcula a chave secreta
        Point aliceSecretKey = ecc.doubleAndAdd(bobPublicKey, a);
        // Bob calcula a chave secreta
        Point bobSecretKey = ecc.doubleAndAdd(alicePublicKey, b);
        // Chaves secretas são iguais
        System.out.println(aliceSecretKey);
        System.out.println(bobSecretKey);

    }

}
