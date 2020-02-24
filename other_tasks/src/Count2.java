import java.util.concurrent.Semaphore;
class IntCell2{
    private int n = 0;

    private boolean isSet = true;
    public synchronized int getN() {
        while (!isSet)
            waitForNotifying();
        isSet = false;
        notifyAll();
        return n;
    }
    public synchronized void setN(int n) {
        while(isSet)
            waitForNotifying();
        this.n = n;
        isSet = true;
        notifyAll();
    }
    private void waitForNotifying() {
        System.out.println("wait\n");
        try {

            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Count2 extends Thread {
    private static IntCell2 n = new IntCell2();

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 10; i++) {
            temp = n.getN();
            n.setN(temp + 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println("The value of n is ");
        Count2 p = new Count2();
        Count2 q = new Count2();
        p.start();
        q.start();
        try {
            p.join();
            q.join();
            //System.out.println("The value of n is ");
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n.getN());
    }
}