package com.stock.manager.monitorstock.interfaces;

import com.stock.manager.monitorstock.model.Product;

import java.util.ArrayList;

public interface DBProduct {
    public void addProduct(Product product);

    public void removeProduct(Product product);

    public boolean existProduct(Product product);

    ArrayList<Product> getProducts();
}
