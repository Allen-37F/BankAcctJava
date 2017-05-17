/**
 * Created by Allen on 5/17/17. boom
 */
package allen.bank;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double debit(double amount) {
        if (balance < amount) {
            amount = balance;
        }

        balance -= amount;
        return amount;
    }

}

