package PINCOM.GuitarMall.product.dto;

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

}

