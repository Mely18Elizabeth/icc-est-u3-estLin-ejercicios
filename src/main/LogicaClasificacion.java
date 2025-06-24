package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */

     public String invertirCadena(String texto){
        Stack<Character> pila = new Stack<>();
        for (char caracter : texto.toCharArray()){
            pila.push(caracter);
        }

        StringBuilder invertir = new StringBuilder();
        while (!pila .isEmpty()){
            invertir.append(pila. pop());
        }
        return invertir.toString();
     }
    

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
    
    }*/


    public boolean validarSimbolos(String simbolo){
        Stack<Character> pila= new Stack<>();
        Map<Character,Character> par = Map.of(
            ')','(',
            ']','[',
            '}','{'
        );

        for (char caracter : simbolo.toCharArray() ){
            if (par.containsValue(caracter)){
                pila.push(caracter);
            }else if(par.containsKey(caracter)){
                if (pila.isEmpty() || pila.pop() != par.get(caracter)){
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();

        while (!pila.isEmpty()) {
            int tam = pila.pop();
            while (!aux.isEmpty() && aux.peek() > tam) {
                pila.push(aux.pop());
            }
            aux.push(tam);
        }

        List<Integer> ordenado = new ArrayList<>();
        while (!aux.isEmpty()) {
            ordenado.add(aux.pop());
        }

        Collections.reverse(ordenado);
        return ordenado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> par = new LinkedList<>();
        LinkedList<Integer> impar = new LinkedList<>();

        for (int num : original) {
            if (num % 2 == 0) {
                par.add(num);
            } else {
                impar.add(num);
            }
        }
        par.addAll(impar);
        return par;
    }
}
