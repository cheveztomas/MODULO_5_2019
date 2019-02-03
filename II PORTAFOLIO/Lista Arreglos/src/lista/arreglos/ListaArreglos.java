/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.arreglos;

import java.util.*;

public class ListaArreglos {

    public static void main(String[] args) {
        //Varaibles
        int vln_Seleccion = 0;
        Scanner vlo_Scanner = new Scanner(System.in);
        ClsLogica Logica = new ClsLogica();

        //Inicio
        System.out.println("1. Sumas.");
        System.out.println("2. Arreglos paralelos.");
        System.out.println("3. Cursos.");
        System.out.println("4. Ordenar Arreglo.");
        System.out.println("5. Moda y Suma.");
        System.out.println("6. Mayores de edad.");
        System.out.println("7. Matriz identidad.");
        System.out.println("8. Empleados.");
        System.out.println("Seleccione cual ejercicio desea revisar:\n");
        try {
            vln_Seleccion = vlo_Scanner.nextInt();
            
            //Se verifica que el número sea correcto.
            while (!(vln_Seleccion >= 1 && vln_Seleccion <= 8)) {
                try {
                    System.out.println("Valor seleccionado incorrecto seleccione un valor entre 1 y 8.\n");
                    System.out.println("Seleccione cual ejercicio desea revisar:\n");
                    vln_Seleccion = vlo_Scanner.nextInt();
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e) {
            System.out.println("El valor ingresado es invalido.");
        }
        
        //Se invoca el metodo según la elección del usuario.
        if (vln_Seleccion == 1) {
            Logica.Ejercicio1();
        } else if (vln_Seleccion == 2) {
            Logica.Ejercicio2();
        } else if (vln_Seleccion == 3) {
            Logica.Ejercicio3();
        } else if (vln_Seleccion == 4) {
            Logica.Ejercicio4();
        } else if (vln_Seleccion == 5) {
            Logica.Ejercicio5();
        } else if (vln_Seleccion == 6) {
            Logica.Ejercicio6();
        } else if (vln_Seleccion == 7) {
            Logica.Ejercicio7();
        } else if (vln_Seleccion == 8) {
            Logica.Ejercicio8();
        }
    }

}
