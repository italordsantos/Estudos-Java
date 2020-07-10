/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_07_0605_Outros;

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
        ArrayList<AnimalAbstract> animais = new ArrayList<>();

        animais.add(new Cachorro("Bob", 1));
        animais.add(new Ganso("Lulu", 2));
        animais.add(new Ganso("Zhyn", 3));
        animais.add(new Cachorro("Camargo", 4));
        animais.add(new Ganso("Diogo", 5));
        
        System.out.println(animais.get(4));
        for (int i = 0; i < 5; i++) {
            System.out.println(animais.get(i));
        }
        System.out.println("");
        
        System.out.println("ForEach");
        for (AnimalAbstract animal : animais) {
            animal.printa();
        }
        System.out.println("");
        
        animais.remove(2);
        
        System.out.println(animais.toString());
    }
}