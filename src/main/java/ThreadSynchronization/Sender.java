package ThreadSynchronization;

class Sender implements Runnable{
    private SharedObject buffer;
    public Sender(SharedObject buffer) {
        this.buffer = buffer;
    }
    public void run() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        for(Integer i : arr) {
            buffer.put(i);
            System.out.println("MESSAGE RECEIVED: " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
