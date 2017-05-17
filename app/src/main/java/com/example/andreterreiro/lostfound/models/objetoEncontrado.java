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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
