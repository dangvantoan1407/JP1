package java2demo1.demo4;

public class BankAccount {
    public int balance = 0;

    public synchronized void deposit(int amount) {
        if (amount <=0) return;
        balance+=amount;
        System.out.println("vừa nạp số tiền " + amount);
        notify();
    }

    public synchronized void withdraw(int amount) {
        if (amount <=0 ) return;
        while (amount>balance) {
            System.out.println("Số tiền cần rút vượt quá số tiền hiện có!");
            try {
//                Thread.sleep(10000);
                wait();
            }catch (Exception e) {}
        }
        balance-=amount;
        System.out.println("Vừa rút số tiền " + amount);
    }
}
