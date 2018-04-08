package dataManager;

import java.util.ArrayList;

import dataClasses.Devise;

public class DeviseManager {
	
	private ArrayList<Devise> devises;
	private static String[] name = {"euro", "livre", "roupie", "yuan","yen", "dollar", "rouble"};
	private static double[] value = {1.22, 1.39, 0.015, 0.15,0.009, 1.0, 0.017};
	
	public DeviseManager() {
		devises = new ArrayList<Devise>();
	}
	
	public void createDevises() {
		for(int i =0; i<name.length;i++) {
			Devise devise = new Devise(name[i],value[i]);
			devises.add(devise);
		}
	}
	
	public ArrayList<Devise> updateDevise(){
		
		return null;
	}
	
	public ArrayList<Devise> getDevises(){
		return devises;
	}

}
