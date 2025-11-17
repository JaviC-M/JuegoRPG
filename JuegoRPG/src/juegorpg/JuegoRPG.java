package juegorpg;

import java.util.Scanner;

public class JuegoRPG {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Luchar contra el enemigo");
            System.out.println("2. Comprar ítems");
            System.out.println("3. Consultar tus estadísticas");
            System.out.println("4. Salir del juego");
            System.out.print("Selecciona una de estas opciones: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }

        } while (opcion != 4);
    }
    
}
