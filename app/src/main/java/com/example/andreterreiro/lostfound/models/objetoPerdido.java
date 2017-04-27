package com.example.andreterreiro.lostfound.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

import io.realm.RealmObject;

public class objetoPerdido extends RealmObject{
    private int id;
    private Date data;
    private String nome;
    private String categoria;
    private String descricao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
