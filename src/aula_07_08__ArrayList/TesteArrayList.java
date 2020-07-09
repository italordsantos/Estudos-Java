/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_07_08__ArrayList;

import aula_07_0605_Outros.Animal;
import aula_07_0605_Outros.Cachorro;
import aula_07_0605_Outros.Ganso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author italo
 */
public class TesteArrayList {

    public static void main(String[] args) {
        ArrayList<Animal> listaDeAnimais = new ArrayList<>();
        
        listaDeAnimais.add(new Cachorro("Lili"));
        listaDeAnimais.add(new Ganso("Lulu"));
        listaDeAnimais.add(new Cachorro("Bili"));
        listaDeAnimais.add(new Ganso("Godofredo"));
        listaDeAnimais.add(new Cachorro("Astoufo"));
        listaDeAnimais.add(new Ganso("James"));
        listaDeAnimais.add(new Cachorro("Bob"));
        listaDeAnimais.add(new Ganso("William"));

        System.out.println("-> Lista utilizando for convencional");
        for (int posicao = 0; posicao < listaDeAnimais.size(); posicao++) {
            listaDeAnimais.get(posicao).printa();
        }
        System.out.println("");
        
        System.out.println("-> Lista utilizando ForEach");
        for (Animal animal : listaDeAnimais) {
            animal.printa();
        }
        
        System.out.println("-> Tamanho da lista");
        System.out.println(listaDeAnimais.size());
        System.out.println("");
        
        System.out.println("-> Remover um elemento da lista");
        System.out.println(listaDeAnimais.toString());
        System.out.println(listaDeAnimais.remove(5));
        System.out.println(listaDeAnimais.toString());
        System.out.println("");
        
        System.out.println("-> Saber se a lista está vazia");
        System.out.println(listaDeAnimais.isEmpty());
        System.out.println("");
        
        System.out.println("-> Remover toda a lista");
        System.out.println(listaDeAnimais.toString());
        listaDeAnimais.clear();
        System.out.println(listaDeAnimais.toString());
        System.out.println(listaDeAnimais.isEmpty());
        System.out.println("");
        
        System.out.println("-> Adicionar todos os elementos de uma nova lista");
        ArrayList<Animal> listaDeAnimaisOutra = new ArrayList<>();
        
        listaDeAnimaisOutra.add(new Cachorro("Jack"));
        listaDeAnimaisOutra.add(new Ganso("Spark"));
        listaDeAnimaisOutra.add(new Cachorro("Zeze"));
        listaDeAnimaisOutra.add(new Ganso("Camargo"));
        
        listaDeAnimais.addAll(listaDeAnimaisOutra);
        
        System.out.println(listaDeAnimais.toString());
        System.out.println("");
        
    }
    
}
