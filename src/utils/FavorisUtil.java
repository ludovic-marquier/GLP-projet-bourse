package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dataClasses.Societe;

public class FavorisUtil {
	
	public FavorisUtil() {
		
	}
	
	public void add(Societe societe) {
		
	}
	
	public ArrayList<String> getFavoris() {
		String csvFile = "/data/favoris.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

		return null;
	}
	
	
	

}
