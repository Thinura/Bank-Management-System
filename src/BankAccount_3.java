import java.text.SimpleDateFormat;
import java.util.*;

public class BankAccount_3 {
    public String userName;
    public char[] password;

    private static Scanner scanner = new Scanner(System.in);
    private static List<BankAccount_3> account12s = new ArrayList<>();

    private BankAccount_3(String userName, char[] password) {
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public static void main(String[] args) {
        printGreeting();
    }

    public static BankAccount_3 searchBankAccount(String userName, char[] password) {
        for (BankAccount_3 account : account12s) {
            if ((account.userName.equals(userName) && (Arrays.equals(account.password, password)))) {
                return account;
            }
        }
        return null;
    }

//    public static BankAccount_3 searchBankAccount(char[] password) {
//        for (BankAccount_3 account : account12s) {
//            if (Arrays.equals(account.password, password)) {
//                return account;
//            }
//        }
//        return null;
//    }

    private static void printGreeting() {
        System.out.println("+----------------------------------------------+");
        System.out.println("|                                              |");
        System.out.println("|        WELCOME TO INTERBANK PYT LTD          |");
        System.out.println("|                                              |");
        System.out.println("+----------------------------------------------+");
        printMenu();
    }

    private static void printMenu() {
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
            BankAccount_3 obj = new BankAccount_3(name, password);
            account12s.add(obj);
            System.out.print("CUSTOMER ACCOUNT HAS BEEN CRATED.\nDO YOU WANT TO ADD MORE TYPE[YES] OR " +
                    "TYPE[NO] TO GO TO THE MENU.");
            check = scanner.next();
        }
        printLoginMenu();
    }

    private static void printLoginMenu() {
        System.out.println("\nPLEASE ENTER YOUR SELECTION: \n");
        System.out.println("[1] : LOGIN");
        System.out.println("[0] : EXIT");
        System.out.print("\nENTER THE SELECTION: ");
        int selection = checkSelectionMenu();
        getSelectionLoginMenu(selection);
    }

    private static void getSelectionLoginMenu(int selection) {
        switch (selection) {
            case 1: {
                loginCustomerAcc();
                break;
            }
            case 0: {
                System.out.println("\n--------------------------------------");
                System.out.println("THANK YOU FOR USING OUR APPLICATION.");
                System.exit(1);
                break;
            }
            default: {
                System.out.println("YOUR SELECTION IS INVALID. TRY AGAIN");
                printLoginMenu();
            }
        }

    }

    private static void loginCustomerAcc() {
        System.out.print("\nENTER YOUR USER NAME: ");
        String user = scanner.next();
        System.out.print("ENTER YOUR PASSWORD: ");
        char[] pass = scanner.next().toCharArray();

        BankAccount_3 bankAccount_1_2 = BankAccount_3.searchBankAccount(user, pass);
//        BankAccount_3 account_1_2 = BankAccount_3.searchBankAccount(pass);

        if ((bankAccount_1_2 != null)) {
            if ((bankAccount_1_2.getUserName().equalsIgnoreCase(user)) &&
                    (Arrays.equals(bankAccount_1_2.getPassword(), pass))) {

//                CustomerAccount.currentAccount.addAll(account12s);
                System.out.println("\nHI! " + bankAccount_1_2.getUserName() + " WELCOME TO INTERBANK PYT LTD ");
                printCustomerMenu();
            }
        } else {
            System.out.println("INVALID USERNAME/PASSWORD,TRY AGAIN");
            printLoginMenu();
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
        System.out.println("[8] : TO LOGOUT");
        System.out.println("[0] : EXIT");
        System.out.print("\nENTER THE SELECTION: ");
        int selection = checkSelectionMenu();
        getSelectionCustomerMenu(selection);
    }

    private static void getSelectionCustomerMenu(int selection) {
        switch (selection) {
            case 1: {
                CustomerAccount.createBankAcc();
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
                CustomerAccount.forecastTable();
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
                System.out.println("\n--------------------------------------");
                System.out.println("THANK YOU FOR USING OUR APPLICATION.");
                printLoginMenu();
                break;
            }
            case 0: {
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

class CustomerAccount {
    public int accNum;
    public double accBal;
    public double accRate;
    public double withdrawCase;
    public double depositCase;


    private static CustomerAccount customerAccount;
    private static List<CustomerAccount> customerAccountList = new ArrayList<>();
    private static GregorianCalendar gregorianCalendar = new GregorianCalendar();

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

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public void setAccBal(double accBal) {
        this.accBal = accBal;
    }

    public void setAccRate(double accRate) {
        this.accRate = accRate;
    }

    public static CustomerAccount searchCustomerAccount(int accNum) {
        for (CustomerAccount account : customerAccountList) {
            if (account.accNum == accNum) {
                return account;
            }
        }
        return null;
    }

    public static void createBankAcc() {
        try {
            String check = "";
            while (!check.equalsIgnoreCase("NO")) {
                System.out.print("ENTER THE BANK ACCOUNT NUMBER: ");
                int accNumber = scanner.nextInt();
                if (!((accNumber > 1000) && (accNumber < 9999))) {
                    System.err.println("PLEASE ENTER THE ACCOUNT NUMBER BETWEEN 1000 AND 9999.TRY AGAIN");
                    createBankAcc();
                }
                System.out.print("\nENTER THE INTEREST RATE: ");
                double accRate = scanner.nextDouble();
                if (!((accRate < 0.01) || (accRate > 15.00))) {
                    System.out.print("\nENTER YOUR CURRENT BALANCE: $");
                    double accBalance = scanner.nextDouble();
                    if (!((accBalance < 0) && (accBalance > 100000))) {
                        System.out.print("\nENTER THE AMOUNT FOR AN AUTOMATIC WITHDRAWAL ACCOUNT PER MONTH: $");
                        double acctWithdrawalsCase = scanner.nextInt();
                        System.out.print("\nENTER THE AMOUNT FOR AN AUTOMATIC DEPOSIT ACCOUNT PER MONTH: $");
                        double accDepositCase = scanner.nextInt();
                        if (!(accBalance <= acctWithdrawalsCase)) {
                            if (!(accDepositCase >= 100000)) {
                                CustomerAccount customerAccount = new CustomerAccount(accNumber, accBalance, accRate);
                                customerAccountList.add(customerAccount);
                                System.out.print("\nYOUR BANK ACCOUNT HAS BEEN CREATED,\nDO YOU WANT TO ADD MORE" +
                                        " TYPE[YES] OR TYPE[NO] TO GO TO THE MENU ");
                                check = scanner.next();
                            } else {
                                System.out.println("\nAMOUNT OF THE AUTOMATIC DEPOSIT CAN'T BE MORE THAN $100,000" +
                                        "\nCAN'T EXCEED THE FEDERAL INSURANCE.\nTRY AGAIN\n");
                                BankAccount_3.printCustomerMenu();
                            }
                        } else {
                            System.out.println("\nTHE AMOUNT TO BE CREDITED TO THE ACCOUNT SHOULD NOT EXCEED THE " +
                                    "BALANCE OF THE ACCOUNT.TRY AGAIN\n");
                            createBankAcc();
                        }
                    } else {
                        System.err.println("\nACCOUNT BALANCE CAN'T BE NEGATIVE OR OVER $100,000");
                        createBankAcc();
                    }
                } else {
                    System.out.println("\nENTER A VALID INTEREST RATE,\nINTEREST RATE SHOULD BE BETWEEN 0.01% - 15.O0%" +
                            "\nTRY AGAIN\n");
                    createBankAcc();
                }
            }
            BankAccount_3.printCustomerMenu();
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER.TRY AGAIN");

        }
    }

    public static void checkBankBal() {
        try {
            System.out.print("\nENTER YOUR BANK ACCOUNT NUMBER: ");
            int bankNum = scanner.nextInt();
            CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
            if (customerAccount != null) {
                if (customerAccount.getAccNum() == bankNum) {
                    System.out.println("\nYOUR CURRENT ACCOUNT BALANCE IS $" + customerAccount.getAccBal());
                    BankAccount_3.printCustomerMenu();
                } else {
                    System.out.println("\nINVALID ACCOUNT NUMBER,TRY AGAIN");
                    BankAccount_3.printCustomerMenu();
                }
            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.");
            BankAccount_3.printCustomerMenu();
        }
    }

    public static void transaction() throws NullPointerException {
        try {
            System.out.print("\nENTER YOUR BANK ACCOUNT NUMBER: ");
            int bank1Num = scanner.nextInt();
            CustomerAccount customerAccount1 = CustomerAccount.searchCustomerAccount(bank1Num);
            if (customerAccount1 != null) {
                if (!(customerAccount1.getAccBal() <= 0.0)) {
                    System.out.print("\nENTER RECEIVERS' BANK ACCOUNT NUMBER: ");
                    int bank2Num = scanner.nextInt();
                    CustomerAccount customerAccount2 = CustomerAccount.searchCustomerAccount(bank2Num);
                    if (customerAccount2 != null) {
                        if (customerAccount1.getAccNum() != customerAccount2.getAccNum()) {
                            System.out.print("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
                            double transferAmount = scanner.nextDouble();
                            if (!(transferAmount <= 0)) {
                                System.out.println(customerAccount1.getAccBal());
                                if (!(customerAccount1.getAccBal() < 0)) {
//                                    customerAccount1.setAccBal(customerAccount1.getAccBal() - transferAmount);
                                    customerAccount1.withdraw(transferAmount);
                                    customerAccount2.deposit(transferAmount);
//                                    customerAccount1.setAccBal(withdraw(transferAmount));
//                                    customerAccount2.setAccBal(deposit(transferAmount));
//                                    customerAccount2.setAccBal(customerAccount2.getAccBal() + transferAmount);
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
                                    BankAccount_3.printCustomerMenu();
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
                        BankAccount_3.printCustomerMenu();
                    }
                } else {
                    System.out.println("YOU DON'T HAVE ENOUGH MONEY TO TRANSFER.");
                    BankAccount_3.printCustomerMenu();
                }
            } else {
                System.out.println("INVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.");
            BankAccount_3.printCustomerMenu();
        }
    }

    public static void forecastTableInt() throws InputMismatchException {
        try {
            System.out.print("\nENTER YOUR ACCOUNT NUMBER: ");
            int bankNum = scanner.nextInt();
            CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
            if (customerAccount != null) {
                System.out.println(customerAccount.getAccRate());
                System.out.println((customerAccount.getAccBal() * (((customerAccount.getAccRate()) / 100) / 12)));
                double firstMonthEndingBalance = Math.round(customerAccount.getAccBal() + (customerAccount.getAccBal() * ((customerAccount.getAccRate() / 100) / 12)));
                double secondMothEndingBalance = Math.round(firstMonthEndingBalance + firstMonthEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double thirdMothEndingBalance = Math.round(secondMothEndingBalance + secondMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double fourthMothEndingBalance = Math.round(thirdMothEndingBalance + thirdMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double fifthMothEndingBalance = Math.round(fourthMothEndingBalance + fourthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double sixthMothEndingBalance = Math.round(fifthMothEndingBalance + fifthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double seventhMothEndingBalance = Math.round(sixthMothEndingBalance + sixthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double eighthMothEndingBalance = Math.round(seventhMothEndingBalance + seventhMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double ninthMothEndingBalance = Math.round(eighthMothEndingBalance + eighthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double tenthMothEndingBalance = Math.round(ninthMothEndingBalance + ninthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double eleventhMothEndingBalance = Math.round(tenthMothEndingBalance + tenthMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));
                double twelfthMothEndingBalance = Math.round(eleventhMothEndingBalance + eleventhMothEndingBalance * ((customerAccount.getAccRate() / 100) / 12));


                System.out.println("current year: " + gregorianCalendar.get(Calendar.YEAR));
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("|                                                              |");
                System.out.println("|                     INTERBANK PYT LTD                        |");
                System.out.println("|                                                              |");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("| YEAR | MONTH | MONTH-STARTING BALANCE | MONTH-ENDING BALANCE |");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + customerAccount.getAccBal() + "          |        " + firstMonthEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + firstMonthEndingBalance + "          |        " + secondMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + secondMothEndingBalance + "          |        " + thirdMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + thirdMothEndingBalance + "          |        " + fourthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + fourthMothEndingBalance + "          |        " + fifthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + fifthMothEndingBalance + "          |        " + sixthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + sixthMothEndingBalance + "          |        " + seventhMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + seventhMothEndingBalance + "          |        " + eighthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + eighthMothEndingBalance + "          |        " + ninthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "  |        " + ninthMothEndingBalance + "          |        " + tenthMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "  |        " + tenthMothEndingBalance + "          |        " + eleventhMothEndingBalance + "        |");
                gregorianCalendar.add(Calendar.MONTH, 1);
                System.out.println("| " + gregorianCalendar.get(Calendar.YEAR) + " |   " + gregorianCalendar.get(Calendar.MONTH) + "   |        " + eleventhMothEndingBalance + "          |        " + twelfthMothEndingBalance + "        |");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("THIS FORECASTING TABLE IS FOR INTEREST RATES ONLY");
                BankAccount_3.printCustomerMenu();

            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.");

        }
    }

    private void withdraw(double amount) throws NullPointerException {
        accBal = accBal - amount;
    }

    private void deposit(double amount) throws NullPointerException {
        accBal = accBal - amount;
    }

    public static void withdrawMoney() {
        try {
            System.out.print("\nENTER YOUR ACCOUNT NUMBER: ");
            int bankNum = scanner.nextInt();
            CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
            if (customerAccount != null) {
                System.out.print("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
                double money = scanner.nextDouble();
                if (!(money <= 0)) {
                    if (!(customerAccount.getAccBal() <= 0)) {
                        if (!(customerAccount.getAccBal() <= money)) {
                            customerAccount.withdraw(money);
                            System.out.println("\nYOU HAVE SUCCESSFULLY WITHDRAWN $" + money + " FROM YOUR ACCOUNT." +
                                    "\nYOUR CURRENT BALANCE IS $" + customerAccount.getAccBal() + ".\n");
                            BankAccount_3.printCustomerMenu();
                        } else {
                            System.out.println("\nYOU DON'T HAVE ENOUGH MONEY TO TRANSFER,\nYOUR BALANCE IS " +
                                    customerAccount.getAccBal());
                            BankAccount_3.printCustomerMenu();
                        }
                    } else {
                        System.out.println("\nYOU DON'T HAVE ENOUGH MONEY TO TRANSFER,\nYOUR BALANCE IS "
                                + customerAccount.getAccBal());
                        BankAccount_3.printCustomerMenu();
                    }
                } else {
                    System.out.println("\nAMOUNT CAN'T BE NEGATIVE,TRY AGAIN");
                    withdrawMoney();
                }
            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.");
            BankAccount_3.printCustomerMenu();
        }
    }

    public static void depositMoney() {
        try {
            System.out.print("\nENTER YOUR ACCOUNT NUMBER: ");
            int bankNum = scanner.nextInt();
            CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
            if (customerAccount != null) {
                System.out.print("\nENTER THE AMOUNT THAT NEED TO TRANSFER: $");
                double money = scanner.nextDouble();
                if (!(money <= 0)) {
                    if (!(money >= 100000)) {
                        if (!((customerAccount.getAccBal() + money) >= 100000)) {
                            customerAccount.deposit(money);
                            System.out.println("\nYOU HAVE SUCCESSFULLY DEPOSIT $" + money + " FROM YOUR ACCOUNT." +
                                    "\nYOUR CURRENT BALANCE IS $" + customerAccount.getAccBal() + ".\n");
                        } else {
                            System.out.println("\nYOU ARE EXCEEDING THE FEDERAL INSURANCE,TRY AGAIN");
                            BankAccount_3.printCustomerMenu();
                        }
                    } else {
                        System.out.println("\nAMOUNT CAN'T BE MORE THAN FEDERAL INSURANCE,TRY AGAIN");
                        BankAccount_3.printCustomerMenu();
                    }
                } else {
                    System.out.println("\nAMOUNT CAN'T BE NEGATIVE,TRY AGAIN");
                    depositMoney();
                }
            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.");
            BankAccount_3.printCustomerMenu();
        }
    }

    public static void forecastTable() {
        try {
            System.out.print("\nENTER YOUR ACCOUNT NUMBER: ");
            int bankNum = scanner.nextInt();
            CustomerAccount customerAccount = CustomerAccount.searchCustomerAccount(bankNum);
            if (customerAccount != null) {
                System.out.print("\nENTER THE AMOUNT YOU WISH TO SPEND ON A MONTH: $");
                double tempWithdrawal = scanner.nextDouble();
                System.out.print("\nENTER YOUR DESIRED RETURN AMOUNT FOR A MONTH: $");
                double tempDeposit = scanner.nextDouble();
                if (!((tempWithdrawal <= 0) && (tempDeposit <= 0))) {
                    if (!(tempDeposit <= tempWithdrawal)) {
                        if (!(tempDeposit >= 100000)) {
                            System.out.print("\nENTER THE YEAR/S THAT YOU EXPECTED FROM THE FORECAST TABLE: ");
                            int year = scanner.nextInt();
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
                                for (int j = 1; j < (year + 10); j++) {
                                    System.out.print("| " + year1);
                                    System.out.print("     " + j + "  ");
                                    double monthEndingBal = Math.round(monthStartingBal + (tempDeposit - tempWithdrawal) + (monthStartingBal * ((customerAccount.getAccRate() / 100) / 12)));
                                    System.out.print("\t\t\t " + monthStartingBal + "\t    ");
                                    System.out.print("\t\t\t  " + monthEndingBal + "\t  ");
                                    System.out.println("");
                                    monthStartingBal = monthEndingBal;
                                }
                                year1 = 0;
                            }
                            System.out.println("+--------------------------------------------------------------+");
                            BankAccount_3.printCustomerMenu();
                        } else {
                            System.out.println("\nAMOUNT OF THE AUTOMATIC DEPOSIT CAN'T BE MORE THAN $100,000." +
                                    "\nCAN'T EXCEED THE FEDERAL INSURANCE.\nTRY AGAIN\n");
                            BankAccount_3.printCustomerMenu();
                        }
                    } else {
                        System.out.println("YOUR MONTHLY DEPOSIT MUST BE OVER MONTHLY WITHDRAWAL,TRY AGAIN");
                        forecastTable();
                    }
                } else {
                    System.out.println("AMOUNT CAN'T BE NEGATIVE.TRY AGAIN");
                    forecastTable();
                }
            } else {
                System.out.println("\nINVALID ACCOUNT NUMBER/ HAVEN'T CRATE AN BANK ACCOUNT,TRY AGAIN");
                BankAccount_3.printCustomerMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nUSE ONLY NUMBERS TO ENTER,TRY AGAIN.\n");
        }
    }
}


/*
import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        File f = new File("D:/projects/eric/eclipseworkspace/testing2/usernames.txt");
        try{
            ArrayList<String> lines = get_arraylist_from_file(f);
            for(int x = 0; x < lines.size(); x++){
                System.out.println(lines.get(x));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("done");

    }
    public static ArrayList<String> get_arraylist_from_file(File f)
            throws FileNotFoundException {
        Scanner s;
        ArrayList<String> list = new ArrayList<String>();
        s = new Scanner(f);
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }
}*/
