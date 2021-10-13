package com.tiendagenerica.tienda.controller;

import com.tiendagenerica.tienda.entity.Proveedor;
import com.tiendagenerica.tienda.service.ProveedorService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;

    @GetMapping("lista")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/proveedor/lista");
        List<Proveedor> proveedores = proveedorService.list();
        mv.addObject("proveedores", proveedores);
        return mv;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("nuevo")
    public String nuevo() {
        return "proveedor/nuevo";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public ModelAndView crear(@RequestParam String nombre,@RequestParam String nit,@RequestParam String tel,@RequestParam String dir,@RequestParam String ciudad) {
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(nombre)) {
            mv.setViewName("proveedor/nuevo");
            mv.addObject("error", "el nombre no puede estar vacío");
            return mv;
        }

        if (proveedorService.existsByNombre(nombre)) {
            mv.setViewName("proveedor/nuevo");
            mv.addObject("error", "ese nombre ya existe");
            return mv;
        }
        Proveedor proveedor = new Proveedor(0, nombre, nit, tel, dir, ciudad);// todo: llenar con los campos correctos
        proveedorService.save(proveedor);
        mv.setViewName("redirect:/proveedor/lista");
        return mv;
    }

    @GetMapping("/detalle/{id}")
    public ModelAndView detalle(@PathVariable("id") int id) {
        if (!proveedorService.existsById(id))
            return new ModelAndView("redirect:/proveedor/lista");
        Proveedor proveedor = proveedorService.getOne(id).get();
        ModelAndView mv = new ModelAndView("/proveedor/detalle");
        mv.addObject("proveedor", proveedor);
        return mv;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        if (!proveedorService.existsById(id))
            return new ModelAndView("redirect:/proveedor/lista");
        Proveedor proveedor = proveedorService.getOne(id).get();
        ModelAndView mv = new ModelAndView("/proveedor/editar");
        mv.addObject("proveedor", proveedor);
        return mv;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam int id, @RequestParam String nombre,@RequestParam String nit,@RequestParam String tel,@RequestParam String dir,@RequestParam String ciudad) {
        if (!proveedorService.existsById(id))
            return new ModelAndView("redirect:/proveedor/lista");
        ModelAndView mv = new ModelAndView();
        Proveedor proveedor = proveedorService.getOne(id).get();
        if (StringUtils.isBlank(nombre)) {
            mv.setViewName("proveedor/editar");
            mv.addObject("proveedor", proveedor);
            mv.addObject("error", "el nombre no puede estar vacío");
            return mv;
        }

        if (proveedorService.existsByNombre(nombre) && proveedorService.getByNombre(nombre).get().getId() != id) {
            mv.setViewName("proveedor/editar");
            mv.addObject("error", "ese nombre ya existe");
            mv.addObject("proveedor", proveedor);
            return mv;
        }

        proveedor.setNombre(nombre);
        proveedor.setNit(nit);
        proveedor.setTelefono(tel);
        proveedor.setDireccion(dir);
        proveedor.setCiudad(ciudad);
        proveedorService.save(proveedor);
        return new ModelAndView("redirect:/proveedor/lista");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/borrar/{id}")
    public ModelAndView borrar(@PathVariable("id") int id) {
        if (proveedorService.existsById(id)) {
            proveedorService.delete(id);
            return new ModelAndView("redirect:/proveedor/lista");
        }
        return null;
    }

}
