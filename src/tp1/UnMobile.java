package tp1;

import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable {
	private int saLargeur, saHauteur, sonDebDessin;
	private final int sonPas = 10, sonTemps = 50, sonCote = 40;
	private volatile boolean enPause = false;

	UnMobile(int telleLargeur, int telleHauteur) {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
	}

	public void run() {
		// Déplacement du mobile de gauche à droite
		while (true) {
			for (sonDebDessin = 0; sonDebDessin < saLargeur - sonPas; sonDebDessin += sonPas) {
				// Pause si enPause est vrai
				while (enPause){
					try {Thread.sleep(100);} // On attend un peu avant de vérifier à nouveau
					catch (InterruptedException telleExcp)
					{telleExcp.printStackTrace();}
				}
				repaint();
				try {Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				{telleExcp.printStackTrace();}
			}
			// Déplacement du mobile de droite à gauche
			for (sonDebDessin = saLargeur; sonDebDessin > sonPas; sonDebDessin -= sonPas) {
				// Pause si enPause est vrai
				while (enPause){
					try {Thread.sleep(100);} // On attend un peu avant de vérifier à nouveau
					catch (InterruptedException telleExcp)
					{telleExcp.printStackTrace();}
				}
				repaint();
				try {Thread.sleep(sonTemps);}
				catch (InterruptedException telleExcp)
				{telleExcp.printStackTrace();}
			}
		}
	}

	public void paintComponent(Graphics telCG) {
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur / 2, sonCote, sonCote);
	}

	public void setPause(boolean pause) {
		this.enPause = pause;
	}
}