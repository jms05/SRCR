package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Presentation.MainInterface;
//import se.sics.jasper.Query;
//import se.sics.jasper.SICStus;
//import se.sics.jasper.SPException;

public class Main{
	
	//private static SICStus sp;

	public static void main(String[] args){
	/*	MainInterface m = new MainInterface();
		m.setVisible(true);*/
		jms();
	}
	
	/*public static int load(String path){
		int flag=0;
		try {
			sp = new SICStus();
			sp.load(path);
			flag=1;
		} catch (SPException e) {
			System.out.println("erro");
			flag=0;
		}
		return flag;
	}*/
	static void jms(){
		//conheci_incerto c = new conheci_incerto("42", "conas", null, null);
		ArrayList<String> ar  = new ArrayList<>();
		ar.add("sao_joao");
		ar.add("sao_antonio");
		ar.add("sao_maria");
		conheci_impreciso c =new conheci_impreciso("40", "cardio", "sao_joao", "porto", null, null, ar);
		ArrayList<String> s  =c.getProlog();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String s1 = (String) it.next();
			System.out.println(s1);
		}
		/*
		for (String string : s) {
			System.out.println("1");
			System.out.println(s);
		}*/
		
	}
	
}