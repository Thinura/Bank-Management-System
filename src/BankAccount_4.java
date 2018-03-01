import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankAccount_4 implements Serializable {
    public String userName;
    public char[] password;

    private static Scanner scanner = new Scanner(System.in);
    private static List<BankAccount_4> account12s = new ArrayList<>();

    private BankAccount_4(String userName, char[] password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return password;
    }

    public static void main(String[] args) {
        dataPersistence(0);
        printGreeting();
    }

    public static BankAccount_4 searchBankAccount(String userName, char[] password) {
        for (BankAccount_4 account : account12s) {
            if ((account.userName.equals(userName) && (Arrays.equals(account.password, password)))) {
                return account;
            }
        }
        return null;
    }

    private static void printGreeting() {
        System.out.println("+----------------------------------------------+");
        System.out.println("|                                              |");
        System.out.println("|        WELCOME TO INTERBANK PYT LTD          |");
        System.out.println("|                                              |");
        System.out.println("+----------------------------------------------+");
        printMenu();
    }

    public static void printMenu() {
        System.out.println("\nPLEASE ENTER YOUR SELECTION: \n");
        System.out.println("[1] : CREATE A CUSTOMER ACCOUNT   ");
        System.out.println("[2] : LOGIN");
        System.out.println("[0] : EXIT ");
        System.out.print("\nENTER THE SELECTION: ");
        int selection = checkSelectionMenu();
        getSelection(selection);
    }

    private static void getSelection(int selection) {
        switch (selection) {
            case 1: {
                createCustomer();
                break;
            }
            case 2: {
                loginCustomerAcc();
            }
            case 0: {
                dataPersistence(1);
                System.out.println("--------------------------------------");
                System.out.println("THANK YOU FOR USING OUR APPLICATION.");
                System.exit(1);
                break;
            }
            default: {
                System.out.println("YOUR SELECTION IS INVALID. TRY AGAIN");
                printMenu();
            }
        }
    }

    private static int checkSelectionMenu() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("INVALID SELECTIONS, TRY AGAIN");
            System.out.print("\nENTER THE SELECTION: ");
        }
        return scanner.nextInt();
    }

    private static void createCustomer() {
        String check = "";
        while (!check.equalsIgnoreCase("NO")) {
            System.out.print("Enter the Name: ");
            String name = scanner.next();
            System.out.print("Enter the password: ");
            char[] password = scanner.next().toCharArray();
            BankAccount_4 bankAccount3 = BankAccount_4.searchBankAccount(name, password);
            if (bankAccount3 == null) {
                BankAccount_4 obj = new BankAccount_4(name, password);
                account12s.add(obj);
                System.out.print("CUSTOMER ACCOUNT HAS BEEN CRATED.\nDO YOU WANT TO ADD MORE TYPE[YES] OR " +
                        "TYPE[NO] TO GO TO THE MENU.");
                check = scanner.next();
            } else {
                System.out.println("\nYOU HAVE ALREADY CREATED A CUSTOMER ACCOUNT.");
                printMenu();
            }
        }
        printMenu();
    }

    private static void loginCustomerAcc() {
        System.out.print("\nENTER YOUR USER NAME: ");
        String user = scanner.next();
        System.out.print("ENTER YOUR PASSWORD: ");
        char[] pass = scanner.next().toCharArray();

        BankAccount_4 bankAccount_1_2 = BankAccount_4.searchBankAccount(user, pass);
        if ((bankAccount_1_2 != null)) {
            if ((bankAccount_1_2.getUserName().equalsIgnoreCase(user)) &&
                    (Arrays.equals(bankAccount_1_2.getPassword(), pass))) {
                System.out.println("\nHI! " + bankAccount_1_2.getUserName() + " WELCOME TO INTERBANK PYT LTD ");
                printCustomerMenu();
            }
        } else {
            System.out.println("INVALID USERNAME/PASSWORD,TRY AGAIN");
            printMenu();
        }
    }

    static void printCustomerMenu() {
        System.out.println("\nPLEASE ENTER YOUR SELECTION: \n");
        System.out.println("[1] : CREATE AN BANK ACCOUNT");
        System.out.println("[2] : CHECK THE BALANCE");
        System.out.println("[3] : TO MAKE A TRANSACTION");
        System.out.println("[4] : TO CHECK THE BALANCE FORECAST TABLE.(ONLY WITH INTEREST RATE)");
        System.out.println("[5] : TO CHECK THE BALANCE FORECAST TABLE.");
        System.out.println("[6] : TO WITHDRAW");
        System.out.println("[7] : TO DEPOSIT");
        System.out.println("[8] : DISPLAY THE ACCOUNT");
        System.out.println("[9] : TO LOGOUT");
        System.out.println("[0] : EXIT");
        System.out.print("\nENTER THE SELECTION: ");
        int selection = checkSelectionMenu();
        getSelectionCustomerMenu(selection);
    }

    public static int dataPersistence(int value) {
        if (value == 1) {
            //write to file
            try {
                ObjectOutputStream customerDetails = new ObjectOutputStream(new FileOutputStream("CustomerDetails.txt"));
                for (BankAccount_4 account12 : account12s) {
                    customerDetails.writeObject(account12);
                }
                customerDetails.close();
                ObjectOutputStream bankAccountDetails = new ObjectOutputStream(new FileOutputStream("BankAccountDetails.txt"));
                for (int i = 0; i < CustomerAccount.customerAccountList.size(); i++) {
                    bankAccountDetails.writeObject(CustomerAccount.customerAccountList.get(i));
                }
                bankAccountDetails.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (value == 0) {
            //read from file
            try {
                ObjectInputStream streamCustomer = new ObjectInputStream(new FileInputStream("CustomerDetails.txt"));
                BankAccount_4 account3 = (BankAccount_4) streamCustomer.readObject();
                BankAccount_4.account12s.add(account3);
                streamCustomer.close();
                ObjectInputStream streamBank = new ObjectInputStream(new FileInputStream("BankAccountDetails.txt"));
                CustomerAccount account3Bank = (CustomerAccount) streamBank.readObject();
                CustomerAccount.customerAccountList.add(account3Bank);
                streamBank.close();
            } catch (FileNotFoundException ex) {
                System.out.println("");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    private static void getSelectionCustomerMenu(int selection) {
        switch (selection) {
            case 1: {
                CustomerAccount.enterAccountData();
                break;
            }
            case 2: {
                CustomerAccount.checkBankBal();
                break;
            }
            case 3: {
                System.out.println("PLEASE WAIT WHILST WE PERFORM A CREDIT CHECK.");
                CustomerAccount.transaction();
                break;
            }
            case 4: {
                CustomerAccount.forecastTableInt();
                break;
            }
            case 5: {
                CustomerAccount.computeInterest();
                break;
            }
            case 6: {
                CustomerAccount.withdrawMoney();
                break;
            }
            case 7: {
                CustomerAccount.depositMoney();
                break;
            }
            case 8: {
                CustomerAccount.displayAccount();
                break;
            }
            case 9: {
                System.out.println("\n--------------------------------------");
                System.out.println("THANK YOU FOR USING OUR APPLICATION.");
                printMenu();
                break;
            }
            case 0: {
                dataPersistence(1);
                System.out.println("\n--------------------------------------");
                System.out.println("THANK YOU FOR USING OUR APPLICATION.");
                System.exit(1);
                break;
            }
            default: {
                System.out.println("YOUR SELECTION IS INVALID. TRY AGAIN");
                printCustomerMenu();
            }
        }
    }
}

class CustomerAccount implements Serializable {
    public int accNum;
    public double accBal;
    public double accRate;

    public static List<CustomerAccount> customerAccountList = new ArrayList<>();

    private static String yyyy = "yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy);

    private static Scanner scanner = new Scanner(System.in);

    public CustomerAccount(int accNum, double accBal, double accRate) {
        this.accNum = accNum;
        this.accBal = accBal;
        this.accRate = accRate;
    }

    public int getAccNum() {
        return accNum;
    }

    public double getAccBal() {
        return accBal;
    }

    public double getAccRate() {
        return accRate;
    }

    private static CustomerAccount searchCustomerAccount(int accNum) {
        for (CustomerAccount account : customerAccountList) {
            if (account.accNum == accNum) {
                return account;
            }
        }
        return null;
    }



    public static void enterAccountData() throws InputMismatchException{

        String check = "";
        int accNumber;
        while (!(check.equalsIgnoreCase("NO"))) {
            accNumber = checkInput("ENTER THE BANK ACCOUNT NUMBER: ");
            if (accNumber == 0) {
                System.out.println("YOU HAVE DECIDED TO STOP CREATING BANK ACCOUNTS");
                BankAccount_4.printCustomerMenu();
            }
            CustomerAccount account = CustomerAccount.searchCustomerAccount(accNumber);
            if (account == null) {
                if (!((accNumber > 1000) && (accNumber < 9999))) {
                    System.err.println("PLEASE ENTER THE ACCOUNT NUMBER BETWEEN 1000 AND 9999.TRY AGAIN");
                    enterAccountData();
                }
                double accRate = checkInput("\nENTER THE INTEREST RATE: ");
                if (!((accRate < 0.01) || (accRate > 15.00))) {
                    double accBalance = checkInput("\nENTER YOUR CURRENT BALANCE: $");
                    if (!((accBalance < 0) && (accBalance > 100000))) {
                        CustomerAccount customerAccount = new CustomerAccount(accNumber, accBalance, accRate);
                        customerAccountList.add(customerAccount);
                        System.out.print("\nYOUR BANK ACCOUNT HAS BEEN CREATED,\nDO YOU WANT TO ADD MORE" +
                                " TYPE[YES] OR TYPE[NO] TO GO TO THE MENU/ACCOUNT NUMBER TO 0 TO GO TO THE MENU ");
                        check = scanner.next();
                    } else {
                        System.err.println("\nACCOUNT BALANCE CAN'T BE NEGATIVE OR OVER $100,000");
                        enterAccountData();
                    }
                } else {
                    System.out.println("\nENTER A VALID INTEREST RATE,\nINTEREST RATE SHOULD BE" +
                            " BETWEEN 0.01% - 15.O0%" +
                            "\nTRY AGAIN\n");
                    enterAccountData();
                }
            } else {
                System.out.println("BANK ACCOUNT IS ALREADY EXCEEDING,TRY AGAIN");
                BankAccount_4.printCustomerMenu();
            }
        }
        BankAccount_4.printCustomerMenu();

    }

    public static void checkBankBal() throws InputMismatchException{
        int bankNum = checkInput("\nENTER YOUR BANK ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
        if (customerAccount != null) {
            if (customerAccount.getAccNum() == bankNum) {
                System.out.println("\nYOUR CURRENT ACCOUNT BALANCE IS $" + customerAccount.getAccBal());
                BankAccount_4.printCustomerMenu();
            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER,TRY AGAIN");
                BankAccount_4.printCustomerMenu();
            }
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    public static void transaction() throws InputMismatchException{
        int bank1Num = checkInput("\nENTER YOUR BANK ACCOUNT NUMBER: ");
        CustomerAccount customerAccount1 = CustomerAccount.searchCustomerAccount(bank1Num);
        if (customerAccount1 != null) {
            if (!(customerAccount1.getAccBal() <= 0.0)) {
                int bank2Num = checkInput("\nENTER RECEIVERS' BANK ACCOUNT NUMBER: ");
                CustomerAccount customerAccount2 = CustomerAccount.searchCustomerAccount(bank2Num);
                if (customerAccount2 != null) {
                    if (customerAccount1.getAccNum() != customerAccount2.getAccNum()) {
                        double transferAmount = checkInput("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
                        if (!(transferAmount <= 0)) {
                            if (!(customerAccount1.getAccBal() < 0)) {
                                customerAccount1.withdraw(transferAmount);
                                customerAccount2.deposit(transferAmount);
                                System.out.println("YOUR TRANSACTION IS COMPLETED.\n");
                                System.out.println(customerAccount1.getAccNum() + " BALANCE: $" +
                                        customerAccount1.getAccBal());
                                System.out.println(customerAccount2.getAccNum() + " BALANCE: $" +
                                        customerAccount2.getAccBal());
                                if (customerAccount1.getAccBal() < 10) {
                                    System.out.println("\nYOUR BANK ACCOUNT BALANCE IS FALLING BELOW $10.");
                                }
                                if (customerAccount2.getAccBal() > 100000) {
                                    System.out.println("\n" + customerAccount2.getAccNum() + " HAVE EXCEEDED " +
                                            "FEDERAL INSURANCE.");
                                }
                                BankAccount_4.printCustomerMenu();
                            } else {
                                System.err.println("\nYOUR ACCOUNT BALANCE IS FALLING BELOW $0.");
                                transaction();
                            }
                        } else {
                            System.out.println("\nINVALID INPUT,TRY AGAIN");
                            transaction();
                        }
                    } else {
                        System.err.println("\nYOU HAVE ENTERED THE SAME ACCOUNT NUMBER.");
                        transaction();
                    }
                } else {
                    System.out.println("RECEIVERS' ACCOUNT NUMBER IS INVALID,TRY AGAIN");
                    BankAccount_4.printCustomerMenu();
                }
            } else {
                System.out.println("YOU DON'T HAVE ENOUGH MONEY TO TRANSFER.");
                BankAccount_4.printCustomerMenu();
            }
        } else {
            System.out.println("INVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    public static void forecastTableInt() throws InputMismatchException {
        int bankNum = checkInput("\nENTER YOUR ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
        if (customerAccount != null) {
            int year = checkInput("\nENTER THE YEAR/S THAT YOU EXPECTED FROM THE FORECAST TABLE: ");
            if (!(year <= 0)) {
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("|                                                              |");
                System.out.println("|                     INTERBANK PYT LTD                        |");
                System.out.println("|                                                              |");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("| YEAR | MONTH | MONTH-STARTING BALANCE | MONTH-ENDING BALANCE |");
                double monthStartingBal = customerAccount.getAccBal();
                int year1;
                int year2 = 0;
                year1 = Integer.parseInt(dateFormat.format(new Date()));
                for (int i = 0; i < (year); i++) {
                    year1 = year2 + year1;
                    System.out.println("+--------------------------------------------------------------+");
                    year2 = year1 + 1;
                    for (int j = 1; j < 13; j++) {
                        System.out.print("| " + year1);
                        System.out.print("     " + j + "  ");
                        double monthEndingBal = Math.round(monthStartingBal +
                                (monthStartingBal * ((customerAccount.getAccRate() / 100) / 12)));
                        System.out.print("\t\t\t " + monthStartingBal + "\t    ");
                        System.out.print("\t\t\t  " + monthEndingBal + "\t  ");
                        System.out.println("");
                        monthStartingBal = monthEndingBal;
                    }
                    year1 = 0;
                }
                System.out.println("+--------------------------------------------------------------+");
                BankAccount_4.printCustomerMenu();
            } else {
                System.out.println("\nINVALID INPUT,TRY AGAIN");
                computeInterest();
            }
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    private void withdraw(double amount) throws NullPointerException {
        accBal = accBal - amount;
    }

    private void deposit(double amount) throws NullPointerException {
        accBal = accBal - amount;
    }

    public static void withdrawMoney() throws InputMismatchException{
        int bankNum = checkInput("\nENTER YOUR ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
        if (customerAccount != null) {
            double money = checkInput("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
            if (!(money <= 0)) {
                if (!(customerAccount.getAccBal() <= 0)) {
                    if (!(customerAccount.getAccBal() <= money)) {
                        customerAccount.withdraw(money);
                        System.out.println("\nYOU HAVE SUCCESSFULLY WITHDRAWN $" + money + " FROM YOUR ACCOUNT." +
                                "\nYOUR CURRENT BALANCE IS $" + customerAccount.getAccBal() + ".\n");
                        BankAccount_4.printCustomerMenu();
                    } else {
                        System.out.println("\nYOU DON'T HAVE ENOUGH MONEY TO TRANSFER,\nYOUR BALANCE IS " +
                                customerAccount.getAccBal());
                        BankAccount_4.printCustomerMenu();
                    }
                } else {
                    System.out.println("\nYOU DON'T HAVE ENOUGH MONEY TO TRANSFER,\nYOUR BALANCE IS "
                            + customerAccount.getAccBal());
                    BankAccount_4.printCustomerMenu();
                }
            } else {
                System.out.println("\nAMOUNT CAN'T BE NEGATIVE,TRY AGAIN");
                withdrawMoney();
            }
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    public static void depositMoney() throws InputMismatchException{
        int bankNum = checkInput("\nENTER YOUR ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
        if (customerAccount != null) {
            double money = checkInput("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
            if (!(money <= 0)) {
                if (!(money >= 100000)) {
                    if (!((customerAccount.getAccBal() + money) >= 100000)) {
                        customerAccount.deposit(money);
                        System.out.println("\nYOU HAVE SUCCESSFULLY DEPOSIT $" + money + " FROM YOUR ACCOUNT." +
                                "\nYOUR CURRENT BALANCE IS $" + customerAccount.getAccBal() + ".\n");
                        BankAccount_4.printCustomerMenu();
                    } else {
                        System.out.println("\nYOU ARE EXCEEDING THE FEDERAL INSURANCE,TRY AGAIN");
                        BankAccount_4.printCustomerMenu();
                    }
                } else {
                    System.out.println("\nAMOUNT CAN'T BE MORE THAN FEDERAL INSURANCE,TRY AGAIN");
                    BankAccount_4.printCustomerMenu();
                }
            } else {
                System.out.println("\nAMOUNT CAN'T BE NEGATIVE,TRY AGAIN");
                depositMoney();
            }
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    public static void computeInterest()throws InputMismatchException {
        int bankNum = checkInput("\nENTER YOUR ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
        if (customerAccount != null) {
            double tempWithdrawal = checkInput("\nENTER THE AMOUNT YOU WISH TO SPEND ON A MONTH: $");
            double tempDeposit = checkInput("\nENTER YOUR DESIRED RETURN AMOUNT FOR A MONTH: $");
            if (!((tempWithdrawal <= 0) && (tempDeposit <= 0))) {
                if (!(tempDeposit <= tempWithdrawal)) {
                    if (!(tempDeposit >= 100000)) {
                        int year = checkInput("\nENTER THE YEAR/S THAT YOU EXPECTED FROM THE FORECAST TABLE: ");
                        if (!(year <= 0)) {
                            System.out.println("+--------------------------------------------------------------+");
                            System.out.println("|                                                              |");
                            System.out.println("|                     INTERBANK PYT LTD                        |");
                            System.out.println("|                                                              |");
                            System.out.println("+--------------------------------------------------------------+");
                            System.out.println("| YEAR | MONTH | MONTH-STARTING BALANCE | MONTH-ENDING BALANCE |");
                            double monthStartingBal = customerAccount.getAccBal();
                            int year1;
                            int year2 = 0;
                            year1 = Integer.parseInt(dateFormat.format(new Date()));
                            for (int i = 0; i < (year); i++) {
                                year1 = year2 + year1;
                                System.out.println("+-------------------------------------------------------" +
                                        "-------+");
                                year2 = year1 + 1;
                                for (int j = 1; j < 13; j++) {
                                    System.out.print("| " + year1);
                                    System.out.print("     " + j + "  ");
                                    double monthEndingBal = Math.round(monthStartingBal + (tempDeposit -
                                            tempWithdrawal) +
                                            (monthStartingBal * ((customerAccount.getAccRate() / 100) / 12)));
                                    System.out.print("\t\t\t " + monthStartingBal + "\t    ");
                                    System.out.print("\t\t\t  " + monthEndingBal + "\t  ");
                                    System.out.println("");
                                    monthStartingBal = monthEndingBal;
                                }
                                year1 = 0;
                            }
                            System.out.println("+--------------------------------------------------------------+");
                            BankAccount_4.printCustomerMenu();
                        } else {
                            System.out.println("\nINVALID INPUT,TRY AGAIN");
                            computeInterest();
                        }
                    } else {
                        System.out.println("\nAMOUNT OF THE AUTOMATIC DEPOSIT CAN'T BE MORE THAN $100,000." +
                                "\nCAN'T EXCEED THE FEDERAL INSURANCE.\nTRY AGAIN\n");
                        BankAccount_4.printCustomerMenu();
                    }
                } else {
                    System.out.println("YOUR MONTHLY DEPOSIT MUST BE OVER MONTHLY WITHDRAWAL,TRY AGAIN");
                    computeInterest();
                }
            } else {
                System.out.println("AMOUNT CAN'T BE NEGATIVE.TRY AGAIN");
                computeInterest();
            }
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    public static void displayAccount() throws InputMismatchException{
        int bank = checkInput("ENTER YOUR ACCOUNT NUMBER: ");
        CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bank);
        if (customerAccount != null) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|                                                              |");
            System.out.println("|                     INTERBANK PYT LTD                        |");
            System.out.println("|                                                              |");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|Account Number: " + customerAccount.getAccNum() + "\t\t\t\t\t\t\t\t\t\t   |");
            System.out.println("|                                                              |");
            System.out.println("|Account Balance: " + customerAccount.getAccBal() + "\t\t\t\t\t\t\t\t\t   |");
            System.out.println("|                                                              |");
            System.out.println("|Interest rate: " + customerAccount.getAccRate() + "\t\t\t\t\t\t\t\t\t\t   |");
            System.out.println("+--------------------------------------------------------------+");
            BankAccount_4.printCustomerMenu();
        } else {
            System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
            BankAccount_4.printCustomerMenu();
        }
    }

    private static int checkInput(String mess) throws InputMismatchException {
        System.out.print(mess);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN");
            System.out.println(mess);
        }
        return scanner.nextInt();
    }
}