package tp2;

public class Main {

	public static void main(String[] args) {
		semaphoreBinaire sem = new semaphoreBinaire(1);

		Affichage TA = new Affichage("AAA", sem);
		Affichage TB = new Affichage("BB", sem);

		TB.start();

		TA.start();
	}
}
