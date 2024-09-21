package com.stock.manager.monitorstock.controller;

import com.stock.manager.monitorstock.ServiceResponse;
import com.stock.manager.monitorstock.model.Product;
import com.stock.manager.monitorstock.service.CRUDProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CRUDProductService crudProductService;

    @GetMapping
    public String getUser() {
        ServiceResponse<ArrayList<Product>> response = crudProductService.getProducts();
        if (response.ok()){
            return response.data().toString();
        }
        return response.message();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody String newProduct) {

        Product product = new Product(newProduct, newProduct, newProduct);

        ServiceResponse<String> response = crudProductService.addNewProduct(product);

        if(response.ok()){
            return ResponseEntity.ok().header(response.message()).body(newProduct);
        }

        return ResponseEntity.badRequest().header(response.message()).body("Something went wrong");
    }

}
