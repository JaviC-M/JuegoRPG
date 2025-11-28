/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegorpg;

/**
 * Clase que gestiona la informacion de los enemigos
 * @version 1.0
 * @author Javier Cobos y Pablo José Martinez
 */
public class Enemigo {

    // Atributos
    private String nombre;
    private int puntosAtaque;
    private int puntosSalud;
    private int puntosDefensa;

    /**
     * Es un constructor por parametros
     * @param nombre nombre del enemigo
     */
    public Enemigo(String nombre) {
        this.nombre = nombre;
        this.puntosAtaque = 0;
        this.puntosSalud = 15;
        this.puntosDefensa = 0;
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
     * Metodo get del atributo puntosAtaque
     * @return Devuelve el valor del atributo puntosAtaque
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * Metodo get del atributo puntosSalud
     * @return Devuelve el valor del atributo puntosSalud
     */
    public int getPuntosSalud() {
        return puntosSalud;
    }

    /**
     * Metodo get del atributo puntosDefensa
     * @return Devuelve el valor del atributo puntosDefensa
     */
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    //Setters

    /**
     * Metodo set del atributo nombre
     * @param nombre enemigo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo set del atributo puntosAtaque
     * @param puntosAtaque enemigo
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     * Metodo set del atributo puntosSalud
     * @param puntosSalud enemigo
     */
    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    /**
     * Metodo set del atributo puntosDefensa
     * @param puntosDefensa enemigo
     */
    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    /**
     * Metodo void generar fuerza enemigo aleatoriamente
     */
    public void calcularFuerzaEnemigo() {
        this.puntosAtaque = (int) (Math.random() * 5) + 1; //Cambiarlo segun veamos como va a ser de fuerte el jugador
        this.puntosSalud = (int) (Math.random() * 10) + 5;
        this.puntosDefensa = (int) (Math.random() * 3);
    }

    /**
     * Metodo void para generar enemigo según nivel del jugador
     * @param nivelJugador nivel del jugador
     */
    public void calcularFuerzaEnemigoPorNivel(int nivelJugador) {
        int baseAtaque = 3 + (nivelJugador * 2);
        int baseSalud = 15 + (nivelJugador * 5);
        int baseDefensa = nivelJugador;
        
        this.puntosAtaque = baseAtaque + (int) (Math.random() * 5);
        this.puntosSalud = baseSalud + (int) (Math.random() * 5);
        this.puntosDefensa = baseDefensa + (int) (Math.random() * 2);
    }

    /**
     * Metodo void para generar jefe final
     */
    public void calcularFuerzaJefeFinal() {
        this.puntosAtaque = 20;
        this.puntosSalud = 80;
        this.puntosDefensa = 5;
    }

    // Metodo int aleatorio dinero

    /**
     * Metodo entero tipo int
     * @return Devuelve dinero aleatorio ganado al vencer un enemigo
     */
    public int soltarDinero() {
       return (int) (Math.random() * 10) + 5; //Devuelve entre 5 y 15 de oro por enemigo aleatoriamente
    }
}