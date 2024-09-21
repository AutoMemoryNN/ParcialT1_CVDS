package com.stock.manager.monitorstock.service;

import com.stock.manager.monitorstock.ServiceResponse;
import com.stock.manager.monitorstock.interfaces.DBProduct;
import com.stock.manager.monitorstock.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class CRUDProductService {
    @Autowired
    private DBProduct dbProduct;

    public ServiceResponse addNewProduct(Product product){
        if (!validateProduct()){
            return new ServiceResponse(false, "Error: por algun motivo");
        }

        dbProduct.addProduct(product);
        return new ServiceResponse(true, "ok");
    }

    private boolean validateProduct(){
        return true;
    }
}
