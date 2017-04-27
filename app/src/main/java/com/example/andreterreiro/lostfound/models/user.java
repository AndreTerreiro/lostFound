package com.example.andreterreiro.lostfound.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.RealmList;
import io.realm.RealmObject;

public class user extends RealmObject{
    private int id;
    private int nUtilizador;
    private String nome;
    private String password;
    private String tipoConta;
    private RealmList<objetoPerdido> oPerdidos;
    private RealmList<objetoEncontrado> oEncontrados;

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

    public RealmList<objetoPerdido> getoPerdidos() {
        return oPerdidos;
    }

    public void setoPerdidos(RealmList<objetoPerdido> oPerdidos) {
        this.oPerdidos = oPerdidos;
    }

    public RealmList<objetoEncontrado> getoEncontrados() {
        return oEncontrados;
    }

    public void setoEncontrados(RealmList<objetoEncontrado> oEncontrados) {
        this.oEncontrados = oEncontrados;
    }
}
