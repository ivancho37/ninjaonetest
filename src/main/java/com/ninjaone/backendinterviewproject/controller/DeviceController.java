package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    private List<Device> findAllDevice() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    private Device findDevice(@PathVariable String id) {
        return deviceService.getDevice(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device addDevice(@RequestBody Device device) {
        return deviceService.saveDevice(device);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDevice(@PathVariable String id) {
        deviceService.deleteDevice(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Device updateDevice(@PathVariable String id, @RequestBody Device device) {
        return deviceService.updateDevice(id, device);
    }

}
