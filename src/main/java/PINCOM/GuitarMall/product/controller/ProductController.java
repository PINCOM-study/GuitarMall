package PINCOM.GuitarMall.product.controller;

import PINCOM.GuitarMall.product.dto.ProductDto;
import PINCOM.GuitarMall.product.model.Product;
import PINCOM.GuitarMall.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    // 상품 등록 페이지
    @GetMapping("/add_product")
    public String showAddProductForm() {
        return "add_product"; // add_product.html로 이동
    }

    // 상품 등록 (값 들어올때)
    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute ProductDto productDto, RedirectAttributes redirectAttributes) {
        productService.addProduct(productDto);
        redirectAttributes.addFlashAttribute("productAdded", true);
        return "redirect:/product_list";
    }


    //전체 상품 조회
    @GetMapping("/product_list")
    public String findAll(Model model){
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }


}