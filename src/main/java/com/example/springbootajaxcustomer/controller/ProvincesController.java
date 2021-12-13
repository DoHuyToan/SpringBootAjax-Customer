package com.example.springbootajaxcustomer.controller;

import com.example.springbootajaxcustomer.model.Provinces;
import com.example.springbootajaxcustomer.service.customer.ICustomerService;
import com.example.springbootajaxcustomer.service.provinces.IProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provinces")
@CrossOrigin("*")
public class ProvincesController {

    @Autowired
    private IProvincesService provincesService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Provinces>> allProvinces(){
        return new ResponseEntity<>(provincesService.findAll(), HttpStatus.OK);
    }


}
