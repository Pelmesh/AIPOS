package com.example.sweater.repos;

import com.example.sweater.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
    List<Owner> findByOwnerName(String ownerName);
}
