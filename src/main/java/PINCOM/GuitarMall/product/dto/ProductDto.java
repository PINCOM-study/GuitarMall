package PINCOM.GuitarMall.product.dto;


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

    // Product 엔티티에서 ProductDto로 변환하는 메서드
    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .brand(product.getBrand())
                .unitsInStock(product.getUnitsInStock())
                .releaseDate(product.getReleaseDate())
                .national(product.getNational())
                .category(product.getCategory())
                .build();
    }
}

