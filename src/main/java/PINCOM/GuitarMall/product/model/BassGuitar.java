package PINCOM.GuitarMall.product.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("bass_guitar")
public class BassGuitar extends Product{

}
