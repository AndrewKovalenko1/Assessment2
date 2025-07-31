import java.util.Scanner;

public class CommonMethods {
    public static int enterPositiveIntNumber(Scanner scanner, String text) {
        int number = -1;
        do {
            System.out.print(text);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number < 0) {
                    System.out.println("Please, enter only positive integer values");
                }
            } else {
                System.out.println("Please, enter only positive integer values");
                scanner.nextLine();
            }
        } while (number <= 0);
        return number;
    }

    public static String createEditStringField(String currentFieldValue, String nameString, Scanner scanner) {
        String newFieldName;

        if (currentFieldValue != null && !currentFieldValue.isEmpty()) {
            System.out.println("Current " + nameString + ": \"" + currentFieldValue + "\"");
            System.out.println("You can select and copy it manually if you want to modify it.");
            System.out.println("Enter a new " + nameString + " or press Enter to keep the previous one.");
            System.out.println("Type 'exit' to cancel.\n");
        } else {
            System.out.println("Enter " + nameString + " (or type 'exit' to cancel):");
        }

        while (true) {
            System.out.print(nameString + ": ");
            newFieldName = scanner.nextLine().trim();

            if (newFieldName.equalsIgnoreCase("exit")) {
                System.out.println(nameString + " editing cancelled.");
                return "";
            }

            if (newFieldName.isEmpty()) {
                if (currentFieldValue != null && !currentFieldValue.isEmpty()) {
                    newFieldName = currentFieldValue;
                    break;
                } else {
                    System.out.println(nameString + " cannot be empty. Please try again.");
                }
            } else {
                break;
            }
        }

        return newFieldName;
    }


    public static int createEditIntField(int currentFieldValue, String nameString, Scanner scanner) {

        if (currentFieldValue != 0) {
            System.out.println("Current " + nameString + ": \"" + currentFieldValue + "\"");
        }

        return enterPositiveIntNumber(scanner, "Enter a new " + nameString + ":");
    }
}
