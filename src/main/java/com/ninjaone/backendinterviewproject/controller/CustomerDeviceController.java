package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.service.CustomerDeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerdevice")
public class CustomerDeviceController {

    private final CustomerDeviceService customerDeviceService;

    public CustomerDeviceController(CustomerDeviceService customerDeviceService) {
        this.customerDeviceService = customerDeviceService;
    }

    @GetMapping("/calculatecost/{customerid}")
    private double calculateMonthlyCost(@PathVariable String customerid) {
        return customerDeviceService.calculateMonthlyCost(customerid);
    }

}
