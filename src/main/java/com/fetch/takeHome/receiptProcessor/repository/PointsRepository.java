package com.fetch.takeHome.receiptProcessor.repository;

import com.fetch.takeHome.receiptProcessor.entity.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PointsRepository extends JpaRepository<Points, UUID> {
}
