package com.ninjaone.backendinterviewproject.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints =
        { //other constraints
                @UniqueConstraint(name = "UniqueServiceNameAndType", columnNames = { "serviceName", "device_type_id" })})
public class ServiceType {

    @Id
    private String id;

    private String serviceName;

    private Double cost;

    @ManyToOne
    private DeviceType deviceType;

    public ServiceType() {
    }

    public ServiceType(String id, String serviceName, Double cost, DeviceType deviceType) {
        this.id = id;
        this.serviceName = serviceName;
        this.cost = cost;
        this.deviceType = deviceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
