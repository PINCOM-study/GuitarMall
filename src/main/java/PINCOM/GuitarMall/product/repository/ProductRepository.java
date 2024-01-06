package PINCOM.GuitarMall.product.repository;

import PINCOM.GuitarMall.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {
}
