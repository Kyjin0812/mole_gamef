package ThreadSynchronization;

class Receiver implements Runnable{
    private SharedObject buffer;

    public Receiver(SharedObject drop) {
        this.buffer = drop;
    }

    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
             sum += buffer.take();
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Sum: " + sum);
    }
}
