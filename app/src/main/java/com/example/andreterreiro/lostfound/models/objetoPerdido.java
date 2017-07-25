package com.example.andreterreiro.lostfound.models;

public class objetoPerdido {

    public int numUser;
    public String data;
    public String nome;
    public String categoria;
    public String descricao;
    public String keywords;
    public String local;
    public String img;

    public objetoPerdido(){
    }

    public objetoPerdido(int numUser,String data, String nome, String categoria, String descricao, String keywords, String local, String img){
        this.numUser = numUser;
        this.data = data;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.keywords = keywords;
        this.local = local;
        this.img = img;
    }

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
