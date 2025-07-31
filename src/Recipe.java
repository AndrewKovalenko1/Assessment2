import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private String description;
    private Categorie category;
    private List<Ingredient> ingredients;
    private List<Step> steps;

    public Recipe(String name, String description, Categorie category, List<Ingredient> ingredients, List<Step> steps) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }
}
