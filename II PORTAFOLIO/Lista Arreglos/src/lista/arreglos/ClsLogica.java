/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.arreglos;

import java.util.*;

/**
 *
 * @author Tomás
 */
public class ClsLogica {

    public void Ejercicio1() {
        //Variables
        int[] vlo_Arreglo = new int[8];
        double vln_Suma = 0, vln_Pares = 0, vln_Mayores50 = 0;
        Scanner vlo_Scanner = new Scanner(System.in);
        double vln_Numeros = 0;

        //Inicio
        //Este ciclo es para rellenar el arreglo.
        for (int i = 0; i < vlo_Arreglo.length; i++) {

            System.out.println("Ingrese el valor de la " + (i + 1) + "° casilla del arreglo.\n");
            try {
                vlo_Arreglo[i] = vlo_Scanner.nextInt();
            } catch (Exception e) {
                System.out.println("El valor ingresado es invalido.");
            }
        }
        System.out.println("");
        System.out.println("Arreglo:\n");
        //Se recorre el arreglo y se le mustra el usuario el mismo.
        for (int i = 0; i < vlo_Arreglo.length; i++) {
            vln_Suma += vlo_Arreglo[i];
            if (vlo_Arreglo[i] > 50) {
                vln_Mayores50 += vlo_Arreglo[i];
            }
            if (i % 2 == 0) {
                vln_Pares += vlo_Arreglo[i];
            }
            System.out.print("|" + vlo_Arreglo[i]);
        }

        //Se muestra al usuario el resultado.
        System.out.println("|\n");
        System.out.println("La suma de los elementos del arreglo es: " + vln_Suma + "\n");
        System.out.println("La suma de los elementos pares es: " + vln_Pares + "\n");
        System.out.println("La suma de los elementos mayores a 50 es:" + vln_Mayores50 + "\n");
    }

    public void Ejercicio2() {
        //Variables
        int[] Arreglo1 = new int[5];
        int[] Arreglo2 = new int[5];
        int[] Arreglo3 = new int[5];
        Scanner Scaner = new Scanner(System.in);

        //Inicio
        System.out.println("Sumar");

        //Se recorren los arreglos para llenarlos.
        for (int i = 0; i < Arreglo3.length; i++) {
            try {
                System.out.print("=> ");
                Arreglo1[i] = Scaner.nextInt();
                System.out.print(" más ");
                Arreglo2[i] = Scaner.nextInt();
            } catch (Exception e) {
                System.out.print("Error valor incorrecto.");
            }
        }

        //Se muestra la suma de los resultados al final.
        for (int i = 0; i < Arreglo3.length; i++) {
            System.out.print("=> " + Arreglo1[i] + " + " + Arreglo2[i] + " = " + (Arreglo1[i] + Arreglo2[i] + "\n"));
        }
    }

    public void Ejercicio3() {
        //Variables
        int[] vlo_CursoA = new int[15];
        int[] vlo_CursoB = new int[15];
        int vln_CursoA = 0;
        int vln_CursoB = 0;
        Scanner scanner = new Scanner(System.in);

        //Inicio
        //Se rellena el arreglo del curso A.
        for (int i = 0; i < vlo_CursoA.length; i++) {
            System.out.println("Curso A\nNota del " + (i + 1) + "° alumno\n");
            try {
                vlo_CursoA[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error al ingresar datos.\n");
            }
            vln_CursoA += vlo_CursoA[i];
        }
        //Se rellana el arreglo del curso B.
        for (int i = 0; i < vlo_CursoB.length; i++) {
            System.out.println("Curso B\nNota del " + (i + 1) + "° alumno\n");
            try {
                vlo_CursoB[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error al ingresar datos.\n");
            }
            vln_CursoB += vlo_CursoB[i];
        }

        //Se mustra el resultado de los promedios.
        System.out.println("Promedio curso A: " + (vln_CursoA / 15));
        System.out.println("Promedio curso B: " + (vln_CursoB / 15));

        //Se muestra cual tiene mejor promedio.
        if (vln_CursoA / 15 > vln_CursoB / 15) {
            System.out.println("El curso A tiene el mayor promedio.\n");
        } else {
            System.out.println("El curso B tiene el mayor promedio.\n");
        }
    }

    public void Ejercicio4() {
        //Variables
        Scanner scanner = new Scanner(System.in);
        int[] Arreglo = new int[10];

        //Inicio
        //Se recorre el arreglo y se llena.
        for (int i = 0; i < Arreglo.length; i++) {
            System.out.println("Ingrese el " + i + "° valor del arrreglo:\n");
            try {
                Arreglo[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error el dato ingresado no se puedo leer.");
            }
        }

        //Se ordena el arreglo
        Arrays.sort(Arreglo);

        //Se recorre el arrelo y se muestra.
        System.out.println("El arreglo ordenado es: \n");
        for (int i = 0; i < Arreglo.length; i++) {
            System.out.print("|" + Arreglo[i]);
        }
        System.out.print("|\n\n");

        //Se muestra tanto el mayor como es menor.
        System.out.println("El valor mayor es: " + Arreglo[9] + "\n\n");
        System.out.println("El valor menor es: " + Arreglo[0] + "\n\n");
    }

    public void Ejercicio5() {
        //variables
        int[] AregloValores;
        int[] ArregloModa;
        int[] ArregloOredenar;
        int Auxiliar = 0;
        int Tamanio = 0;
        boolean Moda = false;
        int contador;
        Scanner scanner = new Scanner(System.in);

        //inicio
        //Se ingresa el tamaño del arreglo;
        System.out.println("Ingrese el tamaño de el arreglo:");
        try {
            Tamanio = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error el valor ingresado no es valido.");
        }
        AregloValores = new int[Tamanio];
        ArregloModa = new int[Tamanio];
        ArregloOredenar = new int[Tamanio];

        //Se recorre el arreglo para llenarlo
        for (int i = 0; i < Tamanio; i++) {
            System.out.println("Ingrese el " + (i + 1) + "° del arreglo:");
            try {
                AregloValores[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error el valor ingresado no es valido.");
            }
        }

        //Se recorre el arreglo para buscar los valores que se repiten.
        for (int i = 0; i < Tamanio; i++) {
            for (int j = 0; j < Tamanio; j++) {
                //Se verifica si se encuentra más valores repetidos en el arreglo.
                if (AregloValores[i] == AregloValores[j]) {
                    ArregloModa[i]++;
                    ArregloOredenar[i]++;
                }
            }
        }

        //Se ordena el arreglo
        Arrays.sort(ArregloOredenar);

        contador = 0;
        //Se recorre el arreglo que no está ordenado que tiene la moda.
        while (contador < Tamanio && Moda == false) {

            //Se compara el mayor valor del arreglo con valor de la moda.
            if (ArregloOredenar[Tamanio - 1] == ArregloModa[contador]) {
                Auxiliar = contador;
                Moda = true;
            }
            contador++;
        }

        //Se recorre el arreglo para mostrar este.
        for (int i = 0; i < Tamanio; i++) {
            System.out.print("|" + AregloValores[i]);
        }
        System.out.print("|\n\n");

        System.out.println("La moda es: " + AregloValores[Auxiliar]);
        System.out.println("Se repite " + ArregloOredenar[Tamanio - 1] + " veces");
    }

    public void Ejercicio6() {
        //varaibles
        String[] Personas = new String[5];
        int[] Edades = new int[5];
        Scanner scanner = new Scanner(System.in);

        //Inicio
        //se recorre el arreglo para optener la información.
        for (int i = 0; i < Personas.length; i++) {
            System.out.println("Ingrese el nombre de la" + (i + 1) + "° persona");
            try {
                Personas[i] = scanner.next();
                System.out.println("Ingrese la edad de " + Personas[i] + ":");
                Edades[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error dato ingresado no sportado.");
            }
        }

        //Mostrar los mayores de edad.
        System.out.println("Las personas mayores de edad son: \n\n");
        for (int i = 0; i < Edades.length; i++) {
            if (Edades[i] >= 18) {
                System.out.println("=> " + Personas[i]);
            }
        }
    }

    public void Ejercicio7() {
        //Variables
        String[][] Matriz;
        Scanner scanner = new Scanner(System.in);
        int dim = 0;
        //Inicio

        //Se pregunta al usuario el tamaño de la matriz deseada.
        System.out.println("Ingrese el tamaño de la matriz deseada:");
        try {
            dim = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error valor ingresado no soportado.");
        }

        Matriz = new String[dim][dim];

        //Se muestra la matriz en la consola.
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (j == i) {
                    System.out.print("| + ");
                } else {
                    System.out.print("| - ");
                }
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    public void Ejercicio8() {
        //Variables
        String[] Empleados = {"Marcos", "Appendable", "Luis", "Maria"};
        int[][] Salarios = {{540, 540, 760}, {200, 220, 250}, {760, 760, 760}, {605, 799, 810}};
        int[] SueldoTotal = new int[4];
        int[] Ordenado = new int[4];
        int aux;

        //Inicio
        for (int i = 0; i < 4; i++) {
            System.out.print("=> " + Empleados[i]);
            aux = 0;
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + Salarios[i][j]);
                aux += Salarios[i][j];
            }
            SueldoTotal[i] = aux;
            Ordenado[i] = aux;
            System.out.print(" = " + SueldoTotal[i]);
            System.out.println("");
        }

        //Se ordena el arreglo.
        Arrays.sort(Ordenado);

        //Se muestra el que más gana.
        for (int i = 0; i < 4; i++) {
            if (Ordenado[3] == SueldoTotal[i]) {
                System.out.println("El que más gana es: " + Empleados[i]);
            }
        }
    }
}
