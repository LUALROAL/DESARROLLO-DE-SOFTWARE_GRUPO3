package com.tiendagenerica.tienda.service;

import java.util.List;    
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tiendagenerica.tienda.entity.Cliente;
import com.tiendagenerica.tienda.repository.ClienteRepository;


@Service
@Transactional
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    
    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getOne(int id){
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> getByNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public void  save(Cliente cliente){
    	clienteRepository.save(cliente);
    }

    public void delete(int id){
    	clienteRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return clienteRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return clienteRepository.existsByNombre(nombre);
    } 

    public boolean existsByCedula(String cedula){
        return clienteRepository.existsByCedula(cedula);
    } 
    
}
