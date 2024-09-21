package com.stock.manager.monitorstock;

import com.stock.manager.monitorstock.interfaces.DBProduct;
import com.stock.manager.monitorstock.model.ProductModel;
import com.stock.manager.monitorstock.service.CRUDProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.monitor.Monitor;

@Configuration
public class config {

    @Bean
    public CRUDProductService crudProductService() {
        return new CRUDProductService();
    }

    @Bean
    public DBProduct dbProduct() {
        return ProductModel.getInstance();
    }
}
