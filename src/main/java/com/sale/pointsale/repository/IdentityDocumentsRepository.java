package com.sale.pointsale.repository;

import com.sale.pointsale.models.entity.IdentityDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityDocumentsRepository extends JpaRepository<IdentityDocuments, Integer> {
}
