package PINCOM.GuitarMall.product.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("electric_guitar")
public class ElectricGuitar extends Product {
    private String electricGuitarField;
}
