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
		String inv  = "+"+super.getPredicado()+"(";
		if(super.getPredicado().equals(CONSULTA)){
			String[] second = new String[6];
			String[] terc = new String[6];
			second[0]="A";
			second[1]="M";
			second[2]="D";
			second[3]="IDU";
			second[4]="IDS";
			second[5]="CU";
			terc[0]=super.getAnoConslta();
			terc[1]=super.getMesConslta();
			terc[2]=super.getDiaConslta();
			terc[3]=super.getUtenteConslta();
			terc[4]=super.getServeConslta();
			terc[5]=super.getCustoConslta();
			for (int i = 0; i < second.length; i++) {
				inv+=second[i];
				if(i+1!=second.length) inv+=",";
				if(nulos[i]==1){
					second[i]=null;
				}
			}
			inv+="):: (solucoes((XX),("+super.getPredicado()+"(";
			//merdas do predicados
			for (int j = 0; j < terc.length; j++) {
				if(second[j]==null){
					inv+="XX";
				}else{
					inv+=terc[j];
				}
				if(j+1!=second.length) inv+=",";
			}
			inv+="), nao(nulo(";
			//merda nula
			inv+="XX";
			inv+="))),L ),comprimento(L,N), N==0 ).";
			ant.add(inv);
					
		}else{
			if(super.getPredicado().equals(SERVICO)){
				String[] second = new String[4];
				second[0]="ID";
				second[1]="D";
				second[2]="INT";
				second[3]="C";
				String[] terc = new String[4];
				terc[0]=super.getIdServico();
				terc[1]=super.getNomeServico();
				terc[2]=super.getInstServico();
				terc[3]=super.getCidadeServico();

				for (int i = 0; i < second.length; i++) {
					inv+=second[i];
					if(i+1!=second.length) inv+=",";
					if(nulos[i]==1){
						second[i]=null;
					}
				}
				inv+="):: (solucoes((XX),("+super.getPredicado()+"(";
				//merdas do predicados
				for (int j = 0; j < terc.length; j++) {
					if(second[j]==null){
						inv+="XX";
					}else{
						inv+=terc[j];
					}
					if(j+1!=second.length) inv+=",";
				}
				inv+="), nao(nulo(";
				//merda nula
				inv+="XX";
				inv+="))),L ),comprimento(L,N), N==0 ).";
				ant.add(inv);
			}else{
				if(super.getPredicado().equals(UTENTE)){
					String[] second = new String[4];
					second[0]="ID";
					second[1]="N";
					second[2]="I";
					second[3]="M";
					String[] terc = new String[4];
					terc[0]=super.getIdUtente();
					terc[1]=super.getNomeUtente();
					terc[2]=super.getIdadeUtente();
					terc[3]=super.getMoradaUtente();
					for (int i = 0; i < second.length; i++) {
						inv+=second[i];
						if(i+1!=second.length) inv+=",";
						if(nulos[i]==1){
							second[i]=null;
						}
					}
					inv+="):: (solucoes((XX),("+super.getPredicado()+"(";
					//merdas do predicados
					for (int j = 0; j < terc.length; j++) {
						if(second[j]==null){
							inv+="XX";
						}else{
							inv+=terc[j];
						}
						if(j+1!=second.length) inv+=",";
					}
					inv+="), nao(nulo(";
					//merda nula
					inv+="XX";
					inv+="))),L ),comprimento(L,N), N==0 ).";
					ant.add(inv);
				}
			}
		}
		
		
		return ant;
	}
	

}
