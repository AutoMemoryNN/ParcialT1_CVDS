package com.stock.manager.monitorstock.model;
import com.stock.manager.monitorstock.interfaces.DBProduct;

import java.util.ArrayList;

public class ProductModel implements DBProduct {

    private final ArrayList<Product> products = new ArrayList<>();

    public static ProductModel productModel;

    public static ProductModel getInstance(){
        if(productModel == null){
            productModel = new ProductModel();
        }
        return productModel;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public boolean existProduct(Product product){
        return products.contains(product);
    }
}
