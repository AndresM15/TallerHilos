
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoma
 */
public class Atleta extends Thread{
    private String nombre;
    private int velocidad; // Velocidad por iteración (kms/segundo)
    private int distanciaRecorrida = 0; // Distancia recorrida por el atleta
    private static final int META = 10000; // Meta en kms
    private static boolean carreraFinalizada = false; // Controla si la carrera ya terminó

    // Constructor
    public Atleta(String nombre) {
        this.nombre = nombre;
        this.velocidad = new Random().nextInt(1000) + 1; // Velocidad aleatoria entre 1 y 1000
    }

    // Método run: simula el avance del atleta
    @Override
    public void run() {
        System.out.println(nombre + " comienza a correr con velocidad de " + velocidad + " kms/seg.");
        while (!carreraFinalizada && distanciaRecorrida < META) {
            distanciaRecorrida += velocidad; // Incrementa la distancia recorrida según la velocidad
            System.out.println(nombre + " ha recorrido " + distanciaRecorrida + " kms.");
            try {
                Thread.sleep(1000); // Simula un segundo
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido para " + nombre);
            }
        }
        if (!carreraFinalizada && distanciaRecorrida >= META) {
            carreraFinalizada = true;
            System.out.println("¡" + nombre + " ha cruzado la meta y es el ganador!");
        }
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the distanciaRecorrida
     */
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * @param distanciaRecorrida the distanciaRecorrida to set
     */
    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    /**
     * @return the META
     */
    public static int getMETA() {
        return META;
    }



    
    public boolean haTerminado() {
        return distanciaRecorrida >= META;
    }

  
    
}
