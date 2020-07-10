/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.Cachorro;
import aula_07_0605_Outros.Ganso;

/**
 *
 * @author italo
 */
public class Teste {
    
    public static void main(String[] args) {
        CRUD crud = new CRUD();
        
        crud.cadastrar(new Cachorro("Lulu", 1));
        crud.cadastrar(new Ganso("Godofredo", 2));
        
        System.out.println(crud.pesquisar("Lulu"));
    }
}
