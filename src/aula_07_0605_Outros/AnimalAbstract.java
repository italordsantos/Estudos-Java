/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_07_0605_Outros;

/**
 *
 * @author italo
 */
public abstract class AnimalAbstract {

    private int id;
    private String nome;
    
    public AnimalAbstract(int id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public void printaNome() {
        System.out.println("Nome do animal: " + nome);
    }
    
    public void correr() {
        System.out.println("-- correndo atrás do carteiro --");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void emitirSom() {
        System.out.println("-- emitindo som --");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Printa na tela do usuário o NOME e o TIPO do animal
     */
    public void printa() {
        
    }

    @Override
    public String toString() {
        return "AnimalAbstract{" + "id=" + id + ", nome=" + nome + '}';
    }

}
