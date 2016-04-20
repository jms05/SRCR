package src;

import java.util.ArrayList;

public class conheci_interdito extends conheci_incerto {

	public conheci_interdito(String idServico, String nomeServico, String instServico, String cidadeServico) {
		super(idServico, nomeServico, instServico, cidadeServico);
		// TODO Auto-generated constructor stub
	}

	public conheci_interdito(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		// TODO Auto-generated constructor stub
	}

	public conheci_interdito(String anoConslta, String mesConslta, String diaConslta, String utenteConslta,
			String serveConslta, String custoConslta) {
		super(anoConslta, mesConslta, diaConslta, utenteConslta, serveConslta, custoConslta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> getProlog() {
		ArrayList<String> ant =  super.getProlog();
		int[] nulos = super.getNulos();
		String[] nulosstr = super.getNulstr();
		for (int i = 0; i < nulos.length; i++) {
			if(nulos[i]==1){
				String nulo = "nulo("+nulosstr[i]+").";
				ant.add(nulo);
			}
		}
		
		
		return ant;
	}
	

}
