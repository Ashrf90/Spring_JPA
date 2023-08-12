package com.example.demo.Product.services;

import com.example.demo.Product.entities.Product;
import com.example.demo.Product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //----------- Dependency injection of ProductRepository using constructor injection ---------//

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    //-------------------------------- Post method -----------------------------------//
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //-------------------------------- Get method -----------------------------------//
    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int ProductId){
        return repository.findById(ProductId).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //-------------------------------- Delete method -----------------------------------//
    public String deleteProduct(int ProductId){
        repository.deleteById(ProductId);
        return "product removed !" + ProductId;
    }

    //-------------------------------- Update method -----------------------------------//
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getProductId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }




}
