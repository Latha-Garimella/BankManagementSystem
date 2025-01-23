# Bank Management System

## Overview
The Bank Management System is a simple console-based Java application designed to simulate various banking operations. The system allows users to perform actions such as checking balance, depositing funds, withdrawing funds, changing their PIN, and viewing a mini-statement. The interface is created using Java Swing for graphical user interaction, and the backend is powered by SQL-based database interactions.

## Technologies Used
**•	Programming Language:** Java
**•	GUI:** Java Swing
**•	Database:** MySQL 
**•	Other Tools:** JDBC for database connectivity

## File Structure
This project consists of multiple Java classes, each fulfilling specific functionalities. Below is a description of each file:
**1. Login.java**
•	Handles the user login process, verifies the PIN, and allows the user to proceed to the main interface if successful.
**2. Signup.java**
•	Manages user registration, where users enter their details and create a new account.
**3. Transactions.java**
•	Displays the transaction menu to the user after successful login, offering various operations like withdrawal, deposit, balance enquiry, etc.
**4. Deposit.java**
•	Allows the user to deposit a specified amount into their account and stores the transaction in the database.
**5. Withdrawl.java**
•	Facilitates withdrawal of a specified amount from the user’s account and updates the database.
**6. FastCash.java**
•	Provides a quick withdrawal option for preset amounts (e.g., Rs.100, Rs.500, Rs.1000, etc.).
**7. PinChange.java**
•	Enables the user to change their PIN after entering the old one and confirming the new one.
**8. BalanceEnquiry.java**
•	Allows users to check their current account balance by querying the database for transactions.
**9. MiniStatement.java**
•	Displays the mini-statement of the user’s recent transactions along with the current balance.
**10. Conn.java**
•	Handles the database connection and provides methods for executing SQL queries. This class is used across other files for database interactions.
**11. Bank.java**
•	The core class for managing and updating user transactions in the database. It likely handles operations like deposits, withdrawals, and balance queries.
**12. ATM.java** *(Entry point for the application)*
•	Contains the main method to initialize the program and navigate through different interfaces.


## Features
•	User Authentication: Secure login using a PIN.
•	Account Management: Users can register, view account details, and modify account PIN.
•	Deposit and Withdrawal: Add or remove money from the account.
•	Balance Inquiry: Users can check their account balance at any time.
•	Mini Statement: View a history of recent transactions.
•	Quick Withdrawals: Choose from preset withdrawal amounts for faster transactions.

## Setup and Installation
**1.	Prerequisites:**
o	Install Java (JDK 8 or higher).
o	Install MySQL (or any relational database).
o	Set up a database schema for the project (using SQL scripts for table creation and relationships).
**2.	Database Setup:**
o	Create the database and tables for storing user and transaction data.
o	Use the Conn.java class to connect to the database and run queries.
**3.	Running the Project:**
o	Clone or download the project files.
o	Open the project in your Java IDE (e.g., IntelliJ IDEA, Eclipse).
o	Build and run the ATM.java class to start the application.

## Usage
•	Upon launching the application, users will first encounter the login screen where they can input their PIN.
•	After a successful login, the user will be presented with the transaction menu where they can choose from different operations like withdrawing money, checking balance, depositing funds, etc.
•	To perform a transaction, the user can select the appropriate button (e.g., "Withdraw", "Deposit") and enter the amount they wish to perform the operation with.
•	The system automatically updates the database and provides feedback on the success or failure of the operation.

## Credits and Acknowledgments
**•	Java:** Used for programming the back-end logic and GUI.
**•	MySQL:** Used for managing user data and transactions.
**•	Java Swing:** For creating the graphical user interface.
*•	Special thanks to open-source communities and resources for Java and database management.*
