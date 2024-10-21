package tp1;

import java.awt.*;
import javax.swing.*;
import java.lang.Math;

class UneFenetre extends JFrame{
    private final int LARG=1000, HAUT=800, NBRLIG=20, NBRCOL=1;

    public UneFenetre(){
        super("Le Mobile");
        Container leConteneur = getContentPane();
        leConteneur.setLayout(new GridLayout(NBRLIG, NBRCOL));
        semaphore semGen = new semaphoreGeneral(5);
        for (int i = 0; i < NBRLIG; i++){
            UnMobile mobile = new UnMobile(LARG - 50, HAUT / NBRLIG, (int)(Math.random() * 100)+5, semGen);
            leConteneur.add(mobile);
            Thread laTache = new Thread(mobile);
            laTache.start();
        }
        setSize(LARG, HAUT);
        setVisible(true);
    }
}
