/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_07__PrimeiraTela;

/**
 *
 * @author italo
 */
public class Utils {
    
    /**
     * 
     * @param string
     * @return TRUE caso tenha apenas letras
     */
    public static boolean validarLetras(String string) {
        return string.matches("[a-zA-Z ]*");
    }
    
    /**
     * 
     * @param string
     * @return TRUE caso tenha apenas números
     */
    public static boolean validarNumeros(String string) {
        return string.matches("[0-9]*");
    }
    
    public static void main(String[] args) {
        System.out.println(!validarLetras("toto 8"));
    }
}
