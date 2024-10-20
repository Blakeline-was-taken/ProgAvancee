package tp3;

public class MainBAL {
    public static void main(String[] args) {
        BAL bal = new BAL();
        Producteur producteur = new Producteur(bal);
        Consommateur consommateur = new Consommateur(bal);

        Thread threadProducteur = new Thread(producteur);
        Thread threadConsommateur = new Thread(consommateur);

        // Démarrer les deux threads
        threadProducteur.start();
        threadConsommateur.start();
    }
}

