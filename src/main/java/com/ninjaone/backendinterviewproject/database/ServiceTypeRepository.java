package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.ServiceType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, String> {

    @Query("select s from ServiceType s where device_type_id = :deviceTypeId")
    List<ServiceType> findByDeviceTypeId(@Param("deviceTypeId") String deviceTypeId);

}
