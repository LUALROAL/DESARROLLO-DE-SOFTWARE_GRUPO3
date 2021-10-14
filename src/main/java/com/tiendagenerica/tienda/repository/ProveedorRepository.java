package com.tiendagenerica.tienda.repository;

import java.util.Optional;

import com.tiendagenerica.tienda.entity.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    Optional<Proveedor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    Optional<Proveedor> findByNit(String Nit);
    boolean existsByNit(String Nit);
}
