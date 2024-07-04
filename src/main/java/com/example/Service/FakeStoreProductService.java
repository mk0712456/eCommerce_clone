package com.example.Service;

import com.example.DTO.FakeStoreProductDTO;
import com.example.Model.Category;
import com.example.Model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(long productId) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDTO.class
        );
        return fakeStoreProductDTOtoproduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProduct() {
        //restTemplate provides get method to make http calls. In same for other methods too.
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreProductDTO[].class
        );
        List<Product> list = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            list.add(fakeStoreProductDTOtoproduct(fakeStoreProductDTO));
        }
        return list;
     }

    @Override
    public Product deleteProduct(long productId) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.delete();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/" +id,
                HttpMethod.PATCH, requestCallback, responseExtractor);
        return fakeStoreProductDTOtoproduct(response);
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    public Product fakeStoreProductDTOtoproduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitles());
        product.setPrice(fakeStoreProductDTO.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }
}
