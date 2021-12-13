package com.example.springbootajaxcustomer.controller;

import com.example.springbootajaxcustomer.model.Customer;
import com.example.springbootajaxcustomer.model.Provinces;
import com.example.springbootajaxcustomer.service.customer.ICustomerService;
import com.example.springbootajaxcustomer.service.provinces.IProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvincesService provincesService;

    @ModelAttribute("provincesList")
    public Iterable<Provinces> provinces(){
        return provincesService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Customer>> allCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

//    @GetMapping("/home")
//    public ModelAndView getAllCustomerPage(){
//        ModelAndView modelAndView = new ModelAndView("/listCustomer");
//        modelAndView.addObject("customerList", customerService.findAll());
//        return modelAndView;
//    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
