package data.enums;

public enum RecipeType {
    SOUP("soup"),
    HOT("hot"),
    COCKTAIL("cocktail"),
    SNACK("snack"),
    SALAD("salad");

    private final String name;

    RecipeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
