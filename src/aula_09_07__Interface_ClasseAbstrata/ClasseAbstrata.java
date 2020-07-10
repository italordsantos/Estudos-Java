/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata;

/**
 *
 * @author italo
 */
public abstract class ClasseAbstrata {
    
    String var;
    
    abstract void printaMensagemNaTela();
    
    public void printaOutraMensagem() {
        System.out.println("Mensagem da classe abstrata.");
    }
    
}
