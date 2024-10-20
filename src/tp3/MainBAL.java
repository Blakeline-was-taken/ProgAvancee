package tp3;

public class MainBAL {
    public static void main(String[] args) {
        String[] lettres = {"A", "B", "C", "D"};

        BAL bal = new BAL();
        Producteur producteur = new Producteur(bal, lettres);
        Consommateur consommateur = new Consommateur(bal);

        Thread threadProducteur = new Thread(producteur);
        Thread threadConsommateur = new Thread(consommateur);

        // Démarrer les deux threads
        threadProducteur.start();
        threadConsommateur.start();
    }
}

