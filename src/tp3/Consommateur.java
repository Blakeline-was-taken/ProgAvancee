package tp3;

public class Consommateur implements Runnable {
    private final BAL bal;

    public Consommateur(BAL saBal) {bal = saBal;}

    public void run() {
        try {
            String lettre;
            do {
                lettre = bal.retrait();
                Thread.sleep(1500);
            } while (!lettre.equals("*"));
        } catch (InterruptedException e) {Thread.currentThread().interrupt();}
    }
}

