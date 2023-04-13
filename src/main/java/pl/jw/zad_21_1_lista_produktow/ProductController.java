package pl.jw.zad_21_1_lista_produktow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/lista")
    public String showList(@RequestParam(required = false, name = "kategoria") ProductCategory category, Model model) {
        List<Product> products;
        double sum = 0;
        if (category != ProductCategory.ALL) {
            products = productRepository.findByCategory(category);
            model.addAttribute("productName", category.getPlName());
        } else {
            products = productRepository.findAll();
            model.addAttribute("productName", "Wszystkie produkty");
        }
        for (Product product : products) {
            sum += product.getPrice();
        }
        model.addAttribute("priceSum", sum);
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/dodaj")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {
        productRepository.add(product);
        return "redirect:/";
    }
}
