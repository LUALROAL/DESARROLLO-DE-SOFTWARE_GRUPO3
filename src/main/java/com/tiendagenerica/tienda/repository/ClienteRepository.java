package com.tiendagenerica.tienda.repository;
 

import com.tiendagenerica.tienda.entity.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    boolean existsByCedula(String cedula);

    
}
