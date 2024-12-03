/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thoma
 */
public class Carrera {
      public static void main(String[] args) {
        // Crear los atletas
        Atleta[] atletas = new Atleta[5];
        atletas[0] = new Atleta("Atleta 1");
        atletas[1] = new Atleta("Atleta 2");
        atletas[2] = new Atleta("Atleta 3");
        atletas[3] = new Atleta("Atleta 4");
        atletas[4] = new Atleta("Atleta 5");

        // Iniciar los hilos (la carrera comienza)
        for (Atleta atleta : atletas) {
            atleta.start();
        }

        // Esperar a que todos los hilos terminen antes de finalizar
        for (Atleta atleta : atletas) {
            try {
                atleta.join(); // Esperar a que cada hilo termine
            } catch (InterruptedException e) {
                System.out.println("Error esperando el hilo de " + atleta.getNombre());
            }
        }

        System.out.println("\n=== RESULTADO ===");
        System.out.println("La carrera ha finalizado.");
    }
}
