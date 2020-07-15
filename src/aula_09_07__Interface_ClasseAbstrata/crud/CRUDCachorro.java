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
 * C create R read U update D delete
 *
 * @author italo
 */
public class CRUDCachorro {

    /**
     * Banco de dados da nossa aplicação de teste
     */
    private final ArrayList<Cachorro> listaCachorrosBD = new ArrayList<>();

    /**
     * Lista para usar como quiser
     */
    private ArrayList<Cachorro> listaCachorrosAuxiliar;

    /**
     * Cadastra o cachorro no banco de dados
     *
     * @param cachorro cachorro a ser cadastrado
     * @return retorna VAZIO caso cadastrado com sucesso. Se houver um cachorro
     * com o, IGNORECASE, nome, ou exato id, o mesmo não será cadastrado e
     * retornará uma mensagem contendo o motivo.
     */
    public String cadastrar(Cachorro cachorro) {
        if (temEsteCachorroID(cachorro.getId())) {
            return "Já existe um cachorro com este ID";
        } else if (temEsteCachorroNome(cachorro.getNome())) {
            return "Já existe um cachorro com este nome";
        } else {
            listaCachorrosBD.add(cachorro);
            return "";
        }
    }

    /**
     * Altera o nome do cachorro
     * 
     * @param id id do cachorro que vamos alterar o nome, serve para ele pesquisar, um identificador.
     * @param nome novo nome que o cachorro terá
     * @return retorna verdadeiro caso seja alterado com sucesso
     */
    public boolean alterar(int id, String nome) {
        boolean alterou = false;

        for (Cachorro a : listaCachorrosBD) {
            if (id == a.getId()) {
                a.setNome(nome);
                alterou = true;
                break;
            }
        }

        return alterou;
    }

    /**
     * Deletar o cachorro do banco
     * 
     * @param id id do animal que será deletado
     * @return retorna verdadeiro caso deletado com sucesso, e falto caso não
     * encontre o animal que foi passo o id
     */
    public boolean deletar(int id) {
        for (int i = 0; i < listaCachorrosBD.size(); i++) {
            if (listaCachorrosBD.get(i).getId() == id) {
                listaCachorrosBD.remove(i);
                return true;
            }
        }

        return false;
    }

    public Cachorro pesquisarPorNome(String nome) {
        for (Cachorro animal : listaCachorrosBD) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return new Cachorro("-1", -1);
    }

    public ArrayList<Cachorro> searchByContainsString(String nome) {
        listaCachorrosAuxiliar = new ArrayList<>();
        
        for (Cachorro animal : listaCachorrosBD) {
            if (animal.getNome().contains(nome)) {
                listaCachorrosAuxiliar.add(animal);
                animal.printa();
            }
        }

        return listaCachorrosAuxiliar;
    }

    public Cachorro pesquisarPorId(int id) {
        for (Cachorro animal : listaCachorrosBD) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return new Cachorro("-1", -1);
    }

    public ArrayList<Cachorro> listarTodosOsAnimais() {
        return listaCachorrosBD;
    }

    public boolean temEsteCachorroID(int id) {
        for (Cachorro cachorro : listaCachorrosBD) {
            if (id == cachorro.getId()) {
                return true;
            }
        }

        return false;
    }

    public boolean temEsteCachorroNome(String nome) {
        for (Cachorro cachorro : listaCachorrosBD) {
            if (nome.equalsIgnoreCase(cachorro.getNome())) {
                return true;
            }
        }

        return false;
    }
}
