package pl.jw.zad_21_1_lista_produktow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Arbuz", 12.50, ProductCategory.GROCERY));
        products.add(new Product("Chleb", 8.50, ProductCategory.GROCERY));
        products.add(new Product("Dżem truskawkowy", 6.20, ProductCategory.GROCERY));
        products.add(new Product("Telewizor", 3400.00, ProductCategory.AGD));
        products.add(new Product("Rower", 4500.00, ProductCategory.OTHER));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(ProductCategory category) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                filtered.add(product);
            }
        }
        return filtered;
    }

    public void add(Product product) {
        products.add(product);
    }
}
