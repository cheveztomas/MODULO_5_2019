/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentasbanco;

import Entidades.ClsClientes;
import Logica.LogicaCliente;
import java.util.*;

/**
 *
 * @author Programacion
 */
public class CuentasBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        ClsClientes[] vlo_Clientes;
        LogicaCliente vlo_Logica = new LogicaCliente();
        Scanner Leer;
        int vln_Dim = 0;
        int vln_Cliente = 0;
        int vln_TipoCuenta = 0;
        boolean vlb_Salir = false;
        int vln_Accion = 0;
        String vlc_String = "";
        double vln_Retiro = 0;
        int vln_Salir = 0;

        //Inicio
        //Se le pregunta al usuario la cantidad de clientes son.
        System.out.println("Digite la cantidad de clientes: ");
        try {
            Leer = new Scanner(System.in);
            vln_Dim = Leer.nextInt();
        } catch (Exception e) {
            System.out.println("Error valor ingresado no soportado: ");
        }
        vlo_Clientes = new ClsClientes[vln_Dim];

        for (int i = 0; i < vln_Dim; i++) {
            vlo_Clientes[i] = new ClsClientes();
        }

        //Se recorre el arreglo para ingresar los datos.
        for (int i = 0; i < vln_Dim; i++) {
            try {
                Leer = new Scanner(System.in);
                System.out.println("Ingrese el nombre del " + (i + 1) + "° cliente:");
                vlc_String = Leer.nextLine();
                vlo_Clientes[i].setVgc_Nombre(vlc_String);

                System.out.println("1. Cuenta corriente.");
                System.out.println("2. Cuenta ahorros");
                System.out.println("Ingrese el tipo de cuenta del " + (i + 1) + "° cliente:");
                vln_TipoCuenta = Leer.nextInt();
                while (!(vln_TipoCuenta == 1 || vln_TipoCuenta == 2)) {
                    System.out.println("1. Cuenta corriente.");
                    System.out.println("2. Cuenta ahorros");
                    System.out.println("Ingrese el tipo de cuenta del " + (i + 1) + "° cliente:");
                    try {
                        vln_TipoCuenta = Leer.nextInt();
                    } catch (Exception e) {
                        System.out.println("Valor ingresado es incorrecto.");
                    }
                }

                if (vln_TipoCuenta == 1) {
                    vlo_Clientes[i].setVgc_TipoCuenta("Cuenta corriente.");
                } else {
                    vlo_Clientes[i].setVgc_TipoCuenta("Cuenta ahorros.");
                }
                System.out.println("Ingrese el número de cuenta del " + (i + 1) + "° cliente:");
                vlo_Clientes[i].setVgn_NumeroCuenta(Leer.nextInt());

                System.out.println("Ingrese el saldo disponible del " + (i + 1) + "° cliente:");
                vlo_Clientes[i].setVgn_Saldo(Leer.nextDouble());
            } catch (Exception e) {
                System.out.println("Valor ingresado es incorrecto.");
            }
        }

        while (vlb_Salir == false) {
            //Se muestra en pantalla los clientes,
            for (int i = 0; i < vln_Dim; i++) {
                System.out.println((i + 1) + ". " + vlo_Clientes[i].getVgc_Nombre());
            }
            System.out.println("");
            System.out.println("Seleccione el número del cliente que desea analizar: ");
            try {
                Leer = new Scanner(System.in);
                vln_Cliente = (Leer.nextInt() - 1);
            } catch (Exception e) {
                System.out.println("Error el valor ingresado no es soportado.");
            }

            while (!(vln_Cliente >= 0 && vln_Cliente < vln_Dim)) {
                System.out.println("Cliente seleccionado no encontrado.");
                System.out.println("");
                System.out.println("Seleccione el número del cliente que desea analizar: ");
                try {
                    Leer = new Scanner(System.in);
                    vln_Cliente = (Leer.nextInt() - 1);
                } catch (Exception e) {
                    System.out.println("Error el valor ingresado no es soportado.");
                }
            }

            //Se mustran las opciones al usuario.
            System.out.println("");
            System.out.println("El cliente seleccionado es: " + vlo_Clientes[vln_Cliente].getVgc_Nombre());
            System.out.println("");
            System.out.println("1. Calcular interes.");
            System.out.println("2. Retirar dinero.");
            System.out.println("3. Depositar.");
            System.out.println("4. Mostrar el saldo.");
            System.out.println("5. Mostrar resumen de la cuenta.");
            System.out.println("6. Mostrar retención de la cuenta.");
            System.out.println("");
            System.out.println("Digite el número de la acción que desea hacer:");
            try {
                Leer = new Scanner(System.in);
                vln_Accion = Leer.nextInt();
            } catch (Exception e) {
                System.out.println("Erro valor ingresado es invalido.");
            }

            while (!(vln_Accion >= 1 && vln_Accion <= 6)) {
                //Se mustran las opciones al usuario.
                System.out.println("");
                System.out.println("El cliente seleccionado es: " + vlo_Clientes[vln_Cliente].getVgc_Nombre());
                System.out.println("");
                System.out.println("1. Calcular interes.");
                System.out.println("2. Retirar dinero.");
                System.out.println("3. Depositar.");
                System.out.println("4. Mostrar el saldo.");
                System.out.println("5. Mostrar resumen de la cuenta.");
                System.out.println("6. Mostrar retención de la cuenta.");
                System.out.println("");
                System.out.println("Digite el número de la acción que desea hacer:");
                try {
                    Leer = new Scanner(System.in);
                    vln_Accion = Leer.nextInt();
                } catch (Exception e) {
                    System.out.println("Error valor ingresado es invalido.");
                }
            }

            //Se modifica el arreglo según lo escogido por el usuario.
            if (vln_Accion == 1) {

                //Se muestra el interes
                System.out.println("El tipo de cuenta es: " + vlo_Clientes[vln_Cliente].getVgc_TipoCuenta());
                System.out.println("El saldo de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
                if (vlo_Clientes[vln_Cliente].getVgc_TipoCuenta() == "Cuenta corriente.") {
                    System.out.println("El interes de la cuenta es: " + vlo_Logica.CalcularInteresCuentaCorriente(vlo_Clientes[vln_Cliente].getVgn_Saldo()));
                } else {
                    System.out.println("El interes de la cuenta es: " + vlo_Logica.CalcularinteresCuentaAhorros(vlo_Clientes[vln_Cliente].getVgn_Saldo()));
                }
            } else if (vln_Accion == 2) {

                //Retirar dinero
                System.out.println("El saldo de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
                System.out.println("Dígite la cantida de dinero que desea retirar: ");
                try {
                    Leer = new Scanner(System.in);
                    vln_Retiro = Leer.nextDouble();
                } catch (Exception e) {
                    System.out.println("Valor ingresado es incorrecto.");
                }
                if (vlo_Clientes[vln_Cliente].getVgn_Saldo() < vln_Retiro) {
                    System.out.println("No se puede hacer el retiro ya que no cuenta con el saldo suficiente.");
                } else {
                    vlo_Clientes[vln_Cliente].setVgn_Saldo(vlo_Logica.RetiroCuenta(vlo_Clientes[vln_Cliente].getVgn_Saldo(), vln_Retiro));
                    System.out.println("El saldo restante de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
                }
            } else if (vln_Accion == 3) {

                //Depositar dinero
                System.out.println("El saldo de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
                System.out.println("Dígite la cantida de dinero que desea depositar: ");
                try {
                    Leer = new Scanner(System.in);
                    vln_Retiro = Leer.nextDouble();
                } catch (Exception e) {
                    System.out.println("Valor ingresado es incorrecto.");
                }
                vlo_Clientes[vln_Cliente].setVgn_Saldo(vlo_Logica.DepositoCuenta(vlo_Clientes[vln_Cliente].getVgn_Saldo(), vln_Retiro));
                System.out.println("El saldo restante de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
            } else if (vln_Accion == 4) {
                //Mostrar el saldo
                System.out.println("El saldo restante de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
            } else if (vln_Accion == 5) {
                //Resumen de la cuenta
                System.out.println("Resumen de la cuenta:");
                System.out.println("");
                System.out.println("Nombre: " + vlo_Clientes[vln_Cliente].getVgc_Nombre());
                System.out.println("Número de cuenta: " + vlo_Clientes[vln_Cliente].getVgn_NumeroCuenta());
                System.out.println("Tipo de cuenta: " + vlo_Clientes[vln_Cliente].getVgc_TipoCuenta());
                System.out.println("El saldo de la cuenta es: " + vlo_Clientes[vln_Cliente].getVgn_Saldo());
            } else if (vln_Accion == 6) {
                //Retención de monto
                System.out.println("La retención de monto es: " + vlo_Logica.RetencionMontos(vlo_Clientes[vln_Cliente].getVgn_Saldo()));
            }

            System.out.println("Si desea analisar otro cliente dígite 1, de lo contrario dígite 0");
            try {
                Leer = new Scanner(System.in);
                vln_Salir = Leer.nextInt();
            } catch (Exception e) {
                System.out.println("Error el valor ingresado es invalido.");
            }

            while (!(vln_Salir == 0 || vln_Salir == 1)) {
                System.out.println("Si desea analisar otro cliente dígite 1, de lo contrario dígite 0");
                try {
                    Leer = new Scanner(System.in);
                    vln_Salir = Leer.nextInt();
                } catch (Exception e) {
                    System.out.println("Error el valor ingresado es invalido.");
                }
            }

            if (vln_Salir == 0) {
                vlb_Salir = true;
            }
        }
    }
}
