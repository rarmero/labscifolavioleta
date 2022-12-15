import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Account {
    @Getter @Setter private String accountNumber;
    @Getter @Setter private String pin;
    @Getter @Setter private double balance;
    // Other properties for an Account...

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
}