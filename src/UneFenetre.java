import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame {
    UnMobile sonMobile;
    JButton sonBouton;
    private final int LARG = 400, HAUT = 250;

    public UneFenetre() {
        // Configuration du Conteneur
        super("Le Mobile");
        Container leConteneur = getContentPane();

        // Ajout du mobile
        sonMobile = new UnMobile(LARG, HAUT);
        leConteneur.add(sonMobile);

        // Lancement de la tâche
        Thread laTache = new Thread(sonMobile);
        laTache.start();

        // Ajout du bouton
        sonBouton = new JButton("Stop");
        sonBouton.addActionListener(e -> {
            if (sonBouton.getText() == "Stop") {
                // On arrête le mobile
                sonBouton.setText("Start");
                laTache.suspend();
            } else {
                // On relance le mobile
                sonBouton.setText("Stop");
                laTache.resume();
            }
        });
        leConteneur.add(sonBouton, BorderLayout.SOUTH);

        // Configuration de la fenêtre
        setSize(LARG, HAUT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
