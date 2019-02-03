/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.*;

/**
 *
 * @author Programacion
 */
public class Logica {

    public int Aleatorio(int pvn_Inicio, int pvn_Fin) {
        //Variables
        int vln_resultado = 0;
        Random NumeroAleatorio = new Random();

        //Inicio 
        //Se establece que el número aleatorio este dentro del valor de inicio y fin. [Inicio, Fin]
        vln_resultado = pvn_Inicio + NumeroAleatorio.nextInt(pvn_Fin - pvn_Inicio + 1);
        return vln_resultado;
    }

    private int LanzarDados() {
        //Variables
        int vln_DadoI;
        int vln_DadoII;
        int vln_suma;

        //Incio
        //Se invoca la función de aleatorio para definir el valor de ambos dados.
        vln_DadoI = Aleatorio(1, 6);
        vln_DadoII = Aleatorio(1, 6);

        //Se retorna la suma de los dados.
        vln_suma = vln_DadoI + vln_DadoII;

        return vln_suma;
    }

    public void Jugar() {
        //Variables
        int vln_suma;
        int vln_PrimerTiro;
        int vln_Punto = 0;
        boolean vlb_Seguir = true;
        Scanner entrada = new Scanner(System.in);
        String Valor;

        //Inicio
        //Se invoca la función que lanza los dados y se guarda este valor.
        vln_suma = LanzarDados();

        //Se verifica si el jugador ganó perdió o tine un punto.
        if (vln_suma == 7 || vln_suma == 11) {
            System.out.print("La suma de los dados es: " + vln_suma);
            System.out.print("\nGanó al primer tiro.");
            vlb_Seguir = false;
        } else if (vln_suma == 2 || vln_suma == 3 || vln_suma == 12) {
            System.out.print("\nEl valor de la suma de los dados es: " + vln_suma);
            System.out.print("\n\"Craps\" La casa gana.");
            vlb_Seguir = false;
        } else {
            //Se guarda el valor del primer tiro en una variable.
            vln_PrimerTiro = vln_suma;
            
            //Se le muestra al usuario la información que hay en la mesa.
            System.out.print("\nEl valor de la suma de los dados es: " + vln_suma);
            System.out.print("\nSu punto es: " + vln_suma);
            System.out.print("\nDigite cualquier tecla para seguir.\n");
            Valor = entrada.next();
            
            while (vlb_Seguir) {
                System.out.print("\nSu punto es: " + vln_suma);
                
                //Se lanza los dados todas la veces que sean necesarias.
                vln_Punto = LanzarDados();
                
                //Se verifica si el jugador ganó perdió o puede segir jugando.
                if (vln_PrimerTiro == vln_Punto) {
                    System.out.print("\nLa suma de sus dados es: " + vln_Punto);
                    System.out.println("");
                    vlb_Seguir = false;
                    break;
                } else if (vln_Punto == 7) {
                    System.out.print("\nLa suma de los dados es: 7");
                    System.out.print("\nPerdió");
                    System.out.println("");
                    vlb_Seguir = false;
                    break;
                }
                System.out.print("\nEl valor de la suma de los dados es: " + vln_Punto);
                System.out.print("\nDigite cualquier tecla para seguir.\n");
                Valor = entrada.next();
                //}

            }
        }
    }
}
