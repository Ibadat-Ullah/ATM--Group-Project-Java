import java.util.Scanner;

public class App {

    static int balance = 0;
    static App bankOperations = new App();

    void Deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawed Successfully!");
        } else if (amount > balance) {
            System.out.println("Insufficient Fund or Amount in account to withdraw");
        } else {
            System.out.println("Invalid withdrawal amountd");
        }
    }

    void check_balance() {
        System.out.println("Your Current Balance in your Account is: " + balance + "/-");
    }

    void exit() {
        System.out.println(
                "\n\n\t\t=====  Thanks for using our ATM banking service, We will look forward to you  =====\n\n");
    }

    public static void main(String[] args) throws Exception {

        Scanner inputs = new Scanner(System.in);
        String preDefinedPIN;
        boolean PINLength = false;

        do {
            System.out.println("Enter the PIN you want to set: ");
            preDefinedPIN = inputs.nextLine();

            if (preDefinedPIN.length() == 5 && preDefinedPIN.matches("\\d{5}")) {
                PINLength = true; 

                
                System.out.println("You setted up your PIN");
            } else {
                System.out.println("Invalid Input! Please enter your PIN exactly 5 digits");
            }
        } while (!PINLength);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Your PIN");
            String PIN = inputs.nextLine();

            if (i == 2 && !PIN.equals(preDefinedPIN)) {
                System.out.println(
                        "You have entered your pin incorrect several times due to which your account have been locked");
                break;
            }

            if (PIN.equals(preDefinedPIN)) {
                System.out.println("You have entered correct pin");

                int count = 0;
                while (count < 1) {
                    System.out.println("a) Deposit\r\n" +
                            "b) Withdraw\r\n" +
                            "c) Check Balance\r\n" +
                            "d) Exit");

                    System.out.print("Choice: ");
                    String choice = inputs.nextLine().toLowerCase();
                    switch (choice) {

                        case "a":
                            System.out.println("Enter amount to deposit");
                            int depositAmount = inputs.nextInt();
                            inputs.nextLine();
                            bankOperations.Deposit(depositAmount);
                            break;

                        case "b":
                            System.out.println("Enter amount to withdraw from the account");
                            int withdrawAmount = inputs.nextInt();
                            inputs.nextLine();
                            bankOperations.withdraw(withdrawAmount);
                            ;
                            break;

                        case "c":
                            bankOperations.check_balance();
                            break;

                        case "d":
                            bankOperations.exit();
                            count++;
                            return;

                        default:
                            System.out.println("Invalid Choice please try again!");
                            break;

                    }

                }

                // break;

            } else if (!PIN.equals(preDefinedPIN)) {
                System.out.println("You have entered incorrect pin, Please Try Again!");
                continue;
            }

        }
        inputs.close();
    }

}
