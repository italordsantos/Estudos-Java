/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata;

import aula_07_0605_Outros.AnimalAbstract;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italo
 */
public class ClasseDeTeste extends ClasseAbstrata implements NewInterface, NewInterface1 {

    @Override
    public boolean cadastrar(AnimalAbstract obj) {
        System.out.println("-- cadastrar --");
        return true;
    }

    @Override
    public boolean alterar(Object obj) {
        System.out.println("-- alterar --");
        return true;
    }

    @Override
    public boolean remover(Object obj) {
        System.out.println("-- remover --");
        return true;
    }

    @Override
    public List<Object> listar() {
        System.out.println("-- listar --");
        return new ArrayList<>();
    }

    @Override
    public void printaMensagem(String mensage) {
        System.out.println("-- printar mensagem --");
    }

    @Override
    void printaMensagemNaTela() {
        System.out.println("Agora sim funcionou essa bagaça");
    }

    @Override
    public void printaOutraMensagem() {
        System.out.println("Mensagem da classe abstrata foi substituida");
    }
    
}
