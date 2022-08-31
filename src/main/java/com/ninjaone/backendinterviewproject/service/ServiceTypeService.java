package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.ServiceType;

public interface ServiceTypeService {

    ServiceType saveServiceType(ServiceType serviceType);

    void deleteServiceType(String id);

}
