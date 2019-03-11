# BankApp
This app allows user to enter 2 different types of loans (business and personal), adjust primary interest rate and terms. Loan will be created if certain conditions are met (amount&lt; 250k, terms can be only 1,3 or 5 years). Data is stored in binary file.

1)	Display Accounts - when there are no accounts created, the app shows “No Accounts currently created”. Once the account(s) has been created, the app displays Name, Account Number and Balance.
2)	Create Accounts - (Name – optional in this app, but recommended), Account number and Balance fields must be filled to create a new account. If one of the fields is missing, the program will not create an account and compiler will show an error message “Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: ”
3)	Delete Accounts – current version of the app does not support this feature. If button is pressed, the following message will be displayed: “Oops this isn’t coded in this version!”
4)	 Make a Withdrawal Transaction – the amount of the transaction and account number must be typed in and button “Make transaction” pressed. If there are two or more accounts with the same number, the app will proceed with the transaction for all of the accounts with the same number. The amount from the “withdraw” field will be subtracted from the account balance.
5)	 Make a Deposit Transaction - the amount of the transaction and account number must be typed in and button “Make transaction” pressed. If there are two or more accounts with the same number, the app will proceed with the transaction for all of the accounts with the same number. The amount from “deposit” field will be added to the account balance.
6)	 Can you display accounts before any are created? - When there is no account has been created, the app shows “No Accounts currently created”.
7)	 Can you create an account without entering anything in the fields? – No, compiler will throw an error “Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string”.
8)	 Can you make a withdrawal transaction with no amount in the Withdrawal field? – Yes, you can, but nothing will be added.
9)	 Can you do a deposit transaction with no amount in the Deposit field? – Yes you can, but nothing will be subtracted. 
10)	 What other questions do you have about the JavaBank application? – What will happen if user deletes account that is not exist? What will happen if user displays account that is not exists?
11)	 What changes would you make to the current application to make it function better? – avoid creating two account with same number, avoid creating an account without user name.
12)	 What additions would you make to the current application to increase its functionality? – populate account when it’s clicked in text field. Add method to delete button, add user tips.
