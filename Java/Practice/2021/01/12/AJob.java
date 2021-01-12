public class AJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        AJob aJob = new AJob();
        Thread one = new Thread(aJob);
        Thread two = new Thread(aJob);
        one.setName("yangguo");
        two.setName("xiaolongnv");
        one.start();
        two.start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithDrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("overdraw !");
            }
        }
    }

    private void makeWithDrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is about to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " is about to wake up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " finish withdraw");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}
