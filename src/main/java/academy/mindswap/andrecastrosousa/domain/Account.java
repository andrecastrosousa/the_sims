package academy.mindswap.andrecastrosousa.domain;

import academy.mindswap.andrecastrosousa.exceptions.NoFundsEnoughtException;

import java.io.Serializable;

public class Account implements Serializable {
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

    public void pay(double amount) throws NoFundsEnoughtException {
        if(balance - amount < 0) {
            throw new NoFundsEnoughtException();
        }
        balance -= amount;
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
