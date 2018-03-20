import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {

    @Mock
    private PrintlnConsole printlnConsole;

    @Test
    public void statementPrinterShoudlPrintWithTheGivenFormatWhenEmpty(){
        StatementPrinter statementPrinter = new StatementPrinter(printlnConsole);

        statementPrinter.print(new ArrayList<Statement>());

        verify(printlnConsole).println("date || amount || balance");
    }

    @Test
    public void statementPrinterShouldPrintOnetatement(){
        StatementPrinter statementPrinter = new StatementPrinter(printlnConsole);
        Statement one = new Statement(100, LocalDate.of(2000, 1, 1));
        List<Statement> listOfStatements = Arrays.asList(one);

        statementPrinter.print(listOfStatements);

        verify(printlnConsole).println("date || amount || balance");
        verify(printlnConsole).println("01/01/2000 || 100 || 100");
    }
}
