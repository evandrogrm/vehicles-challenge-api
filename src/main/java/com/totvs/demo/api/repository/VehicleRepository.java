package com.totvs.demo.api.repository;


import com.totvs.demo.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {
}
