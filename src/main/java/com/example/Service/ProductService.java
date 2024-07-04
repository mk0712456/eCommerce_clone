package com.example.Service;

import com.example.Model.Product;

import java.util.List;

public interface ProductService {
     Product getSingleProduct(long productId);
     List<Product> getAllProduct();
     Product deleteProduct(long id);
     Product updateProduct(long id, Product product);
     Product replaceProduct(long id, Product product);
}
