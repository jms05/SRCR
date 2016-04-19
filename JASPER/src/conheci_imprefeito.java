
import java.util.ArrayList;

public class conheci_imprefeito extends conhecimento {
	private ArrayList<Integer> nulos; 
//gerar a string e mandar no contrutor
	public conheci_imprefeito(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente, String idServico, String nomeServico, String instServico, String cidadeServico,
			String diaConslta, String mesConslta, String anoConslta, String utenteConslta, String serveConslta,
			String custoConslta) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente, idServico, nomeServico, instServico,
				cidadeServico, diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		// TODO Auto-generated constructor stub
	}

	public conheci_imprefeito(String idServico, String nomeServico, String instServico, String cidadeServico) {
		super(idServico, nomeServico, instServico, cidadeServico);
		// TODO Auto-generated constructor stub
	}

	public conheci_imprefeito(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		// TODO Auto-generated constructor stub
	}

	public conheci_imprefeito(String diaConslta, String mesConslta, String anoConslta, String utenteConslta,
			String serveConslta, String custoConslta) {
		super(diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		// TODO Auto-generated constructor stub
	}

	public conheci_imprefeito() {
		// TODO Auto-generated constructor stub
	}

//exception(utente(Id,Nome,Idade,Morada)):- 
//	exception(utente(Id,Nome,Idade,xpto1)).
	
//exception(servico(Id,Desc,Inst,Cid)) :-
//	exception(serico(xpto3,Desc,Inst,Cid)).	
	
//exception(utente(Id,Nome,Idade,Morada)):- 
//	exception(utente(Id,Nome,Idade,xpto1)).

//consulta: Ano,Mes,Dia, IdUtente, IdServ, Custo,  -> {V,F}
	@Override
	public ArrayList<String> getProlog() {
		ArrayList<String> ret = super.getProlog();
		String add=null;
		if(super.getPredicado().equals(CONSULTA)){
			add="exception("+super.getPredicado()+"(A,M,D,IDU,IDS,CU)):- excecao("+super.getPredicado()+"("+
					super.getAnoConslta()+","+super.getMesConslta()+","+super.getDiaConslta()+
					super.getUtenteConslta()+","+super.getServeConslta()+","
					+super.getCustoConslta()+")).";
		}else{
			if(super.getPredicado().equals(SERVICO)){
				add="exception("+super.getPredicado()+"(ID,D,INT,C)):- excecao("+super.getPredicado()+"("+
						super.getIdServico()+","+super.getNomeServico()+","+super.getInstServico()+
						super.getCidadeServico()+")).";
			}else{
				if(super.getPredicado().equals(UTENTE)){
					add="exception("+super.getPredicado()+"(ID,N,I,M)):- excecao("+super.getPredicado()+"("+
							super.getIdUtente()+","+super.getNomeUtente()+","+super.getIdadeUtente()+
							super.getMoradaUtente()+")).";
				//	ret=UTENTE+"("+diaConslta+","+mesConslta+","+anoConslta+","+utenteConslta+","+serveConslta+","+custoConslta+").";
				}
			}
		}
		
		if(ret!=null){
			ret.add(add);
		}
		return ret;
	}
	

}
