package com.example.sweater.repos;

import com.example.sweater.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    List<Owner> findAll();
    List<Owner> findOwnerByIdOwner(Integer idOwner);
    Long deleteOwnerByIdOwner(Integer idOwner);
}
