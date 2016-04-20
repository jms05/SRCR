package src;
import java.util.HashMap;

import Presentation.MainInterface;
import se.sics.jasper.Query;
import se.sics.jasper.SICStus;
import se.sics.jasper.SPException;

public class Main{
	
	private static SICStus sp;

	public static void main(String[] args){
		MainInterface m = new MainInterface();
		m.setVisible(true);
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
	
}