package com.example.sweater.repos;
import com.example.sweater.domain.Check_Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CheckRepo extends JpaRepository<Check_Car, Long> {
    List<Check_Car> findAll();
    //List<Check_Car> findByVin(String vin);
}
