package com.marcelocf87.apptransito.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proprietario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;



//Lombok elimina a necessidade de utilizar os getter e setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
}
