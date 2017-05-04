package com.example.andreterreiro.lostfound.models;

public class User {
    private int id;
    private int nUtilizador;
    private String nome;
    private Email email;
    private String password;
    private String tipoConta;
    private objetoPerdido[]objPerdidos;
    private objetoEncontrado[]objEncontrados;

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

    public objetoPerdido[] getObjPerdidos() {
        return objPerdidos;
    }

    public void setObjPerdidos(objetoPerdido[] objPerdidos) {
        this.objPerdidos = objPerdidos;
    }

    public objetoEncontrado[] getObjEncontrados() {
        return objEncontrados;
    }

    public void setObjEncontrados(objetoEncontrado[] objEncontrados) {
        this.objEncontrados = objEncontrados;
    }
}
