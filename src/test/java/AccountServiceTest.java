import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {




    @Mock
    private StatementsRepository statementRepository;
    @Mock
    private StatementPrinter statementPrinter;

    @Test
    public void accountShoudDoADeposit()  {
        AccountService account = new AccountService(statementRepository, statementPrinter);
        Statement positiveStatement = new Statement(0, LocalDate.of(2000,1,1));

        account.deposit(0);

        verify(statementRepository).add(positiveStatement);
    }

    @Test
    public void accountShouldAcceptWithdrawal() {
        AccountService account = new AccountService(statementRepository, statementPrinter);
        Statement negativeStatement = new Statement(-10, LocalDate.of(2000, 1, 1));

        account.withdrawal(10);

        verify(statementRepository).add(negativeStatement);
    }


    @Test
    public void printEmptyAccountStatements(){
        AccountService account = new AccountService(statementRepository,statementPrinter);
        account.printStatements();
        verify(statementPrinter).print(new ArrayList<Statement>());

    }



  /*  @Test(expected = Exception.class)
    public void catches() throws Exception {
        Kata k = new Kata();
        throw new Exception();
    }*/
}