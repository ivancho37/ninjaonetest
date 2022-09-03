package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.database.CustomerDeviceRepository;
import com.ninjaone.backendinterviewproject.database.ServiceTypeRepository;
import com.ninjaone.backendinterviewproject.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerDeviceServiceImplTest {
    public static final String ID = "CustomerId";
    public static final String DEVICE_ID = "DeviceId";
    public static final String DEVICE_TYPE_ID = "DeviceTypeId";

    @Mock
    private CustomerDeviceRepository customerDeviceRepository;

    @Mock
    private ServiceTypeRepository serviceTypeRepository;

    @InjectMocks
    private CustomerDeviceServiceImpl service;

    private CustomerDevice customerDevice;
    private DeviceType deviceType;

    @BeforeEach
    void setup() {
        deviceType = new DeviceType(DEVICE_TYPE_ID, "Mac");
        Device device = new Device(DEVICE_ID, "SystemName123", deviceType);
        customerDevice = new CustomerDevice(ID, new Customer(), device, 3);
    }

    @Test
    void testCalculateMonthlyCost() {
        List<ServiceType> services = new ArrayList<>();
        ServiceType serviceType = new ServiceType("ServiceTypeId1", "Mainteinance", 4d, deviceType);
        services.add(serviceType);
        serviceType = new ServiceType("ServiceTypeId2", "Backup", 2d, deviceType);
        services.add(serviceType);

        when(customerDeviceRepository.findByCustomerId(ID)).thenReturn(Collections.singletonList(customerDevice));
        when(serviceTypeRepository.findByDeviceTypeId(DEVICE_TYPE_ID)).thenReturn(services);

        Double monthlyCost = service.calculateMonthlyCost(ID);
        assertEquals(18d, monthlyCost);
    }
}
