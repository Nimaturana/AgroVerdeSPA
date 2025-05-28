package com.example.PruebaFS.AgroVerdeSPA.repository;

import com.example.PruebaFS.AgroVerdeSPA.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
