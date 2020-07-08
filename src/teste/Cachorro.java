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
public class Cachorro extends Animal{

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("-- latindo --");
    }

    @Override
    public void printa() {
        System.out.println(getNome() + ", o cachorro");
    }

    
}
