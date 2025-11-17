/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg;

/**
 *
 * @author Powah
 */
public class ClaseJugador {

    //declaracion de atributos
    private String nombre;
    private int puntosSalud;
    private int puntosAtaque;
    private int dinero;

    //constructor por parametros
    public ClaseJugador(String nombre) {
        this.nombre = nombre;
        puntosSalud = 20;
        puntosAtaque = 0;
        dinero = 2;

    }
        //GETTING
    public String getNombre() {

        return nombre;

    }

    public int getPuntosSalud() {

        return puntosSalud;
    }

    public int getPuntosAtaque() {

        return puntosAtaque;
    }
    
    public int getDinero() {

        return dinero;
    }
    
   //setters
    
    public void setNombre(String nombre){
    this.nombre = nombre;    
     
        
    }
      public void setPuntosSalud(int puntosSalud){
    this.puntosSalud = puntosSalud;    
     
        
    }
      public void setPuntosAtaque(int puntosAtaque){
    this.puntosAtaque = puntosAtaque;    
    
    }
      
        public void setDinero(int dinero){
        this.dinero = dinero;    
        } 
        
        @Override
    public String toString(){
        return "ClaseJugador(" + "nombre=" + nombre + ", puntosSalud=" + puntosSalud + ", puntosAtaque=" + puntosAtaque + ", dinero=" + dinero +  ")";
    
    
    
    
    }
    
    public void calcularFuerzaInicial() {
        puntosAtaque = (int)(Math.random() * 10) + 1;
    }
        
    
      
}
