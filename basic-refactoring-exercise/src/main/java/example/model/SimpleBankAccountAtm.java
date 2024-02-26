package example.model;

public class SimpleBankAccountAtm extends SimpleBankAccount {

    private final static int FEE = 1;

    public SimpleBankAccountAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + FEE);
    }
    
}
