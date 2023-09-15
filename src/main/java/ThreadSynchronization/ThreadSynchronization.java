package ThreadSynchronization;

public class ThreadSynchronization {
    public static void main(String[] args) {
        SharedObject buffer = new SharedObject();
        (new Thread(new Sender(buffer))).start();
        (new Thread(new Receiver(buffer))).start();
    }
}
