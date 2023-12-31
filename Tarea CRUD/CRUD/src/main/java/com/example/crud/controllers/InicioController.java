package com.example.crud.controllers;

import com.example.crud.Entities.Nombre;
import com.example.crud.Services.NombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class InicioController {

    @Autowired
    private NombreService nombreService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String inicio(Model model){

        model = getModelInicio(model);

        return "inicio";
    }

    @PostMapping("/agregar")
    public String crearNombre(@RequestBody String nombre){
        String[] str = nombre.split("=", 2);
        if(!str[1].equalsIgnoreCase("")){
            nombreService.addNombre(str[1]);
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editNombre(@RequestBody String editNombre, @PathVariable Integer id){
        String[] str = editNombre.split("=", 2);
        Nombre n = new Nombre(id, str[1]);
        nombreService.editNombre(n);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNombre(@PathVariable String id){
        nombreService.deleteNombre(Integer.parseInt(id));
        return "redirect:/";
    }

    private Model getModelInicio(Model model){
        model.addAttribute("nombres", nombreService.getNombre());
        return model;
    }
}
