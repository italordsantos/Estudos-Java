/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata;

import aula_07_0605_Outros.AnimalAbstract;
import java.util.List;

/**
 *
 * @author italo
 */
public interface NewInterface {
    
    boolean cadastrar(AnimalAbstract obj);
    
    boolean alterar(Object obj);
    
    boolean remover(Object obj);
    
    List<Object> listar();
}
