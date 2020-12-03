package data.converters;

import data.enums.ProductType;
import data.enums.RecipeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RecipeTypeConverter implements AttributeConverter<RecipeType, String> {
    @Override
    public String convertToDatabaseColumn(RecipeType recipeType) {
        return recipeType.getName();
    }

    @Override
    public RecipeType convertToEntityAttribute(String s) {
        return RecipeType.valueOf(s.toUpperCase());
    }
//
//    public static void main(String[] args) {
//        ProductType type = ProductType.MEAT;
//        System.out.printf("name() = %s\n", type.name());
//        System.out.println("type.getName() = " + type.getName());
//    }
}
