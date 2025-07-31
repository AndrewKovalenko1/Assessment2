import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Recipe> recipes = StartData.createSampleRecipes();

        Scanner scanner = new Scanner(System.in);
        boolean isContinued = true;
        String menu = """
                  Assessment2 main menu
                  Choose an option:
                  1 - Create new recipe
                  2 - Show all recipes
                  3 - Search and show one recipe by name
                  4 - Edit recipe by name
                  5 - Delete recipe by name
                  m - Menü anzeigen
                  Jede andere Eingabe - Programm beenden
                \s""";
        System.out.print(menu);
        do {
            System.out.print("\nChoose option from Main menu: ");
            String wahl = scanner.nextLine();
            switch (wahl) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "m":
                    System.out.println(menu);
                    break;
                default:
                    isContinued = false;

                    break;
            }
        } while (isContinued);
        scanner.close();
    }
}
