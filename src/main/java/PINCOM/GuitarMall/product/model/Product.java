package PINCOM.GuitarMall.product.model;

import jakarta.persistence.*;
import lombok.*;

//상품 도메인


@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="DTYPE")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private int price;
    private String brand;
    private long unitsInStock;
    private String releaseDate;
    private String national;

    private String category;
}



