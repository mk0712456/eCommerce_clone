package com.example.Controller;

import com.example.Model.Product;
import com.example.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    public  ProductController(ProductService  productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return this.productService.getSingleProduct(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return this.productService.getAllProduct();
    }
    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return this.productService.deleteProduct(id);
    }
    //patch
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable ("id") Long id, @RequestBody Product product){
        return null;
    }
    //put
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return null;
    }
}
