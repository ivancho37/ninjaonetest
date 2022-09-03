package com.ninjaone.backendinterviewproject.service.impl;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceImplTest {
    public static final String ID = "123";

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceServiceImpl deviceService;

    private Device device;

    @BeforeEach
    void setup() {
        device = new Device(ID, "SystemName123", new DeviceType());
    }

    @Test
    void testGetDevice() {
        when(deviceRepository.findById(ID)).thenReturn(Optional.of(device));
        Device actualDevice = deviceService.getDevice(ID);
        assertNotNull(actualDevice);
        assertEquals(device.getSystemName(), actualDevice.getSystemName());
    }

    @Test
    void testGetAllDevices() {
        when(deviceRepository.findAll()).thenReturn(Collections.singletonList(device));
        List<Device> actualDevices = deviceService.getAllDevices();
        Assertions.assertFalse(actualDevices.isEmpty());
        assertEquals(1, actualDevices.size());
    }

    @Test
    void testSaveDevice() {
        when(deviceRepository.save(device)).thenReturn(device);
        assertEquals(device, deviceService.saveDevice(device));
    }

    @Test
    void testDeleteDevice() {
        doNothing().when(deviceRepository).deleteById(ID);
        deviceService.deleteDevice(ID);
        Mockito.verify(deviceRepository, times(1)).deleteById(ID);
    }
}
