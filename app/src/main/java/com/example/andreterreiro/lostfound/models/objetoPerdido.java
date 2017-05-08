package com.example.andreterreiro.lostfound.models;

import java.util.Date;

public class objetoPerdido {
    public Date data;
    public String nome;
    public Categoria categoria;
    public String descricao;
    public String keywords;
    public String local;

    public objetoPerdido(){
    }

    public objetoPerdido(Date data, String nome, Categoria categoria, String descricao, String keywords, String local){
        this.data = data;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.keywords = keywords;
        this.local = local;
    }
}
