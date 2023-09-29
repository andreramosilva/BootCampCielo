package com.example.precadastro.PreCadastro.controllers.dto;

public class ClienteResponse {

    private String nome;
    private String cpf;
    private String mcc;
    private String email;
    private String cnpj;
    private String razaoSocial;
    private String nomeContato;
    private String emailContato;


    public ClienteResponse() {
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMcc() {
        return mcc;
    }

    public String getEmail() {
        return email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
