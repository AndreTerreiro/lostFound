package com.example.andreterreiro.lostfound.models;

import java.util.Date;

public class objetoEncontrado {

    public String nome;
    public Date data;
    public String local;
    public Categoria categoria;
    public String descricao;
    public String keywords;

    public objetoEncontrado(){
    }

    public objetoEncontrado(String nome, Date data, String local, Categoria categoria, String descricao, String keywords){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.categoria = categoria;
        this.descricao = descricao;
        this.keywords = keywords;
    }
}
