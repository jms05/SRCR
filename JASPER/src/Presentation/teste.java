package Presentation;

import se.sics.jasper.SICStus;
import se.sics.jasper.SPException;

public class teste {
	
	private static SICStus sp;

	public static void main(String[] args){
		MainInterface m = new MainInterface();
		m.setVisible(true);
	}
	
	public static void load(String path){
		try {
			sp = new SICStus();
			sp.load(path);
			System.out.println("loaded");
		} catch (SPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}