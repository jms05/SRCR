package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Presentation.MainInterface;
import se.sics.jasper.Query;
import se.sics.jasper.SICStus;
import se.sics.jasper.SPException;

public class Main{
	
	private static SICStus sp;
	private static ArrayList<String> array;
	
	public static void main(String[] args){
		MainInterface m = new MainInterface();
		m.setVisible(true);
		array=new ArrayList<String>();
	}
	
	public static int load(String path){
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
	}
	
	public static void interpretador(String s) {
		try{
			String queryS = s;
			HashMap map = new HashMap();
			Query query = sp.openPrologQuery(queryS,map);
			while (query.nextSolution()) {
				System.out.println(map.toString());
			}
			query.close();
		}catch(Exception e){
			
		}
	}
	
	public static void evolucao(ArrayList<String> termos) {
		String evol = "evolucaoS([";
		int i = 0;
		int tam = termos.size();
		for (String string2 : termos) {
			System.out.println(string2);
			String string = string2.substring(0, string2.length()-1);
			evol+=string;
			if(i+1!=tam){
				evol+=",";
			}
			i++;
		}
		evol+="]).";
		System.out.println(evol);
		interpretador(evol);
	}
	
	static void jms(){
		//conheci_incerto c = new conheci_incerto("42", "conas", null, null);
		ArrayList<String> ar  = new ArrayList<>();
		ar.add("sao_joao");
		ar.add("sao_antonio");
		ar.add("sao_maria");
		//conhecimento c = new conhecimento("", "1", "a", "199", "b");
		conheci_interdito c =new conheci_interdito("20","cardio",null,"porto");
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