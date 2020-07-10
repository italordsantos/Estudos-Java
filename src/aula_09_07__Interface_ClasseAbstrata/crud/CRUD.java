/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.AnimalAbstract;
import aula_07_0605_Outros.Cachorro;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class CRUD implements InterfaceCRUD {

    private final ArrayList<AnimalAbstract> listaAnimal = new ArrayList<>();
    
    @Override
    public boolean cadastrar(AnimalAbstract animal) {
        return listaAnimal.add(animal);
    }

    @Override
    public boolean alterar(AnimalAbstract animal) {
        boolean alterou = false;
        
        for (AnimalAbstract a : listaAnimal) {
            if (animal.getId() == a.getId()) {
                a.setNome(animal.getNome());
                alterou = true;
                break;
            }
        }
        
        return alterou;
    }

    @Override
    public boolean deletar(AnimalAbstract animal) {
         for (int i = 0; i < listaAnimal.size(); i++) {
             if (animal.getId() == listaAnimal.get(i).getId()) {
                 listaAnimal.remove(i);
                 return true;
             }
         }
        
        return false;
    }

    @Override
    public AnimalAbstract pesquisar(String nome) {
        for (AnimalAbstract animal : listaAnimal) {
            if (animal.getNome().equals(nome)) {
                return animal;
            }
        }
        return new Cachorro("-1", -1);
    }

    @Override
    public ArrayList<AnimalAbstract> listarAnimais() {
        return listaAnimal;
    }
    
    
}
