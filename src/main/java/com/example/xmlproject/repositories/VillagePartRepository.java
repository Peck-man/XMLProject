package com.example.xmlproject.repositories;

import com.example.xmlproject.models.VillagePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillagePartRepository extends JpaRepository<VillagePart, Integer> {
}
