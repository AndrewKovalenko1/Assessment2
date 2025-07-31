public enum Categorie {
    BREAKFAST ("Low"),
    DESSERT("Medium"),
    MAIN_DISH("High");

    private final String name;

    Categorie(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
