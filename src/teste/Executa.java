/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author italo
 */
public class Executa {

    /*
     * Modificador de acesso: public, private ou protected
     * Tipo de retorno: void ou tipo dado
     * Nome do método
     * Parâmetro (s)
     */
    public int retornaCalculo(int n1, int n2) {
        int soma = 0;
        soma = n1 + n2;
        return soma;
    }

    public static void printaTexto(String texto) {
        System.out.println(texto);
    }
    
    public Executa(String texto) {
        System.out.println("Criando uma nova instancia de 'Executa'");
        System.out.println("Texto: " + texto);
    }

    public static void main(String[] args) {
        Gato gato = new Gato("Lili");
        
        gato.nome = "Nina";
        gato.printaNomeDoGato();
    }
}
