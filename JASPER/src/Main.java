import java.util.HashMap;

import se.sics.jasper.Query;
import se.sics.jasper.SICStus;

public class Main{
	
	public static void main(String[] args) throws NoSuchMethodException, InterruptedException, Exception {
		String queryS = "pai(jose,X).";
		SICStus sp = new SICStus();
		sp.load("C://Users//Octávio//Desktop//SRCR//ficha01.pl");
		
		HashMap map = new HashMap();
		Query query = sp.openPrologQuery(queryS,map);
		
		while (query.nextSolution()) {
			System.out.println(map.toString());
		}
		query.close();		
	}
	
}