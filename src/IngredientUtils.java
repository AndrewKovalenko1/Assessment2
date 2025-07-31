import java.util.List;
import java.util.Scanner;

public class IngredientUtils {

    public static void manipulateIngredients(List<Ingredient> ingredients, Scanner scanner) {
        boolean isContinued = true;
        String menu = """
                  Manipulates with ingredients menu
                  Choose an option:
                  1 - Create and add new ingredient
                  2 - Show all ingredients
                  4 - Edit ingredient by name
                  5 - Delete ingredient by name
                  m - Show menu
                  any key - exit from menu
                \s""";
        System.out.print(menu);
        do {
            System.out.print("\nChoose option from Manipulate with ingredients menu menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createEditIngredient(ingredients, scanner, null);
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
    }

    public static void createEditIngredient(List<Ingredient> ingredientList, Scanner scanner, Ingredient ingredient) {

        boolean isCreation = false;
        boolean isCompleted  = false;
        boolean isCanceled = false;
        if (ingredient == null) {
            ingredient = new Ingredient();
            isCreation = true;
        }
        System.out.println("Here you can " + (isCreation ? "create new" : "edit") + " ingredient.");

        String menu = """
                  Here you can create new or edit ingredient.
                  You have to fill next fields. Type a number from menu to fill a field:
                  1 - Enter a ingredient name
                  2 - Enter a quantity
                  m - Show menu
                  s - Save ingredient
                  c - Cancel ingredient creation
                \s""";
        System.out.print(menu);


        do {
            System.out.print("\nChoose a punkt from Create-Edit recipe menu: ");
            String wahl = scanner.nextLine();
            switch (wahl) {
                case "1":
                    ingredient.setName(CommonMethods.createEditStringField(ingredient.getName(), "Ingredient name", scanner));
                    break;
                case "2":
                    ingredient.setQuantity(CommonMethods.createEditStringField(ingredient.getQuantity(), "Quantity of ingredient", scanner));
                    break;
                case "m":
                    System.out.println(menu);
                    break;
                case "s":
                    if (saveIngredientIfValid(ingredient, ingredientList, isCreation)) {
                        isCompleted = true;
                        if (isCreation)  {
                            System.out.println("Ingredient "+ ingredient +" has been created.");
                        } else {
                            System.out.println("Ingredient "+ ingredient +" has been edited.");
                        }
                    }
                    break;
                case "c":
                    System.out.println("You canceled this ingredient"+ (isCreation ? "creation!" : "editing!"));
                    isCanceled = true;
                    break;
                default:
                    System.out.println("There no such command in creation menu. Press 'm' to show menu");
                    break;
            }
        } while (!isCompleted && !isCanceled);

    }

    private static boolean saveIngredientIfValid(Ingredient ingredient, List<Ingredient> ingredientList, boolean isCreation) {

        if (ingredient.getName() == null || ingredient.getName().isBlank()) {
            System.out.println("Ingredient name is required. Please enter the name first.");
            return false;
        }
        if (ingredient.getQuantity() == null || ingredient.getQuantity().isBlank()) {
            System.out.println("Ingredient quantity is required. Please enter the quantity.");
            return false;
        }

        if (isCreation) {
            ingredientList.add(ingredient);
        }

        System.out.println("Ingredient was saved successfully: " + ingredient);
        return true;

    }
}
