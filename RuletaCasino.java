import java.util.Random;

class Ruleta implements Runnable {
    private String colorProceso;
    private String nombre;
    private Random random = new Random();

    public Ruleta(String nombre, String colorProceso) {
        this.nombre = nombre;
        this.colorProceso = colorProceso;
    }

    @Override
    public void run() {
        String colorHilo = random.nextBoolean() ? "Rojo" : "Negro"; // Selección aleatoria de color
        System.out.println(nombre + " obtuvo: " + colorHilo);

        if (colorHilo.equals(colorProceso)) {
            System.out.println("¡" + nombre + " ha ganado!");
        }
    }
}

public class RuletaCasino {
    public static void main(String[] args) {
        Random random = new Random();
        String colorProceso = random.nextBoolean() ? "Rojo" : "Negro"; // Color del proceso principal
        System.out.println("Color de la ruleta: " + colorProceso);
        
        // Crear e iniciar los hilos
        Thread h1 = new Thread(new Ruleta("Jugador 1", colorProceso));
        Thread h2 = new Thread(new Ruleta("Jugador 2", colorProceso));
        Thread h3 = new Thread(new Ruleta("Jugador 3", colorProceso));

        h1.start();
        h2.start();
        h3.start();
    }
}

