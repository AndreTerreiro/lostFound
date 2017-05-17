package com.example.andreterreiro.lostfound.models;

public class User {

    public int nUtilizador;
    public String nome;
    public String email;
    public String password;
    public String tipoConta;

    public User(){
    }

    public User (int nUtilizador, String nome, String mail, String password, String tipoConta){
        this.nUtilizador = nUtilizador;
        this.nome = nome;
        this.email = mail;
        this.password = password;
        this.tipoConta = tipoConta;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

}
