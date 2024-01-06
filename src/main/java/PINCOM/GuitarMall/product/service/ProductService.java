package PINCOM.GuitarMall.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import PINCOM.GuitarMall.product.dto.ProductDto;
import PINCOM.GuitarMall.product.model.Product;
import PINCOM.GuitarMall.product.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    // 상품 등록
    @Transactional
    public String addProduct(ProductDto productDto) {

        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .brand(productDto.getBrand())
                .unitsInStock(productDto.getUnitsInStock())
                .releaseDate(productDto.getReleaseDate())
                .national(productDto.getNational())
                .category(productDto.getCategory())
                .build();


        return productRepository.save(product).getName();
    }

    // 상품 목록 조회
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {

        return productRepository.findAll().stream()
                .map(product-> {return new ProductDto(product);}).collect(Collectors.toList());


    }

}