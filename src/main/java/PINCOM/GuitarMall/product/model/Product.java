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
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private long unitsInStock;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String national;

    @Column(nullable = false)
    private String category;
}



