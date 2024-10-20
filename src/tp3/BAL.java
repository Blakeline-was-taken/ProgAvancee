package tp3;

public class BAL {
    private String lettre;
    private boolean lettreDispo = false;

    public synchronized void depose(String lettre) throws InterruptedException {
        // Attendre que la BAL soit vide avant de déposer une lettre
        while (lettreDispo) {
            wait();
        }
        this.lettre = lettre;
        lettreDispo = true;
        System.out.println("Producteur a déposé: " + lettre);
        notifyAll();
    }

    public synchronized String retrait() throws InterruptedException {
        // Attendre que la BAL contienne une lettre avant de la retirer
        while (!lettreDispo) {
            wait();
        }
        String lettreRetiree = this.lettre;
        lettreDispo = false;
        System.out.println("Consommateur a retiré: " + lettreRetiree);
        notifyAll();
        return lettreRetiree;
    }
}

