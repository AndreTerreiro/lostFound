package com.example.andreterreiro.lostfound.models;

public class User {

    public int nUtilizador;
    public String nome;
    public Email email;
    public String password;
    public String tipoConta;
    public objetoPerdido[]objPerdidos;
    public objetoEncontrado[]objEncontrados;

    public User(){
    }

    public User (int nUtilizador, String nome, Email mail, String password, String tipoConta, objetoPerdido[]objPerdidos, objetoEncontrado[]objEncontrados ){
        this.nUtilizador = nUtilizador;
        this.nome = nome;
        this.email = mail;
        this.password = password;
        this.tipoConta = tipoConta;
        this.objPerdidos = objPerdidos;
        this.objEncontrados = objEncontrados;
    }
}
