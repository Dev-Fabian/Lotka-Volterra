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
        
        scanner.close();

       LotkaVolterra lotkaVolterre = new LotkaVolterra(alpha, beta, gamma, delta, t, prey, predator);
       lotkaVolterre.simulateLotkaVolterra();
       lotkaVolterre.showPlotSettings();
        
        

    }

}