/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.AnimalAbstract;
import aula_07_0605_Outros.Cachorro;
import aula_07_0605_Outros.Ganso;

/**
 *
 * @author italo
 */
public class Teste {

    private CRUDCachorro crudCachorro = new CRUDCachorro();
    private CRUDGanso crudGanso = new CRUDGanso();

    public static void main(String[] args) {
        new Teste();
    }

    public Teste() {

        System.out.println("-- listar inicial --");
        System.out.println(crudCachorro.listarAnimais().toString());
        System.out.println(crudGanso.listarAnimais().toString());
        System.out.println("");

        System.out.println("-- cadastrar --");
        crudCachorro.cadastrar(new Cachorro("Astoufo", 1));
        crudCachorro.cadastrar(new Cachorro("Lulu", 5));
        crudCachorro.cadastrar(new Cachorro("Bili", 7));
        crudCachorro.cadastrar(new Cachorro("Bob", 9));
        crudCachorro.cadastrar(new Cachorro("Zhyn", 3));
        crudGanso.cadastrar(new Ganso("Diego", 2));
        crudGanso.cadastrar(new Ganso("Douglas", 4));
        crudGanso.cadastrar(new Ganso("Camargo", 6));
        crudGanso.cadastrar(new Ganso("Godofredo", 8));
        crudGanso.cadastrar(new Ganso("Jorge", 10));
        System.out.println(crudCachorro.listarAnimais().toString());
        System.out.println(crudGanso.listarAnimais().toString());
        System.out.println("");

        System.out.println("-- alterar --");
        System.out.println(crudCachorro.listarAnimais().toString());
        crudCachorro.alterar(2, "Zeca");
        System.out.println(crudCachorro.listarAnimais().toString());
        System.out.println("");

        System.out.println("-- deletar --");
        System.out.println(crudCachorro.listarAnimais().toString());
        crudCachorro.deletar(5);
        System.out.println(crudCachorro.listarAnimais().toString());
        System.out.println("");

        System.out.println("-- pesquisar por nome --");
        System.out.println(crudCachorro.pesquisarPorNome("Zhyn").toString());
        System.out.println("");
        
        for (AnimalAbstract animal : crudCachorro.listarAnimais()) {
            animal.printa();
            animal.correr();
            animal.emitirSom();
            System.out.println("");
        }
    }
    
}
