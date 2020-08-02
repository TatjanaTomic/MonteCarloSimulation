import java.util.Random;
import org.apache.commons.math3.util.Precision;

public class Simulacija {
	
	private long brojVrijednostiUnutarKruga = 0L;
	private long ukupanBrojVrijednosti = 0L;
	private double piIzracunato = 0;
	private int brojDecimala = 15;
	private long vrijemeRacunanja = 0L;
	
	public Simulacija(int brojDecimala)
	{
		this.brojDecimala = brojDecimala;
		izracunajDecimale();
	}
	
	public Simulacija(long brojGenerisanihVrijednosti)
	{
		ukupanBrojVrijednosti = brojGenerisanihVrijednosti;
		izracunajBrojVrijednosti();
	}

	private void izracunajDecimale()
	{
		double piTacno = Precision.round(Math.PI, brojDecimala);
		double x, y;
		long startTime = System.nanoTime();
		
		while(piTacno != piIzracunato)
		{
			Random r = new Random();
			x = r.nextDouble();
			y = r.nextDouble();
			
			if(Math.sqrt(x*x + y*y) <= 1)
				brojVrijednostiUnutarKruga++;
			ukupanBrojVrijednosti++;
			
			piIzracunato = 4 * (brojVrijednostiUnutarKruga / (double) ukupanBrojVrijednosti);
		}
		
		long stopTime = System.nanoTime();
		vrijemeRacunanja = stopTime - startTime;
	}
	
	private void izracunajBrojVrijednosti()
	{
		double x, y;
		long startTime = System.nanoTime();
		
		for(long i = 0L; i < ukupanBrojVrijednosti; i++)
		{
			x = Math.random();
			y = Math.random();
			
			if(Math.sqrt(x*x + y*y) <= 1)
				brojVrijednostiUnutarKruga++;
			
			piIzracunato = 4 * (brojVrijednostiUnutarKruga / (double) ukupanBrojVrijednosti);
		}
		
		long stopTime = System.nanoTime();
		vrijemeRacunanja = stopTime - startTime;
	}

	public long GetBrojVrijednostiUnutarKruga()
	{
		return brojVrijednostiUnutarKruga;
	}
	
	public long getUkupanBrojVrijednosti()
	{
		return ukupanBrojVrijednosti;
	}
	
	public double getPiIzracunato()
	{
		return piIzracunato;
	}
	
	public long getVrijemeRacunanja()
	{
		return vrijemeRacunanja;
	}

	public int getBrojDecimala() {
		return  brojDecimala;
	}
}
