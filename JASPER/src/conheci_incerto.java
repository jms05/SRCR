
import java.util.ArrayList;
import java.util.Random;

public class conheci_incerto extends conhecimento {
	private int[] nulos =new int[6];
	private String[] nulstr = new String[6];
//gerar a string e mandar no contrutor

	private void init(){
		for (int i = 0; i < nulos.length; i++) {
			nulos[i]=0;
			nulstr[i]=null;
		}
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public conheci_incerto(String idServico, String nomeServico, String instServico, String cidadeServico) {
		super(idServico, nomeServico, instServico, cidadeServico);
		init();
		// TODO Auto-generated constructor stub
		if(idServico==null) {
			nulos[0]=1;
			nulstr[0]=getSaltString();
			super.setIdServico(nulstr[0]);
		}
		if(nomeServico==null){
			nulos[1]=1;
			nulstr[1]=getSaltString();
			super.setNomeServico(nulstr[1]);
		}
		if(instServico==null){
			nulos[2]=1;
			nulstr[2]=getSaltString();
			super.setInstServico(nulstr[2]);
		}
		if(cidadeServico==null){
			nulos[3]=1;
			nulstr[3]=getSaltString();
			super.setCidadeServico(nulstr[3]);
		}
		
		
	}

	public conheci_incerto(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		init();
		// TODO Auto-generated constructor stub
		if(idUtente==null) {
			nulos[0]=1;
			nulstr[0]=getSaltString();
			super.setIdUtente(nulstr[0]);
		}
		if(nomeUtente==null){
			nulos[1]=1;
			nulstr[1]=getSaltString();
			super.setNomeUtente(nulstr[1]);
		}
		if(idadeUtente==null){
			nulos[2]=1;
			nulstr[2]=getSaltString();
			super.setIdadeUtente(nulstr[2]);
		}
		if(moradaUtente==null){
			nulos[3]=1;
			nulstr[3]=getSaltString();
			super.setMoradaUtente(nulstr[3]);
		}
	}

	public conheci_incerto(String anoConslta, String mesConslta, String diaConslta, String utenteConslta,
			String serveConslta, String custoConslta) {
		super(diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		init();
		// TODO Auto-generated constructor stub
		if(diaConslta==null) {
			nulos[0]=1;
			nulstr[0]=getSaltString();
			super.setDiaConslta(nulstr[0]);
		}
		if(mesConslta==null){
			nulos[1]=1;
			nulstr[1]=getSaltString();
			super.setMesConslta(nulstr[1]);
		}
		if(anoConslta==null){
			nulos[2]=1;
			nulstr[2]=getSaltString();
			super.setAnoConslta(nulstr[2]);
		}
		if(utenteConslta==null){
			nulos[3]=1;
			nulstr[3]=getSaltString();
			super.setUtenteConslta(nulstr[3]);
		}
		if(serveConslta==null){
			nulos[4]=1;
			nulstr[4]=getSaltString();
			super.setServeConslta(nulstr[4]);
		}
		if(custoConslta==null){
			nulos[5]=1;
			nulstr[5]=getSaltString();
			super.setCustoConslta(nulstr[5]);
		}
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
			String[] second = new String[6];
			second[0]="A";
			second[1]="M";
			second[2]="D";
			second[3]="IDU";
			second[4]="IDS";
			second[5]="CU";
			for (int i = 0; i < second.length; i++) {
				if(nulos[i]==1){
					second[i]=nulstr[i];
				}
			}
			add="exception("+super.getPredicado()+"(A,M,D,IDU,IDS,CU)):- "+super.getPredicado()+"(";
			for (int i1 = 0; i1 < second.length; i1++) {
				add+=second[i1];
				if(i1+1!=second.length)add+=",";
			}
			add+=").";
					
		}else{
			if(super.getPredicado().equals(SERVICO)){
				String[] second = new String[4];
				second[0]="ID";
				second[1]="D";
				second[2]="INT";
				second[3]="C";
				for (int i = 0; i < second.length; i++) {
					if(nulos[i]==1){
						second[i]=nulstr[i];
					}
				}
				add="exception("+super.getPredicado()+"(ID,D,INT,C)):- "+super.getPredicado()+"(";
				for (int i1 = 0; i1 < second.length; i1++) {
					add+=second[i1];
					if(i1+1!=second.length)add+=",";
				}
				add+=").";
			}else{
				if(super.getPredicado().equals(UTENTE)){
					String[] second = new String[4];
					second[0]="ID";
					second[1]="N";
					second[2]="I";
					second[3]="M";
					for (int i = 0; i < second.length; i++) {
						if(nulos[i]==1){
							second[i]=nulstr[i];
						}
					}
					add="exception("+super.getPredicado()+"(ID,N,I,M)):- "+super.getPredicado()+"(";
					for (int i1 = 0; i1 < second.length; i1++) {
						add+=second[i1];
						if(i1+1!=second.length)add+=",";
					}
					add+=").";
				}
			}
		}
		
		if(ret!=null){
			ret.add(add);
		}
		return ret;
	}
	

}
