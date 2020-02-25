package com.example.sweater.repos;

import com.example.sweater.domain.Check_Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheckRepo extends CrudRepository<Check_Car, Long> {
    List<Check_Car> findByVin(String vin);
}
