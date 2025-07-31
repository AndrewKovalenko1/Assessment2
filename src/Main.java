import data.StartData;
import model.Recipe;
import util.RecipeUtils;

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
                  m - Show menu
                  Any other key - Exit programm
                \s""";
        System.out.print(menu);
        do {
            System.out.print("\nChoose option from Main menu: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    RecipeUtils.createEditRecipe(recipes, scanner, null);
                    break;
                case "2":
                    System.out.println("Recipe list:");
                    for(Recipe recipe : recipes) {
                        System.out.println(recipe);
                    }
                    break;
                case "3":
                    Recipe recipe = RecipeUtils.searchRecipeByName(recipes, scanner);
                    if(recipe != null) {
                        RecipeUtils.showRecipe(recipe);
                    }
                    break;
                case "4":
                    Recipe recipeEdit = RecipeUtils.searchRecipeByName(recipes, scanner);
                    if(recipeEdit != null) {
                        RecipeUtils.createEditRecipe(recipes, scanner, recipeEdit);
                    }
                    break;
                case "5":
                    RecipeUtils.deleteRecipe(recipes, scanner);
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
