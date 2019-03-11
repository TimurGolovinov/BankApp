
public class TestBank {

    public static void main(String[] args) {

        // Instantiate 3 accounts
        // Using constructor with values
        Account a1 = new Account("Sanjay Gupta", 11556, 300);
        // Using default constructor
        Account a2 = new Account();
        Account a3 = new Account();

        //Set values of Instances created using default constructor
        a2.setAccountName("He Xai");
        a2.setAccountNumber(22338);
        a2.setBalance(500);

        a3.setAccountName("Ilya Mustafana");
        a3.setAccountNumber(44559);
        a3.setBalance(1000);

        // Print accounts
        a1.print();
        a2.print();
        a3.print();
    }
}
