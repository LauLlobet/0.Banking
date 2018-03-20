import java.time.LocalDate;

public class AccountService {

    private final StatementsRepository repository;
    private StatementPrinter statementPrinter;

    public AccountService(StatementsRepository repository, StatementPrinter statementPrinter){
        this.repository = repository;
        this.statementPrinter = statementPrinter;
    }
    public void deposit(int amount) {
        Statement newStatement = new Statement(amount, LocalDate.of(2000, 1, 1));
         repository.add(newStatement);

    }

    public void withdrawal(int amount) {
        Statement newStatement = new Statement(-amount, LocalDate.of(2000, 1, 1));
        repository.add(newStatement);
    }

    public void printStatements() {
        statementPrinter.print(repository.getStatements());
    }
}
