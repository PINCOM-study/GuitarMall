package PINCOM.GuitarMall.product.dto;

import PINCOM.GuitarMall.product.model.Product;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String name;
    private int price;
    private String brand;
    private long unitsInStock;
    private String releaseDate;
    private String national;
    private String category;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.brand = product.getBrand();
        this.unitsInStock = product.getUnitsInStock();
        this.releaseDate = product.getReleaseDate();
        this.national = product.getNational();
        this.category = product.getCategory();
    }

}

