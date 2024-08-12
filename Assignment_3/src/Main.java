import java.util.Scanner;

class BankDetails {
    private String accno;
    private String name;
    private String acc_type;
    private long balance;
    private long contact;
    Scanner sc = new Scanner(System.in);

    public void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
        System.out.print("Enter your contact: ");
        contact = sc.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
        System.out.println("Contact: "+contact);
    }

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance += amt;
    }

    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create initial accounts
        System.out.print("How many customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails[] customers = new BankDetails[n];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new BankDetails();
            customers[i].openAccount();
        }

        int choice;
        do {
            System.out.println("\n*** Banking System Application ***");
            System.out.println("1. Display all account details");
            System.out.println("2. Search by Account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (BankDetails customer : customers) {
                        customer.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (BankDetails customer : customers) {
                        found = customer.search(ac_no);
                        if (found) break;
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account no. to deposit: ");
                    ac_no = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(ac_no)) {
                            customer.deposit();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account no. to withdraw: ");
                    ac_no = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(ac_no)) {
                            customer.withdrawal();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
