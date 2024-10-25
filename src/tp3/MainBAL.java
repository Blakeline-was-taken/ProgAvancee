package tp3;

public class MainBAL {
    public static void main(String[] args) {
        BAL bal = new BAL();

        Producteur producteur = new Producteur(bal);
        Consommateur consommateur = new Consommateur(bal);

        Thread [] producteurs = new Thread[4];
        Thread [] consommateurs = new Thread[3];

        // Démarrer les threads
        for (int i=0;i < producteurs.length;i++) {
            producteurs[i] = new Thread(producteur);
            producteurs[i].start();
        }
        for (int i=0;i < consommateurs.length;i++) {
            consommateurs[i] = new Thread(consommateur);
            consommateurs[i].start();
        }
    }
}

