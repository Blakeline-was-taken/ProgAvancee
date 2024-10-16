import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre(){
        // Configuration du Conteneur
        super("Le Mobile");
        Container leConteneur = getContentPane();

        // Ajout du mobile
        sonMobile = new UnMobile(LARG,HAUT);
        leConteneur.add(sonMobile);

        // Lancement de la tâche
        Thread laTache = new Thread(sonMobile);
        laTache.start();

        // Lancement de la fenêtre
        setSize(LARG, HAUT);
        setVisible(true);
    }
}
