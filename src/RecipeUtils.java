import java.util.List;
import java.util.Scanner;

public class RecipeUtils {
    public static void createEditRecipe(List<Recipe> recipeList, Scanner scanner, Recipe recipe) {

        boolean isCreation = false;
        boolean isCompleted  = false;
        boolean isCanceled = false;
        if (recipe == null) {
            recipe = new Recipe();
            isCreation = true;
        }
        System.out.println("Here you can " + (isCreation ? "create new" : "edit") + " recipe.");

        String menu = """
                  Here you can create new or edit recipe.
                  You have to fill next fields. Type a number from menu to fill a field:
                  1 - Enter a recipe name
                  2 - Enter a description
                  3 - Choose a categorie
                  4 - manipulate with ingredients (create, edit, delete)
                  5 - manipulate with steps (create, edit, delete)
                  m - Show menu
                  s - Save recipe
                  c - Cancel recipe creation
                \s""";
        System.out.print(menu);


        do {
            System.out.print("\nChoose a punkt from Create-Edit recipe menu: ");
            String wahl = scanner.nextLine();
            switch (wahl) {
                case "1":
                    recipe.setName(CommonMethods.createEditStringField(recipe.getName(), "Recipe name", scanner));
                    break;
                case "2":
                    recipe.setDescription(CommonMethods.createEditStringField(recipe.getDescription(), "Recipe Description", scanner));
                    break;
                case "3":
                    String category = CommonMethods.createEditStringField("",
                            "Category (enter 'Breakfast', 'Dessert', 'Main Dish')", scanner);
                    recipe.setCategory(category);
                    break;
                case "4":
                    IngredientUtils.manipulateIngredients(recipe.getIngredients(), scanner, recipe);
                    break;
                case "5":
                    recipe.setDescription(CommonMethods.createEditStringField(recipe.getDescription(), "Recipe Description", scanner));
                    break;

                case "m":
                    System.out.println(menu);
                    break;
                case "s":
                    if (saveRecipeIfValid(recipe, recipeList, isCreation)) {
                        //DataUtil.serialize(recipeList, "tours.ser");
                        isCompleted = true;
                        if (isCreation)  {
                            System.out.println("Recipe "+ recipe +" has been created.");
                        } else {
                            System.out.println("Recipe "+ recipe +" has been edited.");
                        }
                    }
                    break;
                case "c":
                    System.out.println("You canceled this recipe"+ (isCreation ? "creation!" : "editing!"));
                    isCanceled = true;
                    break;
                default:
                    System.out.println("There no such command in creation menu. Press 'm' to show menu");
                    break;
            }
        } while (!isCompleted && !isCanceled);

    }

    private static boolean saveRecipeIfValid(Recipe recipe, List<Recipe> recipeList, boolean isCreation) {

        if (recipe.getName() == null || recipe.getName().isBlank()) {
            System.out.println("Recipe name is required. Please enter the name first.");
            return false;
        }

        if (isCreation) {
            recipeList.add(recipe);
        }

        System.out.println("Tour was saved successfully: " + recipe);
        return true;

    }
}
