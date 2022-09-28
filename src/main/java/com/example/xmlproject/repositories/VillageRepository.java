package com.example.xmlproject.repositories;

import com.example.xmlproject.models.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
    Village findByCode(int code);
}
