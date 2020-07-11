/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.AnimalAbstract;
import aula_07_0605_Outros.Ganso;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class CRUDGanso {

    private final ArrayList<Ganso> listaCachorros = new ArrayList<>();
    
    public boolean cadastrar(Ganso cachorro) {
        return listaCachorros.add(cachorro);
    }
    
    public boolean alterar(int id, String nome) {
        boolean alterou = false;
        
        for (AnimalAbstract a : listaCachorros) {
            if (id == a.getId()) {
                a.setNome(nome);
                alterou = true;
                break;
            }
        }
        
        return alterou;
    }

    public boolean deletar(int id) {
         for (int i = 0; i < listaCachorros.size(); i++) {
             if (listaCachorros.get(i).getId() == id) {
                 listaCachorros.remove(i);
                 return true;
             }
         }
        
        return false;
    }

    public AnimalAbstract pesquisar(String nome) {
        for (AnimalAbstract animal : listaCachorros) {
            if (animal.getNome().equals(nome)) {
                return animal;
            }
        }
        return new Ganso("-1", -1);
    }

    public ArrayList<Ganso> listarAnimais() {
        return listaCachorros;
    }
    
    
}
