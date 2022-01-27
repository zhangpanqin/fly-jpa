package com.fly.jpa.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterTestController {
    @Autowired
    private BlogWithPermissionJpaRepository repository;

    @GetMapping("/data/teat")
    public String test() {
        repository.findAll();
        return "11";
    }
}
