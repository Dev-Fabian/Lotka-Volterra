import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LotkaVolterra {
	private double prey;
	private double predator;
	private double alpha;
	private double beta;
	private double gamma;
	private double delta;
	private double t;
	private double dt = 0.015;
	private double preyMinimaly;
    private double preyMaximaly;
    private double predatorMinimaly;
    private double predatorMaximaly;
    private double oldtvalueoft;
    private double newvalueoft;
    private double oldPrey;
    private double oldPredator;
	
	public LotkaVolterra(double alpha, double beta, double gamma, double delta, double t, double prey, double predator) {
		super();
		setAlpha(alpha);
		setBeta(beta);
		setGamma(gamma);
		setDelta(delta);
		setT(t);
		setPrey(prey);
		setPredator(predator);
		preyMinimaly = prey;
	    preyMaximaly = prey;
	    predatorMinimaly = predator;
        predatorMaximaly = predator;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public void setT(double t) {
		this.t = t;
	}
	
	public void setPrey(double prey) {
		this.prey = prey;
	}
	
	public void setPredator(double predator) {
		this.predator = predator;
	}
	
	public void simulateLotkaVolterra() {
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

            oldPrey = prey;
            oldPredator = predator;

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

            newvalueoft = oldtvalueoft + dt;
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

		
	}
	
	
	
	

}
