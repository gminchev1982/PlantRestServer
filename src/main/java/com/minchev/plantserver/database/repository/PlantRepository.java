package com.minchev.plantserver.database.repository;

import com.minchev.plantserver.database.entity.PlantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<PlantEntity,String> {
    Optional<PlantEntity> findByBarcode(String barcode);
    Optional<PlantEntity> findById(String id);
    Optional<PlantEntity> findByActive(Boolean active);
    @Override
    Page<PlantEntity> findAll(Pageable pageable);


}

