package com.example.demo.controllers;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    //----------- Dependency injection of ProductService using constructor injection ---------//
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //-------------------------------- Post method -----------------------------------//

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    //-------------------------------- Get method -----------------------------------//
    @GetMapping("/Products")
    public List<Product> finAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product finProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product finProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    //-------------------------------- Put method -----------------------------------//

    @PutMapping("/update")
    public  Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    //-------------------------------- Delete method -----------------------------------//

    @DeleteMapping("/delete/{id}")
    public  String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }




}
