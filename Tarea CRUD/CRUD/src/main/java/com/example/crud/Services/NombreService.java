package com.example.crud.Services;

import com.example.crud.Entities.Nombre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NombreService {

    private int count = 0;
    private ArrayList<Nombre> arr = new ArrayList<>();

    private int generateId(){
        this.count++;
        return this.count;
    }
    public Nombre addNombre(String text){
        Nombre nombre = new Nombre(generateId(), text);
        arr.add(nombre);
        return nombre;
    }

    public ArrayList<Nombre> getNombre(){
        return this.arr;
    }

    public Nombre getNombre(int id){
        for (Nombre n : arr){
            if (n.getId() == id){
                return n;
            }
        }
        return null;
    }

    public boolean deleteNombre(int id){
        for (Nombre n : arr){
            if (n.getId() == id){
                arr.remove(n);
                return true;
            }
        }
        return false;
    }

    public boolean editNombre(Nombre newNombre){
        for (Nombre n : arr){
            if (n.getId() == newNombre.getId()){
                n.setNombre(newNombre.getNombre());
                return true;
            }
        }
        return false;
    }

}
