package com.example.precadastro.PreCadastro.controllers.dto;

public class ClienteRequest {

    private String flag;
    private String nome;
    private String cpf;
    private String cnpj;
    private String razaoSocial;
    private String nomeContato;
    private String emailContato;
    private String mcc;
    private String email;


    // Getters e setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public String getFlag() {
        return flag;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
