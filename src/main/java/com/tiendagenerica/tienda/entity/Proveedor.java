package com.tiendagenerica.tienda.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;
    private String ciudad;
    


    
    //getters and setters
    
    public Proveedor() {
    }


    public Proveedor(int id, String nombre, String nit, String telefono, String direccion, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String Nit) {
        this.nit = Nit;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    

}
