package com.example.sweater.repos;

import com.example.sweater.domain.Check;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheckRepo extends CrudRepository<Check, Long> {
    List<Check> findByEngineNumber(String engineNumber);
}
