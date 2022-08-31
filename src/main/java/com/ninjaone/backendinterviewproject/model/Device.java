package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {

    @Id
    private String id;

    @Column(unique = true)
    private String systemName;

    @ManyToOne
    private DeviceType deviceType;

    public Device() {
    }

    public Device(String id, String systemName, DeviceType deviceType) {
        this.id = id;
        this.systemName = systemName;
        this.deviceType = deviceType;
    }

    public String getId() {
        return id;
    }

    public String getSystemName() {
        return systemName;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
