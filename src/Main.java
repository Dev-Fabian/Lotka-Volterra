import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        System.out.println("----------------------------------------");
        System.out.println("Willkommen zur Lotka-Volterra Simulation");
        System.out.println("Autor: Fabian");
        System.out.println("Version: 1.0.0");
        System.out.println("----------------------------------------");

        System.out.print("Startwert der Beutepopulation: ");
        double prey = scanner.nextDouble();
        double preyMinimaly = prey;
        double preyMaximaly = prey;

        System.out.print("Startwert der Räuberpopulation: ");
        double predator = scanner.nextDouble();
        double predatorMinimaly = predator;
        double predatorMaximaly = predator;

        System.out.print("Wert für alpha: ");
        double alpha = scanner.nextDouble();

        System.out.print("Wert für beta: ");
        double beta = scanner.nextDouble();

        System.out.print("Wert für gamma: ");
        double gamma = scanner.nextDouble();

        System.out.print("Wert für delta: ");
        double delta = scanner.nextDouble();

        double dt = 0.015;
        System.out.println("Festgelegter Zeitschritt: " + dt);

        System.out.print("Wert für t: ");
        double t = scanner.nextDouble();
        
        scanner.close();

        double oldtvalueoft = 0;
        FileWriter writer;
        File datei = new File("output.txt");
        try {
            writer = new FileWriter(datei);
            writer.write(oldtvalueoft + " " + prey + " " + predator);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (double i=0; i<=t; i=i+dt) {

            double oldPrey = prey;
            double oldPredator = predator;

            prey = oldPrey + dt * (alpha * oldPrey - beta * oldPrey * oldPredator);

            predator = oldPredator + dt * (-gamma * oldPredator + delta * oldPrey * oldPredator);

            if (prey < preyMinimaly) {
                preyMinimaly = prey;
            } else if (prey > preyMaximaly) {
                preyMaximaly = prey;
            }

            if (predator < predatorMinimaly) {
                predatorMinimaly = predator;
            } else if (predator > predatorMaximaly) {
                predatorMaximaly = predator;
            }

            double newvalueoft = oldtvalueoft + dt;
            oldtvalueoft = newvalueoft;

            try {
                writer = new FileWriter(datei, true);
                writer.write(newvalueoft + " " + prey + " " + predator);
                writer.write(System.getProperty("line.separator"));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println("Berechnungen erfolgreich abgeschlossen, im Projektordner befindet sich nun eine Datei 'output.txt'.");

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
    }

}