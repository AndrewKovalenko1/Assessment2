package model;

import enums.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Recipe {

    private String name;
    private String description;
    private Category category;
    private final List<Ingredient> ingredients;
    private final List<Step> steps;

    public Recipe(String name, String description, Category category, List<Ingredient> ingredients, List<Step> steps) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe() {
        this.name = "";
        this.description = "";
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        Optional<Category> optCategory = Arrays.stream(Category.values())
                .filter(cat -> cat.getName().equalsIgnoreCase(category))
                .findFirst();
        if (optCategory.isPresent()) {
            this.category = optCategory.get();
            System.out.println("You chose " +category);
        } else {
            System.out.println("Category is Not Found. Please try again.");
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

   public List<Step> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        String categoryName = (category != null) ? category.getName() : "no category";
        return "Recipe '"+ name + "', description: '" + description + "', category: '" + categoryName + "'";

    }
}
