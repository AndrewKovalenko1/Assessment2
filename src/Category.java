public enum Category {
    BREAKFAST ("Breakfast"),
    DESSERT("Dessert"),
    MAIN_DISH("Main Dish"),;

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
