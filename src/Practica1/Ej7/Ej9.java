package Practica1.Ej7;

import java.util.*;

public class Ej9 {

    public static boolean esPareja(char apertura, char cierre){
        return (((apertura == '{') && (cierre == '}')) || ((apertura == '[') && (cierre == ']')) || ((apertura == '(') && (cierre == ')')));
    }

    public static boolean estaBalanceado(String s){
        Stack<Character> pilaCaracteres = new Stack<>();
        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            char caracter = s.charAt(i);

            if ((caracter == '{') || (caracter == '[') || (caracter == '(')){
                pilaCaracteres.push(caracter);
            }
            else if ((caracter == '}') || (caracter == ']') || (caracter == ')')) {
                res = esPareja(pilaCaracteres.pop(), caracter);
                if (!res){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una cadena de caracteres para determinar si se encuentra balanceada");
        String S = s.nextLine();
        System.out.println("Esta balanceado? Respuesta = " + estaBalanceado(S));
    }
}
