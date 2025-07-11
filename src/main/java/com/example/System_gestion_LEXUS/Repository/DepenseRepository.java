package com.example.System_gestion_LEXUS.Repository;

import com.example.System_gestion_LEXUS.Entities.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {
    
    List<Depense> findByDate(Date date);
    
    List<Depense> findByMontantGreaterThan(Double montant);
    
    List<Depense> findByDateBetween(Date startDate, Date endDate);
}
