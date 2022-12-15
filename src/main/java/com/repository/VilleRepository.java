package com.repository;

import com.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {

    List<Ville> findByCodePostal(String codePostal);

    Ville findByCodeCommune(String codeCommune);

    @Transactional
    void deleteByCodeCommune(String codeCommune);
}