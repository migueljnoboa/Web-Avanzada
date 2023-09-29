package com.example.crud.Entities;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Nombre {

    @Id
    @Column
    private long id;
    @Column
    private String text;

    public Nombre() {
    }

    public Nombre(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEditPath(){
        return "/edit/"+this.id;
    }

    public String getDelete(){
        return "/delete/"+this.id;
    }
}

