package tech.makers.bank;

public class Statement {
    private final String header = "date || credit || debit || balance\n";

    public String print() {
        return header;
    }
}
