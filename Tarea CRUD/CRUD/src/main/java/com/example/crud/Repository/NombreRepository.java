package com.example.crud.Repository;

import com.example.crud.Entities.Nombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NombreRepository extends CrudRepository<Nombre, Long> {


}
