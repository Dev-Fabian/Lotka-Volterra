import java.util.Scanner;

public class Main {
	

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        System.out.println("----------------------------------------");
        System.out.println("Willkommen zur Lotka-Volterra Simulation");
        System.out.println("Autor: Fabian");
        System.out.println("Version: 2.0.0");
        System.out.println("----------------------------------------");
        
        System.out.print("Wert für alpha: ");
        double alpha = scanner.nextDouble();
        System.out.print("Wert für beta: ");
        double beta = scanner.nextDouble();
        System.out.print("Wert für gamma: ");
        double gamma = scanner.nextDouble();
        System.out.print("Wert für delta: ");
        double delta = scanner.nextDouble();
        System.out.print("Wert für t: ");
        double t = scanner.nextDouble();
        System.out.print("Startanzahl der Beutetiere: ");
        double prey = scanner.nextDouble();
        System.out.print("Startanzahl der Räubertiere: ");
        double predator = scanner.nextDouble();
        
        scanner.close();

       LotkaVolterra lotkaVolterre = new LotkaVolterra(alpha, beta, gamma, delta, t, prey, predator);
       lotkaVolterre.simulateLotkaVolterra();
       lotkaVolterre.showPlotSettings();
        
        

    }

}