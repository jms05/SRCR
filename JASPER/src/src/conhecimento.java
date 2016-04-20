package src;

import java.util.ArrayList;

public class conhecimento {

	private String predicado;
	
	//daddos utente
	private String idUtente;
	private String nomeUtente;
	private String idadeUtente;
	private String moradaUtente;
	//serviço
	private String idServico;
	private String nomeServico;
	private String instServico;
	private String cidadeServico;
	//onsulta
	private String diaConslta;
	private String mesConslta;
	private String anoConslta;
	private String utenteConslta;
	private String serveConslta;
	private String custoConslta;
	
	public static final String CONSULTA = "consulta";
	public static final String SERVICO = "servico";
	public static final String UTENTE = "utente";
	
	public conhecimento(String predicado, String idUtente, String nomeUtente, String idadeUtente, String moradaUtente,
			String idServico, String nomeServico, String instServico, String cidadeServico, String diaConslta,
			String mesConslta, String anoConslta, String utenteConslta, String serveConslta, String custoConslta) {
		super();
		this.predicado = predicado;
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.idadeUtente = idadeUtente;
		this.moradaUtente = moradaUtente;
		this.idServico = idServico;
		this.nomeServico = nomeServico;
		this.instServico = instServico;
		this.cidadeServico = cidadeServico;
		this.diaConslta = diaConslta;
		this.mesConslta = mesConslta;
		this.anoConslta = anoConslta;
		this.utenteConslta = utenteConslta;
		this.serveConslta = serveConslta;
		this.custoConslta = custoConslta;
	}

	
	
	public conhecimento(String idServico, String nomeServico, String instServico, String cidadeServico) {
		super();
		this.predicado=SERVICO;
		this.idServico = idServico;
		this.nomeServico = nomeServico;
		this.instServico = instServico;
		this.cidadeServico = cidadeServico;
	}



	public conhecimento(String predicado, String idUtente, String nomeUtente, String idadeUtente, String moradaUtente) {
		super();
		this.predicado = UTENTE;
		this.idUtente = idUtente;
		this.nomeUtente = nomeUtente;
		this.idadeUtente = idadeUtente;
		this.moradaUtente = moradaUtente;
	}

	


	public conhecimento(String diaConslta, String mesConslta, String anoConslta, String utenteConslta,
			String serveConslta, String custoConslta) {
		super();
		this.predicado = CONSULTA;
		this.diaConslta = diaConslta;
		this.mesConslta = mesConslta;
		this.anoConslta = anoConslta;
		this.utenteConslta = utenteConslta;
		this.serveConslta = serveConslta;
		this.custoConslta = custoConslta;
	}



	public ArrayList<String> getProlog(){
		String ret =null;
		ArrayList<String> arr = null;
		if(this.predicado.equals(CONSULTA)){
			ret = CONSULTA+"("+idUtente+","+nomeUtente+","+idadeUtente+","+moradaUtente+").";
		}else{
			if(this.predicado.equals(SERVICO)){
				ret=SERVICO+"("+idServico+","+nomeServico+","+instServico+","+cidadeServico+").";
			}else{
				if(this.predicado.equals(UTENTE)){
					ret=UTENTE+"("+diaConslta+","+mesConslta+","+anoConslta+","+utenteConslta+","+serveConslta+","+custoConslta+").";
				}
			}
		}
		
		if(ret!=null){
			arr=new ArrayList<>();
			arr.add(ret);
		}
		return arr;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoConslta == null) ? 0 : anoConslta.hashCode());
		result = prime * result + ((cidadeServico == null) ? 0 : cidadeServico.hashCode());
		result = prime * result + ((custoConslta == null) ? 0 : custoConslta.hashCode());
		result = prime * result + ((diaConslta == null) ? 0 : diaConslta.hashCode());
		result = prime * result + ((idServico == null) ? 0 : idServico.hashCode());
		result = prime * result + ((idUtente == null) ? 0 : idUtente.hashCode());
		result = prime * result + ((idadeUtente == null) ? 0 : idadeUtente.hashCode());
		result = prime * result + ((instServico == null) ? 0 : instServico.hashCode());
		result = prime * result + ((mesConslta == null) ? 0 : mesConslta.hashCode());
		result = prime * result + ((moradaUtente == null) ? 0 : moradaUtente.hashCode());
		result = prime * result + ((nomeServico == null) ? 0 : nomeServico.hashCode());
		result = prime * result + ((nomeUtente == null) ? 0 : nomeUtente.hashCode());
		result = prime * result + ((predicado == null) ? 0 : predicado.hashCode());
		result = prime * result + ((serveConslta == null) ? 0 : serveConslta.hashCode());
		result = prime * result + ((utenteConslta == null) ? 0 : utenteConslta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		conhecimento other = (conhecimento) obj;
		if (anoConslta == null) {
			if (other.anoConslta != null)
				return false;
		} else if (!anoConslta.equals(other.anoConslta))
			return false;
		if (cidadeServico == null) {
			if (other.cidadeServico != null)
				return false;
		} else if (!cidadeServico.equals(other.cidadeServico))
			return false;
		if (custoConslta == null) {
			if (other.custoConslta != null)
				return false;
		} else if (!custoConslta.equals(other.custoConslta))
			return false;
		if (diaConslta == null) {
			if (other.diaConslta != null)
				return false;
		} else if (!diaConslta.equals(other.diaConslta))
			return false;
		if (idServico == null) {
			if (other.idServico != null)
				return false;
		} else if (!idServico.equals(other.idServico))
			return false;
		if (idUtente == null) {
			if (other.idUtente != null)
				return false;
		} else if (!idUtente.equals(other.idUtente))
			return false;
		if (idadeUtente == null) {
			if (other.idadeUtente != null)
				return false;
		} else if (!idadeUtente.equals(other.idadeUtente))
			return false;
		if (instServico == null) {
			if (other.instServico != null)
				return false;
		} else if (!instServico.equals(other.instServico))
			return false;
		if (mesConslta == null) {
			if (other.mesConslta != null)
				return false;
		} else if (!mesConslta.equals(other.mesConslta))
			return false;
		if (moradaUtente == null) {
			if (other.moradaUtente != null)
				return false;
		} else if (!moradaUtente.equals(other.moradaUtente))
			return false;
		if (nomeServico == null) {
			if (other.nomeServico != null)
				return false;
		} else if (!nomeServico.equals(other.nomeServico))
			return false;
		if (nomeUtente == null) {
			if (other.nomeUtente != null)
				return false;
		} else if (!nomeUtente.equals(other.nomeUtente))
			return false;
		if (predicado == null) {
			if (other.predicado != null)
				return false;
		} else if (!predicado.equals(other.predicado))
			return false;
		if (serveConslta == null) {
			if (other.serveConslta != null)
				return false;
		} else if (!serveConslta.equals(other.serveConslta))
			return false;
		if (utenteConslta == null) {
			if (other.utenteConslta != null)
				return false;
		} else if (!utenteConslta.equals(other.utenteConslta))
			return false;
		return true;
	}


	public String getPredicado() {
		return predicado;
	}


	public void setPredicado(String predicado) {
		this.predicado = predicado;
	}


	public String getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}


	public String getNomeUtente() {
		return nomeUtente;
	}


	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}


	public String getIdadeUtente() {
		return idadeUtente;
	}


	public void setIdadeUtente(String idadeUtente) {
		this.idadeUtente = idadeUtente;
	}


	public String getMoradaUtente() {
		return moradaUtente;
	}


	public void setMoradaUtente(String moradaUtente) {
		this.moradaUtente = moradaUtente;
	}


	public String getIdServico() {
		return idServico;
	}


	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}


	public String getNomeServico() {
		return nomeServico;
	}


	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}


	public String getInstServico() {
		return instServico;
	}


	public void setInstServico(String instServico) {
		this.instServico = instServico;
	}


	public String getCidadeServico() {
		return cidadeServico;
	}


	public void setCidadeServico(String cidadeServico) {
		this.cidadeServico = cidadeServico;
	}


	public String getDiaConslta() {
		return diaConslta;
	}


	public void setDiaConslta(String diaConslta) {
		this.diaConslta = diaConslta;
	}


	public String getMesConslta() {
		return mesConslta;
	}


	public void setMesConslta(String mesConslta) {
		this.mesConslta = mesConslta;
	}


	public String getAnoConslta() {
		return anoConslta;
	}


	public void setAnoConslta(String anoConslta) {
		this.anoConslta = anoConslta;
	}


	public String getUtenteConslta() {
		return utenteConslta;
	}


	public void setUtenteConslta(String utenteConslta) {
		this.utenteConslta = utenteConslta;
	}


	public String getServeConslta() {
		return serveConslta;
	}


	public void setServeConslta(String serveConslta) {
		this.serveConslta = serveConslta;
	}


	public String getCustoConslta() {
		return custoConslta;
	}


	public void setCustoConslta(String custoConslta) {
		this.custoConslta = custoConslta;
	}


	public conhecimento() {
		// TODO Auto-generated constructor stub
	}

}
