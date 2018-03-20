import java.math.BigInteger;
import java.util.List;

public class StatementPrinter {
    private PrintlnConsole printlnConsole;

    public StatementPrinter(PrintlnConsole printlnConsole) {

        this.printlnConsole = printlnConsole;
    }

    public PrintlnConsole getPrintlnConsole() {
        return printlnConsole;
    }

    public void print(List<Statement> statements) {
        printlnConsole.println("date || amount || balance");
        BigInteger balance = new BigInteger("0");
        statements.stream().forEach(statement -> {
            balance.add(BigInteger.valueOf(statement.getAmount()));
            printlnConsole.println(statement.getDate()+" || "+ statement.getAmount() + " || "+ balance);
        });
    }
}
