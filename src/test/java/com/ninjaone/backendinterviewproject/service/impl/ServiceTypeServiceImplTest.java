package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.database.ServiceTypeRepository;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTypeServiceImplTest {
    public static final String ID = "456";

    @Mock
    private ServiceTypeRepository serviceTypeRepository;

    @InjectMocks
    private ServiceTypeServiceImpl serviceTypeService;

    private ServiceType serviceType;

    @BeforeEach
    void setup() {
        serviceType = new ServiceType(ID, "SystemName123", 4.0, new DeviceType());
    }

    @Test
    void testSaveServiceType() {
        when(serviceTypeRepository.save(serviceType)).thenReturn(serviceType);
        assertEquals(serviceType, serviceTypeService.saveServiceType(serviceType));
    }

    @Test
    void testDeleteServiceType() {
        doNothing().when(serviceTypeRepository).deleteById(ID);
        serviceTypeService.deleteServiceType(ID);
        Mockito.verify(serviceTypeRepository, times(1)).deleteById(ID);
    }
}
