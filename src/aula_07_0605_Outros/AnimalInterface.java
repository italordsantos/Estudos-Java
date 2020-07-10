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
public interface AnimalInterface {

    static final String NOME = "";
    
    void printaNome();
    
    void correr();
    
    void setNome(String nome);
    
    void emitirSom();
    
    /**
     * Printa na tela do usuário o NOME e o TIPO do animal
     */
    void printa();

}
