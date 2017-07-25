package com.example.andreterreiro.lostfound.models;

public class objetoEncontrado {

    public String nome;
    public String data;
    public String local;
    public String categoria;
    public String descricao;
    public String keywords;

    public objetoEncontrado(){
    }

    public objetoEncontrado(String nome, String data, String local, String categoria, String descricao, String keywords){
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
