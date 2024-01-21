import java.util.Scanner;
class BankAccount{
    private int balance;
    public BankAccount(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return this.balance;
    }
    public void deposit(int amount){
        if(amount>0) {
            this.balance += amount;
            System.out.println("Amount deposited successfully");
            System.out.println("Current Balance : "+this.balance);
        }
        else
            System.out.println("Invalid amount");
    }
    public void withdraw(int amount){
        if(amount>0 && amount<=this.balance){
            this.balance -= amount;
            System.out.println("withdraw successful");
            System.out.println("your current balance : "+this.balance);
        }
        else
            System.out.println("Invalid amount for withdraw");
    }
}
class ATM{
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    public void display(){
        System.out.println("Welcome to ATM");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Check balance");
        System.out.println("4. Close");
    }
    public void runATM(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            this.display();
            System.out.print("Select option : ");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Enter amount for deposit : ");
                    int amount = sc.nextInt();
                    bankAccount.deposit(amount);
                    break;
                }
                case 2: {
                    System.out.print("Enter amount for withdraw : ");
                    int amount = sc.nextInt();
                    bankAccount.withdraw(amount);
                    break;
                }
                case 3: {
                    System.out.println("Balance : " + bankAccount.getBalance());
                    break;
                }
                case 4: {
                    System.exit(0);
                }
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1500000);
        ATM atm = new ATM(bankAccount);
        atm.runATM();
    }
}