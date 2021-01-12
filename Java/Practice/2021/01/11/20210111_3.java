public class MyRunnable implements Runnable{
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("top of the stack");
    }
}

class ThreadTester {
    public static void main(String[] args) {
        Runnable theadJob = new MyRunnable();
        Thread myTread = new Thread(theadJob);
        myTread.start();
        System.out.println("back in main");
    }
}
