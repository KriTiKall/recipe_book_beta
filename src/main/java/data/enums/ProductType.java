package data.enums;

public enum ProductType {
    MEAT("meat"),
    FISH("fish"),
    VEGETABLE("vegetable"),
    SPICE("spice"),
    FRUIT("fruit"),
    CHEESE("cheese"),
    DRINK("drink"),
    SNACK("snack"),
    SAUCE("sauce"),
    ALCOHOL("alcohol");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
