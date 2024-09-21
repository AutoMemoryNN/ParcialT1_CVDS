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

        Product product = new Product(newProduct, newProduct, newProduct, newProduct, newProduct);
        // Aca deberia desempaquetar el JSON y crear un usuario con esos datos

        ServiceResponse<String> response = crudProductService.addNewProduct(product);

        if(response.ok()){
            return ResponseEntity.ok().header(response.message()).body(newProduct);
        }

        return ResponseEntity.badRequest().header(response.message()).body("Something went wrong");
    }

    @PutMapping("{name}")
    public ResponseEntity<String> updateProduct(@PathVariable String name, @RequestBody String newProduct) {
        Product nProduct = new Product(name, newProduct, newProduct, newProduct, newProduct);
        //Deberia desempaqeutar el JSON y crear un nuevo producto

        Product oProduct = new Product(name, name, name, name, name);
        //deberia veridicar que existe el antiguo producto y obtenerlo, de momento solo lo genera

        ServiceResponse<Boolean> response = crudProductService.updateProduct(oProduct, nProduct);

        if(response.ok()){
            return ResponseEntity.ok().header(response.message()).body(newProduct);
        }
        return ResponseEntity.badRequest().header(response.message()).body("Something went wrong");
    }

}
