package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Kiểm tra nếu DB chưa có dữ liệu thì thêm vài sản phẩm mẫu
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Áo thun", 150000, "Áo thun cotton màu trắng"));
            productRepository.save(new Product("Quần jeans", 350000, "Quần jeans xanh đậm"));
            productRepository.save(new Product("Giày thể thao", 700000, "Giày thể thao nam"));
            System.out.println("Đã thêm dữ liệu mẫu cho sản phẩm.");
        }
    }
}
