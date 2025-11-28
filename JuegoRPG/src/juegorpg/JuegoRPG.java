package juegorpg;

import java.util.Scanner;

public class JuegoRPG {

// Función para mostrar el menú principal
    public static void mostrarMenu() {
        System.out.println("-------- MENÚ PRINCIPAL --------");
        System.out.println("1. Luchar contra el enemigo");
        System.out.println("2. Comprar ítems");
        System.out.println("3. Consultar tus estadísticas");
        System.out.println("4. Salir del juego");
        System.out.print("Selecciona una opción: ");
    }

// Función para mostrar el panel de compra de ítems
    public static void comprarItems(Jugador jugador) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("-------- TIENDA --------");
        System.out.println("1. Excalibur (+7 ataque) - 8 oro");
        System.out.println("2. Bastón del Arcangel (+7 ataque, +15 salud) - 20 oro");
        System.out.println("3. Hacha de batalla (+3 ataque) - 4 oro");
        System.out.println("4. Daga asesino (+1 ataque) - 2 oro");
        System.out.println("5. Frasco divino (+6 salud) - 5 oro");
        System.out.println("6. Escudo Fortificado (+12 salud, +4 defensa) - 10 oro");
        System.out.println("7. Armadura de Hierro (+7 defensa) - 5 oro");
        System.out.println("8. Salir de la tienda");
        System.out.print("Elige un ítem: ");
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                if (jugador.getDinero() >= 8) { 
                    jugador.setPuntosAtaque(jugador.getPuntosAtaque() + 7);
                    jugador.setDinero(jugador.getDinero() - 8);
                    System.out.println("Compraste Excalibur. Ataque ahora: " + jugador.getPuntosAtaque());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;

            case 2:
                if (jugador.getDinero() >= 20) { 
                    jugador.setPuntosAtaque(jugador.getPuntosAtaque() + 7);
                    jugador.setPuntosSalud(jugador.getPuntosSalud() + 15);
                    jugador.setDinero(jugador.getDinero() - 20);
                    System.out.println("Compraste el Bastón del Arcangel. Ataque ahora: "
                            + jugador.getPuntosAtaque() + ", Salud ahora: " + jugador.getPuntosSalud());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;
                
            case 3:
                if (jugador.getDinero() >= 4) { 
                    jugador.setPuntosAtaque(jugador.getPuntosAtaque() + 3);
                    jugador.setDinero(jugador.getDinero() - 4);
                    System.out.println("Compraste Hacha de batalla. Ataque ahora: " + jugador.getPuntosAtaque());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;
                
            case 4:
                if (jugador.getDinero() >= 2) { 
                    jugador.setPuntosAtaque(jugador.getPuntosAtaque() + 1);
                    jugador.setDinero(jugador.getDinero() - 2);
                    System.out.println("Compraste Daga asesino. Ataque ahora: " + jugador.getPuntosAtaque());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;

            case 5:
                if (jugador.getDinero() >= 5) { 
                    jugador.setPuntosSalud(jugador.getPuntosSalud() + 6);
                    jugador.setDinero(jugador.getDinero() - 5);
                    System.out.println("Compraste Frasco divino. Salud ahora: " + jugador.getPuntosSalud());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;
                
            case 6:
                if (jugador.getDinero() >= 10) { 
                    jugador.setPuntosSalud(jugador.getPuntosSalud() + 12);
                    jugador.setPuntosDefensa(jugador.getPuntosDefensa() + 4);
                    jugador.setDinero(jugador.getDinero() - 10);
                    System.out.println("Compraste Escudo Fortificado. Salud ahora: " + jugador.getPuntosSalud() + ", Defensa ahora: " + jugador.getPuntosDefensa());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;

            case 7:
                if (jugador.getDinero() >= 5) { 
                    jugador.setPuntosDefensa(jugador.getPuntosDefensa() + 7);
                    jugador.setDinero(jugador.getDinero() - 5);
                    System.out.println("Compraste Armadura de Hierro. Defensa ahora: " + jugador.getPuntosDefensa());
                } else {
                    System.out.println("No tienes suficiente oro.");
                }
                break;

            case 8:
                System.out.println("Saliendo de la tienda...");
                break;

            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
    
        // Función para luchar contra el enemigo con sistema de combate por turnos
    public static void lucharContraEnemigo(Jugador jugador, String[] nombresEnemigos) {
        if (jugador.getPuntosSalud() <= 0) {
            System.out.println("No puedes luchar, estás sin salud.");
            return;
        }

        Enemigo enemigo;
        boolean esJefeFinal = false;

        // Verificar si es el jefe final (nivel 5)
        if (jugador.getNivel() >= 5) {
            enemigo = new Enemigo("JEFE FINAL - Dueñas");
            enemigo.calcularFuerzaJefeFinal();
            esJefeFinal = true;
            System.out.println("¡¡¡ALERTA!!! ¡Te enfrentas al JEFE FINAL!");
        } else {
            int indice = (int) (Math.random() * nombresEnemigos.length);
            enemigo = new Enemigo(nombresEnemigos[indice]);
            enemigo.calcularFuerzaEnemigoPorNivel(jugador.getNivel());
        }

        System.out.println("--- Te enfrentas a " + enemigo.getNombre() + " ---");
        System.out.println("El enemigo tiene " + enemigo.getPuntosAtaque() + " puntos de ataque, "
                + enemigo.getPuntosSalud() + " puntos de salud y " + enemigo.getPuntosDefensa() + " puntos de defensa.");

        int turno = 1;
        while (jugador.getPuntosSalud() > 0) {
            if (enemigo.getPuntosSalud() <= 0) {
                break;
            }
            
            System.out.println("---- Turno " + turno + " ----");
            
            // Turno del jugador
            int danioJugador = jugador.getPuntosAtaque();
            int defensaEnemigo = enemigo.getPuntosDefensa();
            int danioReal = danioJugador - defensaEnemigo;
            
            if (danioReal < 0) {
                danioReal = 0;
            }
            
            enemigo.setPuntosSalud(enemigo.getPuntosSalud() - danioReal);
            System.out.println("Atacas y haces " + danioReal + " de daño (Ataque: " + danioJugador 
                    + " - Defensa enemiga: " + defensaEnemigo + ").");
            if (enemigo.getPuntosSalud() < 0) {
                System.out.println("Salud del enemigo: 0");
            } else {
                System.out.println("Salud del enemigo: " + enemigo.getPuntosSalud());
            }

            if (enemigo.getPuntosSalud() <= 0) {
                int oroGanado = enemigo.soltarDinero();
                if (esJefeFinal) {
                    oroGanado = oroGanado * 10; // El jefe final da más oro
                }
                jugador.setDinero(jugador.getDinero() + oroGanado);
                System.out.println("--- ¡Has derrotado a " + enemigo.getNombre() + "! Obtienes " + oroGanado + " de oro. ---");
                
                if (esJefeFinal) {
                    System.out.println("¡¡¡FELICIDADES!!! ¡Has derrotado al JEFE FINAL!");
                    System.out.println("¡Has completado el juego!");
                } else {
                    // Subir de nivel al derrotar enemigo
                    jugador.subirNivel();
                }
                return;
            }

            // Turno del enemigo
            int danioEnemigo = enemigo.getPuntosAtaque();
            int defensaJugador = jugador.getPuntosDefensa();
            int danioRealEnemigo = danioEnemigo - defensaJugador;
            
            if (danioRealEnemigo < 0) {
                danioRealEnemigo = 0;
            }
            
            jugador.setPuntosSalud(jugador.getPuntosSalud() - danioRealEnemigo);
            System.out.println(enemigo.getNombre() + " te golpea y te hace " + danioRealEnemigo + " de daño (Ataque: " 
                    + danioEnemigo + " - Tu defensa: " + defensaJugador + ").");
            if (jugador.getPuntosSalud() < 0) {
                System.out.println("Tu salud: 0");
            } else {
                System.out.println("Tu salud: " + jugador.getPuntosSalud());
            }

            if (jugador.getPuntosSalud() <= 0) {
                System.out.println("Has caído en combate. Tu aventura termina aquí.");
                return;
            }

            turno++;
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Introducción/Historia del juego
        System.out.println("¡Bienvenido a nuestro juego RPG creado por Javi Cobos y Pablo jose!");
        System.out.println("-------------- HISTORIA DEL JUEGO --------------");
        System.out.println("Un aventurero entra en una mazmorra en busca de respuestas...");
        System.out.println("Pero lo que se encuentra es algo que nunca llegaria a esperar");
        System.out.println("Ahora atrapado en un laberinto sin fin tendra que buscar la manera de poder salir de ahí derrotando a diferentes enemigos");

        // Introducir nombre y crear jugador
        System.out.print("Introduce el nombre de tu personaje: ");
        String nombreJugador = teclado.nextLine();
        Jugador jugador = new Jugador(nombreJugador);

        // Calcular fuerza inicial jugador
        jugador.calcularFuerzaInicial();
        System.out.println("Tu fuerza inicial es: " + jugador.getPuntosAtaque());

        // Opción de mejorar fuerza inicial del jugador
        System.out.println("-------- ¿Quieres intentar mejorar tu fuerza a cambio de 1 oro? --------");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcionMejora = teclado.nextInt();

        if (opcionMejora == 1) {
            if (jugador.getDinero() >= 1) { // Comprobar si el jugador tiene 1 o más de oro
                jugador.setDinero(jugador.getDinero() - 1); // Restamos 1 oro
                jugador.calcularFuerzaInicial(); // Calculamos nueva fuerza aleatoria
                System.out.println("¡Fuerza mejorada! Tu nueva fuerza es: " + jugador.getPuntosAtaque());
            } else {
                System.out.println("No tienes oro suficiente para mejorar tu fuerza inicial.");
            }
        } else if (opcionMejora == 2) {
            System.out.println("Has decidido quedarte con tu fuerza actual: " + jugador.getPuntosAtaque());
        } else {
            System.out.println("Opción inválida, se mantiene tu fuerza actual: " + jugador.getPuntosAtaque());
        }

        // Array de nombres de enemigos
        String[] nombresEnemigos = {"Miguel", "Javi Martin", "Guille", "Juan Diego"};

        // Creamos bucle para repetir hasta que se seleccione la opcion de salir del juego
        do {
            mostrarMenu(); // Traemos el menu en funcion
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    lucharContraEnemigo(jugador, nombresEnemigos);
                    break;

                case 2:
                    comprarItems(jugador);
                    break;

                case 3:
                    System.out.println("-------- ESTADÍSTICAS DEL JUGADOR --------");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Nivel: " + jugador.getNivel());
                    System.out.println("Salud: " + jugador.getPuntosSalud());
                    System.out.println("Ataque: " + jugador.getPuntosAtaque());
                    System.out.println("Defensa: " + jugador.getPuntosDefensa());
                    System.out.println("Oro: " + jugador.getDinero());
                    break;

                case 4:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 4); // Finalizar bucle si se preciona el numero 4
    }
}
