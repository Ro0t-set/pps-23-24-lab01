import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountAtm;

public class SimpleBankAccountWithAtmTest{

    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountAtm(accountHolder, 0);
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        int depositLessFee = 100 - 1;
        assertEquals(depositLessFee, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        int depositLessFee = 100 - 70 - 2;
        assertEquals(depositLessFee, bankAccount.getBalance());
    }



}

    

