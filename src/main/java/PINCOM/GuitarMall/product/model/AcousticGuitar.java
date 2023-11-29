package PINCOM.GuitarMall.product.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("acoustic-guitar")
public class AcousticGuitar extends Product{
    private String acousticGuitarField;
}
