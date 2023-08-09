package academy.mindswap.andrecastrosousa.server.models;

import academy.mindswap.andrecastrosousa.client.exceptions.NoFundsEnoughtException;

import java.io.Serializable;

public class Account extends Entity implements Serializable {
    private double balance;

    public Account(Long id, double balance) {
        super.id = id;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void pay(double amount) throws NoFundsEnoughtException {
        if(balance - amount < 0) {
            throw new NoFundsEnoughtException();
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account: " + id + "\n" +
                "balance: " + balance + "€";
    }
}
