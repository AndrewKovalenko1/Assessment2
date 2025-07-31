import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class IngredientUtils {

    public static void manipulateIngredients(List<Ingredient> ingredients, Scanner scanner, Recipe recipe) {
        boolean isContinued = true;
        String menu = """
                  Manipulates with ingredients menu
                  Choose an option:
                  1 - Create and add new ingredient
                  2 - Show all ingredients
                  3 - Edit ingredient by name
                  4 - Delete ingredient by name
                  m - Show menu
                  any key - exit from menu
                \s""";
        System.out.print(menu);
        do {
            System.out.print("\nChoose option from Manipulate with ingredients menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createEditIngredient(ingredients, scanner, null);
                    break;
                case "2":
                    System.out.println("Ingredients of " + recipe.getName() + ":");
                    for(Ingredient ingredient : ingredients) {
                        System.out.println(ingredient);
                    }
                    break;
                case "3":
                    Ingredient ingredient = searchIngredientByName(ingredients, scanner);
                    if(ingredient != null) {
                        System.out.println("Now you can edit ingredient: " + ingredient);
                        createEditIngredient(ingredients, scanner, ingredient);
                    } else {
                        System.out.println("Ingredient not found!");
                    }
                    break;
                case "4":
                    deleteIngredient(ingredients, scanner);
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
            System.out.print("\nChoose a punkt from Create-Edit ingredient menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
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

    private static Ingredient searchIngredientByName(List<Ingredient> ingredients, Scanner scanner) {
        System.out.print("Please enter the name of the ingredient you want to search: ");
        String name = scanner.nextLine();
        Optional<Ingredient> ingredient = ingredients.stream().filter(t -> t.getName().equals(name))
                .findFirst();
        if (ingredient.isPresent()) {
            System.out.println("The ingredient has been found!");
            return ingredient.get();
        } else {
            System.out.println("The ingredient could not be found!");
            return null;
        }
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

    private static void deleteIngredient(List<Ingredient> ingredientList, Scanner scanner) {

        Ingredient ingredient = searchIngredientByName(ingredientList, scanner);
        if (ingredient == null) {
            return;
        }

        if (ingredientList.remove(ingredient)) {
            System.out.println("Ingredient removed successfully!");
        }

    }
}
