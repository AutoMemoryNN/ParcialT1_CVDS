package com.stock.manager.monitorstock.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stock.manager.monitorstock.ServiceResponse;
import com.stock.manager.monitorstock.model.Product;
import com.stock.manager.monitorstock.service.CRUDProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CRUDProductService crudProductService;

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody String newProduct) {

        Product product = new Product(newProduct, newProduct, newProduct);

        ServiceResponse response = crudProductService.addNewProduct(product);

        if(response.ok()){
            return ResponseEntity.ok().header(response.message()).body(newProduct);
        }

        return ResponseEntity.badRequest().header(response.message()).body("Something went wrong");
    }

}
