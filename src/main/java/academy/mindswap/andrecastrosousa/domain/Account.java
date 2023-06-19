package academy.mindswap.andrecastrosousa.domain;

public class Account {
    private double balance;

    private final int id;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account: " + id + "\n" +
                "balance: " + balance + "€";
    }
}
