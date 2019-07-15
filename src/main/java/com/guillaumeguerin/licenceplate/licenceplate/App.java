package com.guillaumeguerin.licenceplate.licenceplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String[] countryCodes = {"AL","AD","AM","AT","BY","BE","BA","BG","CH","CY","CZ","DE","DK","EE","ES","FI","FR","GB","GE","GR","HU","HR","IE","IS","IT","LT","LU","LV","MC","MK","MT","NO","NL","PO","PT","RO","RU","SE","SI","SK","SM","TR","UA","VA"};
	
	/**
	 * Prints the usage of the app.
	 */
	private static void usage() {
		System.out.println("No arguments founds. Use -help to list all commands.");
	}
	
	/**
	 * Parses command line arguments.
	 * 
	 * @param args the arguments we passed to the program
	 */
	private static void parseArgs(String[] args) {
		System.out.println("Launched with arguments: " + Arrays.asList(args).stream().collect(Collectors.joining(", "))); 
		if (Arrays.stream(args).anyMatch("-help"::equals)) {
			printHelp();
		}
		Optional<String> countryArg = Arrays.stream(args).filter(s -> s.contains("-country:")).findFirst();
		if (countryArg.isPresent() && checkCountryArgument(countryArg.get())) {
			generateCountryPlate(countryArg.get());
		}
		else {
			System.out.println("Country argument is not valid. Please refer to -help");
		}
	}
	
	/**
	 * Checks if the country passed as argument is valid.
	 * 
	 * @param arg the argument
	 * @return true if valid
	 */
	private static boolean checkCountryArgument(String arg) {
		String[] args = arg.split(":");
		return Arrays.stream(countryCodes).anyMatch(args[1]::equals);
	}
	
	/**
	 * Generates random numbers in a given range.
	 * 
	 * @param min the minimum
	 * @param max the maximum
	 * @return a random number
	 */
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();
	}
	
	/**
	 * Generates random arguments to use the program without arguments.
	 */
	private static void generateRandomArgs() {
		List<String> argumentsList = new ArrayList<String>();
		int randomIndex = getRandomNumberInRange(0, countryCodes.length -1);
		argumentsList.add("-country:" + countryCodes[randomIndex]);
		parseArgs(argumentsList.toArray(new String[argumentsList.size()]));
	}
	
	/**
	 * Prints the Help.
	 */
	private static void printHelp() {
		System.out.println("Avalaible commands : ");
		System.out.println("-country with country codes in " + Stream.of(countryCodes).collect(Collectors.joining(",","[","]")));
		System.out.println("-help for help");
	}
	
	/**
	 * Generates a licence plate for a given country.
	 * 
	 * @param country the country for the licence plate
	 */
	private static void generateCountryPlate(String country) {
		switch(country) {
			case "BA":
			
			;
			case "FR":
				
			;
			case "HU":
				
			;
			default:
		}
	}
	
    public static void main( String[] args )
    {
    	System.out.println("Licence Plate Generator tool.");
    	if(args.length < 1) {
    		usage();
    		System.out.println("Generating random result...");
    		generateRandomArgs();
    	}
    	else {
    		parseArgs(args);
    	}
    }
}
