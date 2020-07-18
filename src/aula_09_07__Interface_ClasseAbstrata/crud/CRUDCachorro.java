/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_09_07__Interface_ClasseAbstrata.crud;

import aula_07_0605_Outros.Cachorro;
import aula_10_07__PrimeiraTela.Utils;
import java.util.ArrayList;
import java.util.Collections;

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
    public boolean cadastrar(Cachorro cachorro) {
        if (validarDados(cachorro).isEmpty()) {
            return listaCachorrosBD.add(cachorro);
        }
        return false;
    }

    /**
     * Altera o nome do cachorro
     *
     * @param id id do cachorro que vamos alterar o nome, serve para ele
     * pesquisar, um identificador.
     * @param nome novo nome que o cachorro terá
     * @return retorna verdadeiro caso seja alterado com sucesso
     */
    public boolean alterar(int id, String nome) {
        boolean alterou = false;

        for (Cachorro a : listaCachorrosBD) {
            if (id == a.getId()) {
                a.setNomeDoCachorro(nome);
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
            if (animal.getNomeDoCachorro().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return null;
    }

    public ArrayList<Cachorro> searchByContainsString(String nome) {
        listaCachorrosAuxiliar = new ArrayList<>();

        for (Cachorro animal : listaCachorrosBD) {
            if (animal.getNomeDoCachorro().toLowerCase().contains(nome)
                    || animal.getNomeDoCachorro().toUpperCase().contains(nome)) {
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
        return null;
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
            if (nome.equalsIgnoreCase(cachorro.getNomeDoCachorro())) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param cachorro
     * @return VAZIO caso todos os dados sejam válidos
     */
    public String validarDados(Cachorro cachorro) {
        System.out.println("-- entrou no validar");

        if (cachorro.getNomeDoCachorro().isEmpty()) {
            return "Insira um nome para o cachorro";

        } else if (!Utils.validarLetras(cachorro.getNomeDoCachorro())) {
            return "O nome do animal contém caracteres inválidos";

        } else if (temEsteCachorroID(cachorro.getId())) {
            return "Já existe um cachorro com este ID";

        } else if (temEsteCachorroNome(cachorro.getNomeDoCachorro())) {
            return "Já existe um cachorro com este nome";
            
        } else if (cachorro.getNomeDoDono().isEmpty()) {
            return "Insira um nome para o (a) dono (a)";
            
        } else if (Utils.validarNumeros(cachorro.getNomeDoDono())) {
            return "O nome do dono contém caracteres inválidos";
            
        }
        return "";

    }
}
