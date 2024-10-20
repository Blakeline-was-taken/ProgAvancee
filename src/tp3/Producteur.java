package tp3;

import java.util.Scanner;

public class Producteur implements Runnable {
    private BAL bal;

    public Producteur(BAL bal) {
        this.bal = bal;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String lettre;
            do {
                System.out.print("Entrez une lettre à déposer (ou 'Q' pour quitter) : ");
                lettre = scanner.nextLine();
                bal.depose(lettre);
            } while (!lettre.equals("Q"));  // Le programme continue tant que la lettre n'est pas 'Q'
        } catch (InterruptedException e) {Thread.currentThread().interrupt();
        } finally {scanner.close();}
    }
}
