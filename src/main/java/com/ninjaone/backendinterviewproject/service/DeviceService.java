package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Device;

import java.util.List;

public interface DeviceService {

    Device getDevice(String id);

    List<Device> getAllDevices();

    Device saveDevice(Device device);

    void deleteDevice(String id);

    Device updateDevice(String id, Device newDevice);
}
