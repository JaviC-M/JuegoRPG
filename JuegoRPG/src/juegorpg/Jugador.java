/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegorpg;

/**
 * Clase que gestiona la informacion de el jugador
 * @version 1.0
 * @author Javier Cobos y Pablo José Martinez
 */
public class Jugador {

    // Atributos
    private String nombre;
    private int puntosSalud;
    private int puntosAtaque;
    private int dinero;
    private int nivel;
    private int puntosDefensa;

    /**
     * Es un constructor por parametros
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        puntosSalud = 20;
        puntosAtaque = 0;
        dinero = 2;
        nivel = 1;
        puntosDefensa = 4;

    }
    //Getters

    /**
     * Metodo get del atributo nombre
     * @return Devuelve el valor del atributo nombre
     */
    public String getNombre() {
        return nombre;

    }

    /**
     * Metodo get del atributo puntosSalud
     * @return Devuelve el valor del atributo puntosSalud
     */
    public int getPuntosSalud() {
        return puntosSalud;
    }

    /**
     * Metodo get del atributo puntosAtaque
     * @return Devuelve el valor del atributo puntoAtaque
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * Metodo get del atributo dinero
     * @return Devuelve el valor del atributo dinero
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Metodo get del atributo nivel
     * @return Devuelve el valor del atributo nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Metodo get del atributo puntosDefensa
     * @return Devuelve el valor del atributo puntosDefensa
     */
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    //setters
    /**
     * Metodo set del atributo nombre
     * @param nombre jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    /**
     * Metodo set del atributo puntosSalud
     * @param puntosSalud jugador
     */
    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;

    }

    /**
     * Metodo set del atributo puntosAtaque
     * @param puntosAtaque jugador
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;

    }

    /**
     * Metodo set del atributo dinero
     * @param dinero jugador
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Metodo set del atributo nivel
     * @param nivel jugador
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Metodo set del atributo puntosDefensa
     * @param puntosDefensa jugador
     */
    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    /**
     * Metodo toString de clase jugador
     * @return Devuelve el valor de todos los atributos de la clase jugador
     */
    @Override
    public String toString() {
        return "ClaseJugador(" + "nombre=" + nombre + ", puntosSalud=" + puntosSalud + ", puntosAtaque=" + puntosAtaque + ", dinero=" + dinero + ", nivel=" + nivel + ", puntosDefensa=" + puntosDefensa + ")";

    }

    /**
     * Metodo void generar fuerza jugador aleatoriamente
     */
    public void calcularFuerzaInicial() {
        puntosAtaque = (int) (Math.random() * 10) + 5;
    }

    /**
     * Metodo void para subir de nivel
     */
    public void subirNivel() {
        nivel++;
        puntosSalud = puntosSalud + 5;
        puntosAtaque = puntosAtaque + 2;
        puntosDefensa = puntosDefensa + 1;
        System.out.println("¡Has subido al nivel " + nivel + "!");
        System.out.println("Salud aumentada en 5, Ataque aumentado en 2, Defensa aumentada en 1");
    }
}
