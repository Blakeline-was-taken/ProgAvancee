package tp1;

import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable{
	int saLargeur, saHauteur, sonDebDessin, sonTemps;
	final int sonPas = 10, sonCote=40;
	semaphore sonSemaphore;

	UnMobile(int telleLargeur, int telleHauteur, int telTemps, semaphore telSem)    {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		sonTemps = telTemps;
		sonSemaphore = telSem;
		setSize(telleLargeur, telleHauteur);
	}

	private void draw(){
		repaint();
		try {Thread.sleep(sonTemps);
		} catch (InterruptedException telleExcp)
		{telleExcp.printStackTrace();}
	}

	public void run(){
		while (true) {
			// Gauche à Droite
			for (sonDebDessin = 0; sonDebDessin*3 < saLargeur - sonPas; sonDebDessin += sonPas) {
				draw();
			}

			//Section critique
			this.setForeground(Color.RED);
			sonSemaphore.syncWait();
			this.setForeground(Color.BLACK);

			for (;sonDebDessin < (saLargeur - sonPas) / 3 * 2;sonDebDessin += sonPas) {
				draw();
			}
			sonSemaphore.syncSignal();
			for (;sonDebDessin < saLargeur - sonPas;sonDebDessin += sonPas) {
				draw();
			}

			// Droite à Gauche
			for (sonDebDessin = saLargeur; sonDebDessin > (saLargeur - sonPas) / 3 * 2; sonDebDessin -= sonPas) {
				draw();
			}

			// Section critique
			this.setForeground(Color.RED);
			sonSemaphore.syncWait();
			this.setForeground(Color.BLACK);

			for (; sonDebDessin*3 > saLargeur - sonPas; sonDebDessin -= sonPas) {
				draw();
			}
			sonSemaphore.syncSignal();
			for (; sonDebDessin > sonPas; sonDebDessin -= sonPas) {
				draw();
			}
		}
	}

	public void paintComponent(Graphics telCG){
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
	}
}