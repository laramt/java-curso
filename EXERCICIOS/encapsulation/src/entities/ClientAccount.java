package entities;

public class ClientAccount {

    private int number;
    private String holder;
    private double balance;

    // constructor
    public ClientAccount(int number, String holder, double initialDeposit) {
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
    }

    public ClientAccount(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    // getter and setter
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    // methods
    public void deposit(double balance) {
        this.balance += balance;
    }

    public void drawBalance(double balance) {
        this.balance -= balance + 5.00;
    }

    //toString
    public String toString(){
        return "Account: " +getNumber()
                + ", Holder: " +getHolder()
                + String.format(", Balance: $ %.2f", getBalance());
    }

}
