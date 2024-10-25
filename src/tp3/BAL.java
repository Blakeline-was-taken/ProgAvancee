package tp3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BAL {
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);

    public void depose(String lettre) throws InterruptedException {
        queue.offer(lettre, 200, TimeUnit.MILLISECONDS);
        System.out.println("Producteur a déposé: " + lettre);
    }

    public String retrait() throws InterruptedException {
        String lettre = queue.poll(200, TimeUnit.MILLISECONDS);
        System.out.println("Consommateur a retiré: " + lettre);
        return lettre;
    }
}

