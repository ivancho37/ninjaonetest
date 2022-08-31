package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.database.CustomerDeviceRepository;
import com.ninjaone.backendinterviewproject.database.CustomerRepository;
import com.ninjaone.backendinterviewproject.database.ServiceTypeRepository;
import com.ninjaone.backendinterviewproject.model.CustomerDevice;
import com.ninjaone.backendinterviewproject.service.CustomerDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerDeviceServiceImpl implements CustomerDeviceService {

    private final CustomerDeviceRepository customerDeviceRepository;
    private final ServiceTypeRepository serviceTypeRepository;


    public CustomerDeviceServiceImpl(CustomerDeviceRepository customerDeviceRepository,
                                     ServiceTypeRepository serviceTypeRepository,
                                     CustomerRepository customerRepository) {
        this.customerDeviceRepository = customerDeviceRepository;
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public Double calculateMonthlyCost(String customerId) {
        List<CustomerDevice> customerDevices = customerDeviceRepository.findByCustomerId(customerId);
        if (customerDevices.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer doesn't have devices associated");
        }
        return calculateCostPerCustomer(customerDevices);
    }

    private Double calculateCostPerCustomer(List<CustomerDevice> customerDevices) {
        return customerDevices.stream().mapToDouble(customerDevice -> {
            String deviceTypeId = customerDevice.getDevice().getDeviceType().getId();
            return serviceTypeRepository.findByDeviceTypeId(deviceTypeId).stream().mapToDouble(
                    service -> customerDevice.getQuantity() * service.getCost()
            ).sum();
        }).sum();
    }
}
