package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.CustomerDevice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDeviceRepository extends CrudRepository<CustomerDevice, String> {

    @Query("select o from CustomerDevice o where customer_id = :id")
    List<CustomerDevice> findByCustomerId(@Param("id") String customerId);

}
