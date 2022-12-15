import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter @Setter private String name;
    @Getter @Setter private String surname;
    @Getter @Setter private String address;
    @Getter @Setter private int age;
    @Getter @Setter private Account account;

    @Getter @Setter private String pin;

    public Person(){}
    public Person(String name, String surname, int age,String address, Account account) {
        this.name = name;
        this.address = address;
        this.surname = surname;
        this.age = age;
        this.account = account;
    }

    public double getBalance(){
        return this.account.getBalance();
    }

    public void setBalance(double balance){
        this.account.setBalance(balance);
    }

}
