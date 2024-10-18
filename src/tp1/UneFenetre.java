package tp1;

import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame {
    UnMobile sonMobile1, sonMobile2;
    JButton sonBouton1, sonBouton2;
    private final int LARG = 400, HAUT = 250;

    public UneFenetre() {
        // Configuration du Conteneur
        super("Les Mobiles");
        Container leConteneur = getContentPane();
        leConteneur.setLayout(new GridLayout(2, 2)); // Grille de 2x2

        // Ajout du premier mobile
        sonMobile1 = new UnMobile(LARG, HAUT);
        leConteneur.add(sonMobile1);

        // Ajout du bouton pour le premier mobile
        sonBouton1 = new JButton("Stop 1");
        sonBouton1.addActionListener(e -> {
            if (sonBouton1.getText().equals("Stop 1")) {
                sonBouton1.setText("Start 1");
                sonMobile1.setPause(true);
            } else {
                sonBouton1.setText("Stop 1");
                sonMobile1.setPause(false);
            }
        });
        leConteneur.add(sonBouton1);

        // Ajout du deuxième mobile
        sonMobile2 = new UnMobile(LARG, HAUT);
        leConteneur.add(sonMobile2);

        // Ajout du bouton pour le deuxième mobile
        sonBouton2 = new JButton("Stop 2");
        sonBouton2.addActionListener(e -> {
            if (sonBouton2.getText().equals("Stop 2")) {
                sonBouton2.setText("Start 2");
                sonMobile2.setPause(true);
            } else {
                sonBouton2.setText("Stop 2");
                sonMobile2.setPause(false);
            }
        });
        leConteneur.add(sonBouton2);

        // Lancement des tâches
        Thread laTache1 = new Thread(sonMobile1);
        laTache1.start();
        Thread laTache2 = new Thread(sonMobile2);
        laTache2.start();

        // Configuration de la fenêtre
        setSize(LARG, HAUT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
