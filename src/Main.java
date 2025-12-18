package src;

import java.util.Scanner;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        signupMenu(scanner);

    }

    // --------------------------------------------------------------------------------------------------------------------------------
    // Main Menu
    // --------------------------------------------------------------------------------------------------------------------------------
    public static void mainMenu(Scanner scanner) {
        System.out.println("Main Menu");
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    // Dashboard
    // --------------------------------------------------------------------------------------------------------------------------------
    public static void dashboard(Scanner scanner) {

    }

    // --------------------------------------------------------------------------------------------------------------------------------
    // Sign up
    // --------------------------------------------------------------------------------------------------------------------------------
    public static void signupMenu(Scanner scanner) {
        Random random = new Random();

        System.out.print("\n----Sign up----\n");
        // Name field
        String name = Functions.checkEmptyString(scanner, "Enter your name: ");

        // Surname field
        String surname = Functions.checkEmptyString(scanner, "Enter your surname: ");

        // Age field
        int age = Functions.checkEmptyInt(scanner, "Enter your age: ");
        // If user is not 18 they cannot have a bank account
        if (age < 18) {
            Toolkit.getDefaultToolkit().beep();
            System.out.println(Functions.REDtxt + "You are too young to have a bank account!" + Functions.RESETtxt);
            signupMenu(scanner);
        }

        // ID field
        // Checks if ID has 13 digits. if not it will prompt user to enter ID again
        // Has to be string because if it is an int it would be way too large
        String id = "";
        while (true) {
            id = Functions.checkEmptyString(scanner, "Enter ID number: ");
            int id_len = id.length();

            if (id_len < 13 || id_len > 13) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(Functions.REDtxt + "Invalid ID number!" + Functions.RESETtxt);
            } else {
                break;
            }
        }

        // Ask user if they would like to create their own pin or have it generated.
        String pin = "";
        while (true) {
            System.out
                    .println("\nWould you like a custom generated pin?\n-------------------------------------------\n");
            System.out.println("1. Yes\n2. No");

            int userChoice = Functions.checkEmptyInt(scanner, "\nEnter choice: ");
            if (userChoice == 1) {
                // Generate Pin then break out of loop
                int randNr = 0;

                for (int i = 0; i < 5; i++) {
                    randNr = random.nextInt(1, 10);
                    pin += randNr;
                }
                JOptionPane.showMessageDialog(null, "Your pin number is : " + pin);
                // System.out.println("\nYour pin is : " + Functions.REDtxt + pin +
                // Functions.RESETtxt + "\n");
                // Break out of loop
                break;

            } else if (userChoice == 2) {
                // Allow user to input custom pin then break out of loop

            } else {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(Functions.REDtxt + "Enter a number specified!" + Functions.RESETtxt);
            }
        }

        // Generate account number for user
        int randNr_2 = 0;
        String accountNr = "";
        for (int i = 0; i < 8; i++) {
            randNr_2 = random.nextInt(1, 9);
            accountNr += randNr_2;
        }
        JOptionPane.showMessageDialog(null, "Your account number is : " + accountNr);
        // System.out.println("Your account number is : " + Functions.REDtxt + accountNr
        // + Functions.RESETtxt + "\n");

        // Make user object to store info then put it in "Database" which will be an
        // array for now then later file storage or real database
        User user = new User(name, surname, age, id, accountNr, pin);
        // Put "user" object into "users_list" array list
        UsersArray.users_List.add(user);

        // Confirmation message to user
        JOptionPane.showMessageDialog(null, "Successfully Registered");

        // Redirect to menu after user is logged in or signed up
        loginMenu(scanner);
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    // Login menu
    // --------------------------------------------------------------------------------------------------------------------------------
    public static void loginMenu(Scanner scanner) {
        System.out.print("\n----Login----\n");

        // Counter is for checking how many times loop has been run
        User loggedInUser = null;
        int counter = 0;
        while (true) {
            String input = Functions.checkEmptyString(scanner, "Enter name and surname or account number: ");

            // For loop to loop through arraylist until "input" matches whats stored.
            for (User u : UsersArray.users_List) {

                if (input.equalsIgnoreCase(u.getName()) || input.equalsIgnoreCase(u.getSurname())
                        || input.equalsIgnoreCase(u.getAccountNr())) {
                    // Enter pin
                    String pin = Functions.checkEmptyString(scanner, "Enter pin number: ");
                    // Check if pin matches
                    if (!pin.equalsIgnoreCase(u.getPin())) {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println(Functions.REDtxt + "Incorrect pin" + Functions.RESETtxt);
                        counter++;

                    } else {
                        // Break out of for loop
                        loggedInUser = u;
                        dashboard(scanner);
                        return;
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println(Functions.REDtxt + input
                            + " is not a registered user. Ensure correct details are inputted." + Functions.RESETtxt);
                }

                if (counter > 3) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out
                            .println(Functions.REDtxt + "Pin entered incorrectly too many times!" + Functions.RESETtxt);
                    mainMenu(scanner);
                    return;
                }
            }
        }
    }
}
