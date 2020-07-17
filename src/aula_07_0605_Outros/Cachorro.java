/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_07_0605_Outros;

import aula_09_07__Interface_ClasseAbstrata.crud.Raca;

/**
 *
 * @author italo
 */
public class Cachorro {

    private int id;
    private String nome;
    private String nomeDoDono;
    private int idade;
    private char sexo;
    private Raca raca;
    
    /**
     * 
     * @param id
     * @param nome
     * @param raca
     * @param nomeDoDono
     * @param idade
     * @param sexo 
     */
    public Cachorro(String nome, int id, Raca raca, String nomeDoDono, int idade, char sexo) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.nomeDoDono = nomeDoDono;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    public void fazBuracos() {
        System.out.println("-- fazendo buraco --");
    }
    
    public void emitirSom() {
        System.out.println("-- latindo --");
    }

    public void printa() {
        System.out.println(getNome() + ", o cachorro");
    }

    public String toString() {
        return "Cachorro{" + getId() + "::" + getNome() + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDoDono() {
        return nomeDoDono;
    }

    public void setNomeDoDono(String nomeDoDono) {
        this.nomeDoDono = nomeDoDono;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
}
