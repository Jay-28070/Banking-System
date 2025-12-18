package src;
import java.awt.Toolkit;
import java.util.Scanner;

public class Functions {

    //Change console text to red
    public static final String REDtxt = "\u001B[31m";

    //Reset console color
    public static final String RESETtxt = "\u001B[0m";

    // Check if inputted string was left blank
    public static String checkEmptyString(Scanner scanner, String prompt) {
        String input = "";  //Declaring outside loop so "input" can be available to return 
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();

            //Check if "input" is empty
            if (input.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(REDtxt + "Field cannot be empty!" + RESETtxt);
            } else {
                break;
            }
        }
        //Return a value, which would be input so it can be saved in a String variable
        return input.trim();
    }

    //Check if inputted int was left blank
    public static int checkEmptyInt(Scanner scanner, String prompt) {
        int input_int = 0;
        String input_str = "";
        while (true) {
            System.out.print(prompt);
            input_str = scanner.nextLine().trim();

            //Check if "input_str" was left blank
            if (input_str.isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                System.out.println(REDtxt + "Do not leave field empty!" + RESETtxt);
            } else {
                //Now relevant integer checks must be done
                try {
                    input_int = Integer.parseInt(input_str);
                    break;
                } catch (NumberFormatException e) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println(REDtxt + "Enter a valid number!" + "\n"  + e + RESETtxt);
                }
            } 
        }
        return input_int;
    }
}
