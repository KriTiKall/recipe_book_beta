package data.converters;

import data.enums.ProductType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType productType) {
        return productType.getName();
    }

    @Override
    public ProductType convertToEntityAttribute(String s) {
        return ProductType.valueOf(s.toUpperCase());
    }
}
