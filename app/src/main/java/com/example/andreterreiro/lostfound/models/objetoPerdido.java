package com.example.andreterreiro.lostfound.models;

import java.util.Date;

public class objetoPerdido {

    public int numUser;
    public Date data;
    public String nome;
    public Categoria categoria;
    public String descricao;
    public String keywords;
    public String local;

    public objetoPerdido(){
    }

    public objetoPerdido(int numUser,Date data, String nome, Categoria categoria, String descricao, String keywords, String local){
        this.numUser = numUser;
        this.data = data;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.keywords = keywords;
        this.local = local;
    }

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
