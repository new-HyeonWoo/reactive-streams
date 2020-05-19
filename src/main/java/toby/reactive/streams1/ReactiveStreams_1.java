package toby.reactive.streams1;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("deprecation")
public class ReactiveStreams_1 {

    static class IntObservable extends Observable implements Runnable {

        @Override
        public void run() {
            for(int i=0; i<=10; i++) {
                setChanged();
                notifyObservers(i);
            }
        }
    }


    public static void main(String[] args) {

        Observer ob = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(Thread.currentThread().getName() + " " + arg);
;            }
        };


        IntObservable io = new IntObservable();
        io.addObserver(ob);

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(io);

        System.out.println(Thread.currentThread().getName() + " EXIT");
        es.shutdown();

    }

}
