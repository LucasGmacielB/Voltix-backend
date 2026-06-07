package com.voltix.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voltix.backend.model.Product;
import com.voltix.backend.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Listar todos
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Buscar por ID
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Salvar
    public Product save(Product product) {
        return productRepository.save(product);
    }
        
    // Atualizar
    public Product update(Long id, Product productDetails) {
        Product product = findById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setImgUrl(productDetails.getImgUrl());
        product.setCategory(productDetails.getCategory());

        return productRepository.save(product);
    }

    // Deletar
    public void delete(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}