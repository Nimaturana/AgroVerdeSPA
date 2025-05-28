package com.example.PruebaFS.AgroVerdeSPA.repository;

import com.example.PruebaFS.AgroVerdeSPA.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
