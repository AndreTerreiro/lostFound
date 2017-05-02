package com.example.andreterreiro.lostfound.models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private int id;
    private int nUtilizador;
    private String nome;
    private Email email;
    private String password;
    private String tipoConta;
    private RealmList<objetoPerdido> objPerdidos;
    private RealmList<objetoEncontrado> objEncontrados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnUtilizador() {
        return nUtilizador;
    }

    public void setnUtilizador(int nUtilizador) {
        this.nUtilizador = nUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public RealmList<objetoPerdido> getObjPerdidos() {
        return objPerdidos;
    }

    public void setObjPerdidos(RealmList<objetoPerdido> objPerdidos) {
        this.objPerdidos = objPerdidos;
    }

    public RealmList<objetoEncontrado> getObjEncontrados() {
        return objEncontrados;
    }

    public void setObjEncontrados(RealmList<objetoEncontrado> objEncontrados) {
        this.objEncontrados = objEncontrados;
    }
}
