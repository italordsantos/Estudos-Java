/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class Executa {

    /*
     * Modificador de acesso: public, private ou protected
     * Tipo de retorno: void ou tipo dado
     * Nome do método
     * Parâmetro (s)
     */
    public int retornaCalculo(int n1, int n2) {
        int soma = 0;
        soma = n1 + n2;
        return soma;
    }

    public static void printaTexto(String texto) {
        System.out.println(texto);
    }

    public Executa(String texto) {
        System.out.println("Criando uma nova instancia de 'Executa'");
        System.out.println("Texto: " + texto);
    }

    public static void main(String[] args) {
        ArrayList<Animal> animais = new ArrayList<>();
        
        animais.add(new Animal("Bob"));
        animais.add(new Animal("Lulu"));
        animais.add(new Animal("Zhyn"));
        animais.add(new Animal("Douglas"));
        animais.add(new Animal("Diogo"));
        
        System.out.println(animais.get(4));
        for (int i = 0; i < 5; i++) {
            System.out.println(animais.get(i));
        }
        System.out.println("");
        
        System.out.println("ForEach");
        for (Animal animal : animais) {
            System.out.println(animal.getNome());
        }
        
        animais.remove(2);
        
        System.out.println(animais.toString());
    }
}
