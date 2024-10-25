package tp3;

import java.util.Scanner;

public class Producteur implements Runnable {
    private BAL bal;
    private String[] lettres = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public Producteur(BAL bal) {
        this.bal = bal;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            for (String lettre : lettres) {
                bal.depose(lettre);
                Thread.sleep(1000);
            }
            // Indiquer la fin avec la lettre '*'
            bal.depose("*");
        } catch (InterruptedException e) {Thread.currentThread().interrupt();
        } finally {scanner.close();}
    }
}
