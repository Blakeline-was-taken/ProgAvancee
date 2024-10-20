package tp3;

public class Producteur implements Runnable {
    private final BAL bal;
    String[] lettres;

    public Producteur(BAL saBal, String[] sesLettres) {bal = saBal;lettres = sesLettres;}

    public void run() {
        try {
            for (String lettre : lettres) {
                bal.depose(lettre);
                Thread.sleep(1000);
            }
            // Indiquer la fin avec la lettre 'Q'
            bal.depose("Q");
        } catch (InterruptedException e) {Thread.currentThread().interrupt();}
    }
}

