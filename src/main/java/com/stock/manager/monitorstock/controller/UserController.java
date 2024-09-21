package com.stock.manager.monitorstock.controller;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @PostMapping
    public void createUser(@RequestBody HashMap<Integer, String> user) {

    }

}
