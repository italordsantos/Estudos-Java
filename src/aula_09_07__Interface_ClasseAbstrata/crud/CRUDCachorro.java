/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.Cachorro;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class CRUDCachorro {

    private final ArrayList<Cachorro> listaCachorros = new ArrayList<>();
    private ArrayList<Cachorro> listaCachorrosO;
    
    public String cadastrar(Cachorro cachorro) {
        if (temEsteCachorroID(cachorro.getId())) {
            return "Já existe um cachorro com este ID";
        } else if (temEsteCachorroNome(cachorro.getNome())) {
            return "Já existe um cachorro com este nome";
        } else {
            listaCachorros.add(cachorro);
            return "";
        }
    }
    
    public boolean alterar(int id, String nome) {
        boolean alterou = false;
        
        for (Cachorro a : listaCachorros) {
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

    public Cachorro pesquisarPorNome(String nome) {
        for (Cachorro animal : listaCachorros) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return new Cachorro("-1", -1);
    }
    
    public ArrayList<Cachorro> pesquisarPorNomeA(String nome) {
        listaCachorrosO = new ArrayList<>();
        for (Cachorro animal : listaCachorros) {
            if (animal.getNome().contains(nome)) {
                listaCachorrosO.add(animal);
            }
        }
        return listaCachorrosO;
    }
    
    public Cachorro pesquisarPorId(int id) {
        for (Cachorro animal : listaCachorros) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return new Cachorro("-1", -1);
    }

    public ArrayList<Cachorro> listarAnimais() {
        return listaCachorros;
    }
    
    public boolean temEsteCachorroID(int id) {
        for (Cachorro cachorro : listaCachorros) {
            if (id == cachorro.getId()) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean temEsteCachorroNome(String nome) {
        for (Cachorro cachorro : listaCachorros) {
            if (nome.equals(cachorro.getNome())) {
                return true;
            }
        }
        
        return false;
    }
}
