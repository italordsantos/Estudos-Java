/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_07_0605_Outros;

import aula_09_07__Interface_ClasseAbstrata.crud.Raca;
import aula_09_07__Interface_ClasseAbstrata.crud.Sexo;

/**
 *
 * @author italo
 */
public class Cachorro {

    private int id;
    private String nomeDoCachorro;
    private String nomeDoDono;
    private double idade;
    private Sexo sexo;
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
    public Cachorro(String nome, int id, Raca raca, String nomeDoDono, double idade, Sexo sexo) {
        this.id = id;
        this.nomeDoCachorro = nome;
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
        System.out.println(getNomeDoCachorro() + ", o cachorro");
    }

    @Override
    public String toString() {
        return "Cachorro{" + id + " :: " + nomeDoCachorro + " :: " + raca + " :: " + nomeDoDono + " :: " + idade + " :: " + sexo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoCachorro() {
        return nomeDoCachorro;
    }

    public void setNomeDoCachorro(String nomeDoCachorro) {
        this.nomeDoCachorro = nomeDoCachorro;
    }

    public String getNomeDoDono() {
        return nomeDoDono;
    }

    public void setNomeDoDono(String nomeDoDono) {
        this.nomeDoDono = nomeDoDono;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Raca getRaca() {
        return raca;
    }

}
