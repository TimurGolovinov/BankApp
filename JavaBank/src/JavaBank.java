
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JavaBank extends JFrame {

    private static final long SERIAL_VERSION_UID = 1L;
    // Make these variables publicly available
    public String name;
    public int accountNumber;
    public int balance;

    // JPanel for user inputs
    private JPanel inputDetailJPanel;

    // JLabel and JTextField for account name
    private JLabel nameJLabel;
    private JTextField nameJTextField;

    // JLabel and JTextField for account number
    private JLabel accountNumberJLabel;
    private JTextField accountNumberJTextField;

    // JLabel and JTextField for balance
    private JLabel balanceJLabel;
    private JTextField balanceJTextField;

    // JLabel and JTextField for withdraw
    private JLabel depositJLabel;
    private JTextField depositJTextField;

    // JLabel and JTextField for Withdraw
    private JLabel withdrawJLabel;
    private JTextField withdrawJTextField;

    // JButton to create account
    private JButton createAccountJButton;

    // JButton to delete account
    private JButton deleteAccountJButton;

    // JButton to make transaction
    private JButton transactionJButton;

    // JButton to display account
    private JButton displayJButton;

    // JLabel and JTextArea to display account details
    private JLabel displayJLabel;
    private static JTextArea displayJTextArea;

    // constants
    //public  final static Maximum Accounts that can be created;
    public final static int MAX_ACCOUNTS = 10;

    // one-dimensional array to store Account names as Empty or Used
    static String[] accountNames = new String[MAX_ACCOUNTS];

    // two-dimensional array to store Account details
    static Account myAccounts[] = new Account[MAX_ACCOUNTS];

    static int noAccounts = 0;

    // constructor
    public JavaBank() {
        for (int i = 0; i < 10; i++) {
            accountNames[i] = "EMPTY";
            //System.out.println(AccountNames[i]);

        }
        createUserInterface();
    }

    // create and position GUI components; register event handlers
    private void createUserInterface() {
        // get content pane for attaching GUI components
        Container contentPane = getContentPane();

        // enable explicit positioning of GUI components
        contentPane.setLayout(null);

        // set up inputDetailJPanel
        inputDetailJPanel = new JPanel();
        inputDetailJPanel.setBounds(16, 16, 208, 250);
        inputDetailJPanel.setBorder(new TitledBorder("Input Details"));
        inputDetailJPanel.setLayout(null);
        contentPane.add(inputDetailJPanel);

        // set up NameJLabel
        nameJLabel = new JLabel();
        nameJLabel.setBounds(8, 32, 90, 23);
        nameJLabel.setText("Name:");
        inputDetailJPanel.add(nameJLabel);

        // set up NameJTextField
        nameJTextField = new JTextField();
        nameJTextField.setBounds(112, 32, 80, 21);
        nameJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(nameJTextField);

        // set up AccountnumJLabel
        accountNumberJLabel = new JLabel();
        accountNumberJLabel.setBounds(8, 56, 100, 23);
        accountNumberJLabel.setText("Account Number:");
        inputDetailJPanel.add(accountNumberJLabel);

        // set up AccountnumTextField
        accountNumberJTextField = new JTextField();
        accountNumberJTextField.setBounds(112, 56, 80, 21);
        accountNumberJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(accountNumberJTextField);

        // set up BalanceJLabel
        balanceJLabel = new JLabel();
        balanceJLabel.setBounds(8, 80, 60, 23);
        balanceJLabel.setText("Balance:");
        inputDetailJPanel.add(balanceJLabel);

        // set up BalanceTextField
        balanceJTextField = new JTextField();
        balanceJTextField.setBounds(112, 80, 80, 21);
        balanceJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(balanceJTextField);

        // set up DepositJLabel
        depositJLabel = new JLabel();
        depositJLabel.setBounds(8, 104, 80, 23);
        depositJLabel.setText("Deposit:");
        inputDetailJPanel.add(depositJLabel);

        // set up DepositJTextField
        depositJTextField = new JTextField();
        depositJTextField.setBounds(112, 104, 80, 21);
        depositJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(depositJTextField);

        // set up WithdrawJLabel
        withdrawJLabel = new JLabel();
        withdrawJLabel.setBounds(8, 128, 60, 23);
        withdrawJLabel.setText("Withdraw:");
        inputDetailJPanel.add(withdrawJLabel);

        // set up WithdrawJTextField
        withdrawJTextField = new JTextField();
        withdrawJTextField.setBounds(112, 128, 80, 21);
        withdrawJTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputDetailJPanel.add(withdrawJTextField);

        // set up CreateAccountButton
        createAccountJButton = new JButton();
        createAccountJButton.setBounds(112, 152, 80, 24);
        createAccountJButton.setText("Create");
        inputDetailJPanel.add(createAccountJButton);
        createAccountJButton.addActionListener(
                new ActionListener() {
            // event handler called when CreateAccountJButton
            // is clicked
            public void actionPerformed(ActionEvent event) {
                createAccountJButtonActionPerformed(event);
            }

        }
        ); // end call to addActionListener

        // set up DeleteAccountButton
        deleteAccountJButton = new JButton();
        deleteAccountJButton.setBounds(16, 152, 80, 24);
        deleteAccountJButton.setText("Delete");
        inputDetailJPanel.add(deleteAccountJButton);
        deleteAccountJButton.addActionListener(
                new ActionListener() // anonymous inner class
        {
            // event handler called when DeleteAccountJButton
            // is clicked
            public void actionPerformed(ActionEvent event) {
                deleteAccountJButtonActionPerformed(event);

            }

        }
        ); // end call to addActionListener

        // set up TransactionJButton
        transactionJButton = new JButton();
        transactionJButton.setBounds(16, 180, 176, 24);
        transactionJButton.setText("Make Transaction");
        inputDetailJPanel.add(transactionJButton);
        transactionJButton.addActionListener(
                new ActionListener() // anonymous inner class
        {
            // event handler called when TransactionJButton
            // is clicked
            public void actionPerformed(ActionEvent event) {
                transactionJButtonActionPerformed(event);
            }

        } // end anonymous inner class

        ); // end call to addActionListener

        // set up DisplayJButton
        displayJButton = new JButton();
        displayJButton.setBounds(16, 208, 176, 24);
        displayJButton.setText("Display Accounts");
        inputDetailJPanel.add(displayJButton);
        displayJButton.addActionListener(
                new ActionListener() // anonymous inner class
        {
            // event handler called when TransactionJButton
            // is clicked
            public void actionPerformed(ActionEvent event) {
                displayJButtonActionPerformed(event);
            }

        } // end anonymous inner class

        ); // end call to addActionListener

        // set up displayJLabel
        displayJLabel = new JLabel();
        displayJLabel.setBounds(240, 16, 150, 23);
        displayJLabel.setText("Account Details:");
        contentPane.add(displayJLabel);

        // set up displayJTextArea
        displayJTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayJTextArea);
        scrollPane.setBounds(240, 48, 402, 184);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
        displayJTextArea.setText("Welcome to Java Bank - There are currently no Accounts created");

        // clear other JTextFields for new data
        nameJTextField.setText(" ");
        accountNumberJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");

        // set properties of application's window
        setTitle("Java Bank"); // set title bar string
        setSize(670, 308); // set window size
        setVisible(true); // display window

    } // end method createUserInterface

    private void createAccountJButtonActionPerformed(ActionEvent event) {
        // System.out.println("Create Account Button Clicked");

        displayJTextArea.setText("");
        name = "";
        //Get Name from Text Field
        name = nameJTextField.getText();

        //Get Accountnum from Text Field and convert to int unless blank then set to 0
        if (accountNumberJTextField.getText() == "0") {
            accountNumber = 0;
        } else {
            accountNumber = Integer.parseInt(accountNumberJTextField.getText());
        }

        //Get Balance from Text Field and convert to int unless blank then set to 0
        if (balanceJTextField.getText() == "0") {
            balance = 0;
        } else {
            balance = Integer.parseInt(balanceJTextField.getText());
        }

        //int emptyAccount = 11;
        if ((noAccounts <= 9) & (name != "") & (accountNumber != 0)) {
            myAccounts[noAccounts] = new Account(name, accountNumber, balance);
            accountNames[noAccounts] = "USED";
            //System.out.println(myAccounts[noAccounts].getaccountname());
            //emptyAccount = i;         		

            displayJTextArea.setText(myAccounts[noAccounts].getAccountName() + " " + myAccounts[noAccounts].getAccountNumber() + " " + myAccounts[noAccounts].getBalance());
            noAccounts++;
            System.out.println(noAccounts);
        } else {
            displayJTextArea.setText("Both the Name field and Account Number must be completed");
        }

        if (noAccounts == 10) {
            // Once account 10 is created. All accounts full.
            displayJTextArea.setText("All Accounts Full!");
        }

        // clear other JTextFields for new data
        nameJTextField.setText(" ");
        accountNumberJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");

    }

    private void deleteAccountJButtonActionPerformed(ActionEvent event) {

        displayJTextArea.setText("Oops this isnt coded in this version!");
        //Name = NameJTextField.getText();
        //System.out.println("Delete Account: " + Name);

        // Enter code to delete here
        // clear JTextFields for new data
        nameJTextField.setText(" ");
        accountNumberJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");

    }

    private void transactionJButtonActionPerformed(ActionEvent event) {

        displayJTextArea.setText("");

        if (noAccounts == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {

            // get user input
            int Accountnum = Integer.parseInt(accountNumberJTextField.getText());
            int Deposit = Integer.parseInt(depositJTextField.getText());
            int Withdraw = Integer.parseInt(withdrawJTextField.getText());

            for (int i = 0; i < noAccounts; i++) {
                if ((myAccounts[i].getAccountNumber() == Accountnum) && (Deposit > 0)) {
                    myAccounts[i].setBalance(myAccounts[i].getBalance() + Deposit);
                    displayJTextArea.setText(myAccounts[i].getAccountName() + " " + myAccounts[i].getAccountNumber() + " " + myAccounts[i].getBalance());
                }

                if ((myAccounts[i].getAccountNumber() == Accountnum) && (Withdraw > 0)) {
                    myAccounts[i].setBalance(myAccounts[i].getBalance() - Withdraw);
                    displayJTextArea.setText(myAccounts[i].getAccountName() + " " + myAccounts[i].getAccountNumber() + " " + myAccounts[i].getBalance());
                }
            }
        }

        // clear other JTextFields for new data
        nameJTextField.setText(" ");
        accountNumberJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");

    }

    private void displayJButtonActionPerformed(ActionEvent event) {

        name = nameJTextField.getText();
        displayJTextArea.setText("");

        if (noAccounts == 0) {
            displayJTextArea.setText("No Accounts currently created");
        } else {
            for (int i = 0; i < noAccounts; i++) {

                displayJTextArea.append(myAccounts[i].getAccountName() + " " + myAccounts[i].getAccountNumber() + " " + myAccounts[i].getBalance() + "\n");

            }
        }
        // clear other JTextFields for new data
        nameJTextField.setText(" ");
        accountNumberJTextField.setText("0");
        balanceJTextField.setText("0");
        depositJTextField.setText("0");
        withdrawJTextField.setText("0");
    }

    public static void main(String[] args) {
        // Populate arrays with the word EMPTY
        // so we can check to see if the values are empty later

        JavaBank application = new JavaBank();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
