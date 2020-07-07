/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author italo
 */
public class Gato {

    /*
     * variavel global
     */
    String nome;
    
    /*
     * nome variavel local
     */
    public Gato(String nome) {
        this.nome = nome;
        
    }

    public void printaNomeDoGato() {
        System.out.println("Nome do gato: " + nome);
    }
    
}
