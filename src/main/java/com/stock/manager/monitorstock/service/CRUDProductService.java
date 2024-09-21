package com.stock.manager.monitorstock.service;

import com.stock.manager.monitorstock.ServiceResponse;
import com.stock.manager.monitorstock.interfaces.DBProduct;
import com.stock.manager.monitorstock.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CRUDProductService {
    @Autowired
    private DBProduct dbProduct;

    public ServiceResponse<String> addNewProduct(Product product){
        if (!validateProduct()){
            return new ServiceResponse<String>(false, "Error: por algun motivo", "Error");
        }

        dbProduct.addProduct(product);
        return new ServiceResponse<String>(true, "ok", "ok");
    }

    public ServiceResponse<ArrayList<Product>> getProducts(){
        if (!validateAuth()){
            return new ServiceResponse<ArrayList<Product>>(false, "Error: No tiene privilegios", null);
        }
        return new ServiceResponse<ArrayList<Product>>(true, "ok", dbProduct.getProducts());
    }

    private boolean validateAuth(){
        return true;
    }

    private boolean validateProduct(){
        return true;
    }
}
