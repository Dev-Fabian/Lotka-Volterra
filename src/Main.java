import java.util.Scanner;

public class Main {
	

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        System.out.println("----------------------------------------");
        System.out.println("Willkommen zur Lotka-Volterra Simulation");
        System.out.println("Autor: Fabian");
        System.out.println("Version: 2.0.0");
        System.out.println("----------------------------------------");
        
        double alpha = scanner.nextDouble();
        double beta = scanner.nextDouble();
        double gamma = scanner.nextDouble();
        double delta = scanner.nextDouble();
        double t = scanner.nextDouble();
        double prey = scanner.nextDouble();
        double predator = scanner.nextDouble();

       LotkaVolterra lotkaVolterre = new LotkaVolterra(alpha, beta, gamma, delta, t, prey, predator);
       lotkaVolterre.simulateLotkaVolterra();
        
        scanner.close();

        
        /*

        double minimaly = 0;
        if (preyMinimaly < predatorMinimaly) {
            minimaly = preyMinimaly;
        } else if (predatorMinimaly < preyMinimaly) {
            minimaly = predatorMinimaly;
        } else if (preyMinimaly == predatorMinimaly) {
            minimaly = preyMinimaly;
        }

        double maximaly = 0;
        if (preyMaximaly > predatorMaximaly) {
            maximaly = preyMaximaly;
        } else if (predatorMaximaly > preyMaximaly) {
            maximaly = predatorMaximaly;
        } else if (preyMaximaly == predatorMaximaly) {
            maximaly = preyMaximaly;
        }

        System.out.println();
        System.out.println("Empfohlene Einstellungen zum plotten:");
        System.out.println("X-Achse: 0-" + Math.round(t));
        System.out.println("Y-Achse: " + Math.round(minimaly) + "-" + Math.round(maximaly));
        
        */
    }

}