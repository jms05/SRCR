package src;

import java.util.ArrayList;

public class conheci_negativo extends conhecimento {

	public conheci_negativo(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente, String idServico, String nomeServico, String instServico, String cidadeServico,
			String diaConslta, String mesConslta, String anoConslta, String utenteConslta, String serveConslta,
			String custoConslta) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente, idServico, nomeServico, instServico,
				cidadeServico, diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		// TODO Auto-generated constructor stub
	}

	public conheci_negativo(String idServico, String nomeServico, String instServico, String cidadeServico) {
		super(idServico, nomeServico, instServico, cidadeServico);
		// TODO Auto-generated constructor stub
	}

	public conheci_negativo(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		// TODO Auto-generated constructor stub
	}

	public conheci_negativo(String diaConslta, String mesConslta, String anoConslta, String utenteConslta,
			String serveConslta, String custoConslta) {
		super(diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> getProlog() {
		ArrayList<String> ant =  super.getProlog();
		ArrayList<String> ret =  new ArrayList<>();
		for (String string : ant) {
			ret.add("-"+string);
		}
		return ret;
	}

	

}
