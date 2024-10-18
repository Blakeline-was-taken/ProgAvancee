package tp2;

public class Affichage extends Thread{
	String texte;
	semaphore sem;

	public Affichage (String txt, semaphore thread){
		texte=txt;
		sem=thread;
	}
	
	public void run(){
		sem.syncWait();
		for (int i = 0; i < texte.length(); i++){
		    System.out.print(texte.charAt(i));
		    try {sleep(100);}
			catch (InterruptedException e) {}
		}
		sem.syncSignal();
	}
}
