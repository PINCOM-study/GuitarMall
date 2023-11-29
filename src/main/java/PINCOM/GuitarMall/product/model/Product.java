package PINCOM.GuitarMall.product.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

//상품 도메인
@Getter
@Setter
public class Product {

    private String productId;
    private String name;
    private String category;
    private int Price;
    private String brand;
    private long unitsInStock;
    private String releaseDate;
    private String national;

}
