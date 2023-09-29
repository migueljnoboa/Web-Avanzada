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
        System.out.printf("Adding New Nombre -> text: %s\n",text);
    }

    public List<Nombre> getNombre(){
        List<Nombre> nombres = new ArrayList<>();
        nombreRepository.findAll().forEach(nombre -> nombres.add(nombre));
        System.out.print("Retrieving List of Nombres\n");
        return nombres;
    }

    public Nombre getNombre(long id){
        Nombre n = nombreRepository.findById(id).get();
        System.out.printf("Retriving Nombre -> id: %d\n", id);
        return n;
    }

    public void deleteNombre(long id){
        nombreRepository.deleteById(id);
        System.out.printf("Deleted Nombre -> id: %d\n", id);
    }

    public void editNombre(Nombre nombre){
        System.out.printf("Updated Nombre -> id: %s, text: %s\n",nombre.getId(), nombre.getText());
        nombreRepository.save(nombre);
    }

}
