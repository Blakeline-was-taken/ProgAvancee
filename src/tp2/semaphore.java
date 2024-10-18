package tp2;

public abstract class semaphore {

    protected int valeur=0;

    protected semaphore (int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait(){
        try {
            while(valeur<=0){wait();}
            System.out.println("j'entre en section critique.");
            valeur--;
        } catch (InterruptedException e) {}
    }

    public synchronized void syncSignal(){
	    if(++valeur > 0) notifyAll();
        System.out.println("je sors de section critique.");
    }
}
