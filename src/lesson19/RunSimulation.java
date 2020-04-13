package lesson19;

import java.util.Random;
/**
 *  
 * @author tim
 *
 */

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();
	
	//Country[] countries;
	//int numCountries = 0;

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line
		

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFliers = Integer.parseInt(args[5]);
		int numLoseImmunity = Integer.parseInt(args[6]);
		int numSimulations = Integer.parseInt(args[7]);
		
		Country[] countries = new Country[numSimulations];
		AnalyzeSimulation analyze = new AnalyzeSimulation();
		
		for(int i=0; i<numSimulations; i++) {
			// next we create the population and the country
			Population population;

			//population = new Population(numPeople);
			//population = new AllStayAtHome(numPeople);
			//int numEssential = numPeople/10;
			//int numOther = numPeople/20;
			//int numStayHome = numPeople - numEssential - numOther;
			population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFliers, numLoseImmunity);
			population.createPeople();

			Country country = new Country(width,height);
			// and add a link to the population in the country
			country.population = population;
			// next we place the people into the country randomly
			population.placePeople(country);
			
			countries[i] = country;

			
			if (numSimulations == 1) {
				System.out.println("Initial State of the Country");
				country.printCountry();

				System.out.println("\nTracking the Infection");
			}
			
				for(int k=0;k<MAX_TICKS; k++) {
					country.simulateOneStep();
					if (numSimulations == 1) {
					country.printState(k);
					}
					if (country.numInfected==0) {
						analyze.addStats(country.getPeakInfectedLevel(), country.getNumAffected(), country.getNumOfDays());
						break;
					}
			}
			
			if (numSimulations == 1) {
			System.out.println("\nFinal State of the Country");
			country.printCountry();
			System.out.println(" ");
			country.printStats();
			}
		}
		
		if (numSimulations > 1) {
			System.out.println("Simulating " + numSimulations + " times..." + "\n");	
			for (int i = 0; i < numSimulations; i++) {
				System.out.println("Simulation " +  (i + 1) + ":     " + countries[i].getNumOfDays() + " days     " + 
				countries[i].getNumAffected() + " total infections     " +  countries[i].getPeakInfectedLevel() + " infected at peak");
			} 
			analyze.getAverageStats(numSimulations);
		}
		
		
	}
}
