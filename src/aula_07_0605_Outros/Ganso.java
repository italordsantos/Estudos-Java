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
public class Ganso extends Animal {

    public Ganso(String nome) {
        super(nome);
    }

    public void botarOvo() {
        System.out.println("-- botando ovo --");
    }

    public void dominarOMundo() {
        System.out.println("-- dominando --");
    }

    @Override
    public void emitirSom() {
        System.out.println("-- grasnando --");
    }

    @Override
    public void printa() {
        System.out.println(getNome() + ", o ganso");
    }
    
    
}
