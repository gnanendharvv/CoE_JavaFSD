class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " Deposited: " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient funds for withdrawal: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankUser implements Runnable {
    private final BankAccount account;

    public BankUser(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            account.withdraw(50);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(200);

        Thread user1 = new Thread(new BankUser(sharedAccount), "User1");
        Thread user2 = new Thread(new BankUser(sharedAccount), "User2");

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Final Balance: " + sharedAccount.getBalance());
    }
}
