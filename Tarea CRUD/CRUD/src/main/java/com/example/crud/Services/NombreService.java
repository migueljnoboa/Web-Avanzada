package com.example.crud.Services;

import com.example.crud.Entities.Nombre;
import com.example.crud.Repository.NombreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NombreService {

    private int count = 0;

    @Autowired
    private NombreRepository nombreRepository;

    private int generateId(){
        this.count++;
        return this.count;
    }
    public void addNombre(String text){
        Nombre n = new Nombre(generateId(), text);
        nombreRepository.save(n);
    }

    public List<Nombre> getNombre(){
        List<Nombre> nombres = new ArrayList<>();
        nombreRepository.findAll().forEach(nombre -> nombres.add(nombre));
        return nombres;
    }

    public Nombre getNombre(long id){
        return nombreRepository.findById(id).get();
    }

    public void deleteNombre(long id){
        nombreRepository.deleteById(id);
    }

    public void editNombre(Nombre nombre){
        nombreRepository.save(nombre);
    }

}
