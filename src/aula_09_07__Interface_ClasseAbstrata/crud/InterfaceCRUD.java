/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.AnimalAbstract;
import aula_07_0605_Outros.Cachorro;
import aula_07_0605_Outros.Ganso;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public interface InterfaceCRUD {
    
    /*
    Create
    Read
    Update
    Delete
    */
    
    /**
     * Cadastrar o animal na lista
     * 
     * @param animal animal a ser cadastrado
     * @return verdadeiro caso seja cadastrado com sucesso, e falso o oposto
     */
    boolean cadastrar(AnimalAbstract animal);
    
    /**
     * Alterar as informações do animal
     * 
     * @param id id do animal
     * @param nome novo nome do animal
     * @return verdadeira caso seja alterado com sucesso, e falso o oposto
     */
    boolean alterar(int id, String nome);
    
    /**
     * 
     * @param id id do animal que será removido da lista
     * @return 
     */
    boolean deletar(int id);
    
    /**
     * 
     * @param nome
     * @return 
     */
    AnimalAbstract pesquisar(String nome);
    
    /**
     * 
     * @return 
     */
    ArrayList<AnimalAbstract> listarAnimais();
}
