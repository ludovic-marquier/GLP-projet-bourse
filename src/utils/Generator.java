package utils;

import java.util.Random;

public class Generator {
	
	private static String[] Beginning = {"Maf", "Tr", "Bou", "Lot","Xer","Yoof","Ray","Azur", "Cro", "Jar", "Bre", "Gun"};
	
	private static String[] Middle = {"air", "ir", "es", "or", "lo","ed","em","ur", "arc", "or", "grap"};
	
	private static String[] End = {"ix", "ax", "", "al"," inc", " corp", "sla"};
	
	private static String[] secteurs= {"automobile","alimentaire", "informatique","transport","vestimentaire",
			"telecom","divertissement","sante","banque","energy","assurance"};
	
	private Random rnd;
	
	
	public Generator() {
		
	}
	
	public String generateName() {
		
		Random rand = new Random();
		
		return Beginning[rand.nextInt(Beginning.length)] + 
	            Middle[rand.nextInt(Middle.length)]+
	            End[rand.nextInt(End.length)];
	}
	
	
	
	public String generateId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		rnd = new Random();
		
		 while (salt.length() < 6) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * alphabet.length());
	            salt.append(alphabet.charAt(index));
	        }
	        String saltStr = salt.toString();
		
		return saltStr;
	}
	
	
	public long generateCapital() {
		rnd = new Random();
		long x = 500000000L;
		long y = 100000000000L;
		long number = x+((long)(rnd.nextDouble()*(y-x)));
		return number;
	}
	
	
	public String generateSecteur() {
		Random rand = new Random();
		return secteurs[rand.nextInt(secteurs.length)];
	}
	
	public int generateEvenement() {
		rnd = new Random();
		int result = rnd.nextInt(100-1)+1;
		return result;
	}
	
	public double generateRVariation() {
		return -1.0 + (1.0 - (-1.0)) * new Random().nextDouble();
	}
	

}
