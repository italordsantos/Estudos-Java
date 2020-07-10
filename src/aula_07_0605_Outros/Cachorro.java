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
public class Cachorro extends AnimalAbstract {

    public Cachorro(String nome, int id) {
        super(id, nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("-- latindo --");
    }

    @Override
    public void printa() {
        System.out.println(getNome() + ", o cachorro");
    }

    @Override
    public String toString() {
        return "Cachorro{" + getNome() + '}';
    }

    
}
