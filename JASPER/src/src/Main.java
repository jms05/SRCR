package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Presentation.MainInterface;
import se.sics.jasper.Query;
import se.sics.jasper.SICStus;
import se.sics.jasper.SPException;
import se.sics.jasper.SPPredicate;

public class Main{
	private static SICStus sp;
	
	public static void main(String[] args){
		MainInterface m = new MainInterface();
		m.setVisible(true);
		new ArrayList<String>();
	}
	
	public static int load(String path){
		int flag=0;
		try {
			sp = new SICStus();
			sp.load(path);
			flag=1;
		} catch (Exception e) {
			flag=0;
		}
		return flag;
	}
	
	public static String interpretador(String s) {
		/*String ret="";
		try{
			String queryS = s;
			HashMap map = new HashMap();
			Query query = sp.openPrologQuery(queryS,map);
			while (query.nextSolution()) {
				ret+=map.toString();
			}
			query.close();
		}catch(Exception e){
			
		}
		return ret;*/
		StringBuilder output = new StringBuilder();
		try{
			HashMap map = new HashMap();
			Query query = sp.openPrologQuery(s, map);
			if(query.nextSolution()){
				output.append(parseSolution(map.toString()));
			}
			while(query.nextSolution()){
				output.append("\n"+parseSolution(map.toString()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return output.toString();
	}
	
	public static void evolucao(ArrayList<String> termos) {
		String evol = "demo1((evolucaoS([";
		//String evol="assert(";
		int i = 0;
		int tam = termos.size();
		for (String string2 : termos) {
			String string = string2.substring(0, string2.length()-1);
			evol+="("+string+")";
			if(i+1!=tam){
				evol+=",";
			}
			i++;
		}
		evol+="])),R).";
		System.out.println(evol);
		System.out.println(interpretador(evol));
	}
	
	private static String parseSolution(String solution) {
		StringBuilder sb = new StringBuilder();
		Boolean end = false;
		for(int i = 0; !end; i++){
			char c = solution.charAt(i);
			switch(c){
			case '{': case ',':
				sb.append(c);
				i = parseTerm(solution,sb,i+1);
				break;
			case '}':
				if(sb.charAt(1) == ' '){
					sb.deleteCharAt(1);
				}
				if(sb.charAt(sb.length()-1) == ','){
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append(c);
				end = true;
				break;
			default:
				i = parseTerm(solution,sb,i);
			}
		}
		return sb.toString();
	}
	
	private static int parseTerm(String solution, StringBuilder sb, int index) {
		StringBuilder term = new StringBuilder();
		Boolean end = false;
		Boolean ignore = false;
		for(; !end; index++){
			char c = solution.charAt(index);
			switch(c){
			case '.':
				index = parseList(solution,term,index);
				break;
			case '_':
				ignore = true;
				break;
			case ',': 
				term.append(c);
				end = true;
				break;
			case '}':
				end = true;
				break;
			default:
				if(!ignore)
					term.append(c);
			}
		}
		if(!ignore){
			sb.append(term.toString());
		}
		if(term.length()>0){
			if(term.charAt(term.length()-1) == ',')
				return index-1;
			else
				return index-2;
		}
		else return index-2;
	}

	private static  int parseList(String solution, StringBuilder sb, int index) {
		StringBuilder list = new StringBuilder();
		list.append('[');
		Boolean end = false;
		int nivel = 0;
		int hifen = 0;
		for(; !end; index++){
			char c = solution.charAt(index);
			switch(c){
			case '-':
				hifen++;
				break;
			case '.': case '[': case ']':
				break;
			case ',':
				if(hifen > 0){
					list.append('-');
					hifen--;
				}
				else list.append(',');
				break;
			case '(':
				nivel++;
				break;
			case ')':
				nivel--;
				if(nivel == 0) 
					end = true;
				break;
			default:
				list.append(c);
				break;			
			}
		}
		if(list.charAt(list.length()-1) == ','){
			list.deleteCharAt(list.length()-1);
		}
		list.append(']');
		sb.append(list.toString());
		return index-1;
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