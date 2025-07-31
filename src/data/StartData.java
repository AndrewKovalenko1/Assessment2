package data;

import enums.Category;
import model.Ingredient;
import model.Recipe;
import model.Step;

import java.util.ArrayList;
import java.util.List;

public class StartData {

    public static List<Recipe> createSampleRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe(
                "Pancakes",
                "Fluffy pancakes for breakfast",
                Category.BREAKFAST,
                List.of(
                        new Ingredient("Flour", "200 g"),
                        new Ingredient("Milk", "300 ml"),
                        new Ingredient("Eggs", "2"),
                        new Ingredient("Sugar", "1 tbsp")
                ),
                List.of(
                        new Step(1, "Mix all ingredients in a bowl."),
                        new Step(2, "Pour batter onto a hot pan."),
                        new Step(3, "Cook until golden on both sides.")
                )
        ));

        recipes.add(new Recipe(
                "Chocolate Cake",
                "Rich and moist chocolate cake",
                Category.DESSERT,
                List.of(
                        new Ingredient("Flour", "250 g"),
                        new Ingredient("Cocoa powder", "50 g"),
                        new Ingredient("Sugar", "200 g"),
                        new Ingredient("Eggs", "3"),
                        new Ingredient("Butter", "100 g"),
                        new Ingredient("Milk", "150 ml")
                ),
                List.of(
                        new Step(1, "Preheat oven to 180°C."),
                        new Step(2, "Mix dry and wet ingredients separately."),
                        new Step(3, "Combine and pour into a baking dish."),
                        new Step(4, "Bake for 35 minutes.")
                )
        ));

        recipes.add(new Recipe(
                "Spaghetti Bolognese",
                "Classic Italian main dish with meat sauce",
                Category.MAIN_DISH,
                List.of(
                        new Ingredient("Spaghetti", "300 g"),
                        new Ingredient("Ground beef", "400 g"),
                        new Ingredient("Tomato sauce", "200 ml"),
                        new Ingredient("Onion", "1"),
                        new Ingredient("Garlic", "2 cloves"),
                        new Ingredient("Olive oil", "2 tbsp")
                ),
                List.of(
                        new Step(1, "Boil spaghetti until al dente."),
                        new Step(2, "Sauté onion and garlic in olive oil."),
                        new Step(3, "Add ground beef and cook until browned."),
                        new Step(4, "Pour in tomato sauce and simmer."),
                        new Step(5, "Serve sauce over spaghetti.")
                )
        ));

        return recipes;
    }
}
