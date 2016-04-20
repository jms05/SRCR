package src;
import java.util.ArrayList;
import java.util.Iterator;

public class conheci_impreciso extends conhecimento {
	private String upper;
	private String lower;
	private ArrayList<String> ops;

	
	
	public conheci_impreciso(String idServico, String nomeServico, String instServico, String cidadeServico,String ops) {
		super(idServico, nomeServico, instServico, cidadeServico);
		String[] dois=  ops.split("-");
		if(dois.length!=1){
			//this(idServico,nomeServico,instServico, cidadeServico, dois[1],dois[0],null);
			this.lower=dois[0];
			this.upper=dois[1];
			this.ops=null;
		}else{
			dois=  ops.split(",");
			this.lower=null;
			this.upper=null;
			ArrayList<String> ar = new ArrayList<>();
			for (int i = 0; i < dois.length; i++) {
				ar.add(dois[i]);
			}
			this.ops=ar;
		}

	}
	
	public conheci_impreciso(String idServico, String nomeServico, String instServico, String cidadeServico,String upper,String lower,ArrayList<String> ops) {
		super(idServico, nomeServico, instServico, cidadeServico);
		this.lower=lower;
		this.upper=upper;
		this.ops=ops;
	}

	public conheci_impreciso(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente,String ops) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		String[] dois=  ops.split("-");
		if(dois.length!=1){
			//this(idServico,nomeServico,instServico, cidadeServico, dois[1],dois[0],null);
			this.lower=dois[0];
			this.upper=dois[1];
			this.ops=null;
		}else{
			dois=  ops.split(",");
			this.lower=null;
			this.upper=null;
			ArrayList<String> ar = new ArrayList<>();
			for (int i = 0; i < dois.length; i++) {
				ar.add(dois[i]);
			}
			this.ops=ar;
		}

	}
	
	public conheci_impreciso(String predicado, String idUtente, String nomeUtente, String idadeUtente,
			String moradaUtente,String upper,String lower,ArrayList<String> ops) {
		super(predicado, idUtente, nomeUtente, idadeUtente, moradaUtente);
		this.lower=lower;
		this.upper=upper;
		this.ops=ops;
	}

	public conheci_impreciso(String anoConslta, String mesConslta, String diaConslta, String utenteConslta,
			String serveConslta, String custoConslta,String ops) {
		super(diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		String[] dois=  ops.split("-");
		if(dois.length!=1){
			//this(idServico,nomeServico,instServico, cidadeServico, dois[1],dois[0],null);
			this.lower=dois[0];
			this.upper=dois[1];
			this.ops=null;
		}else{
			dois=  ops.split(",");
			this.lower=null;
			this.upper=null;
			ArrayList<String> ar = new ArrayList<>();
			for (int i = 0; i < dois.length; i++) {
				ar.add(dois[i]);
			}
			this.ops=ar;
		}
	}
	
	public conheci_impreciso(String anoConslta, String mesConslta, String diaConslta, String utenteConslta,
			String serveConslta, String custoConslta,String upper,String lower,ArrayList<String> ops) {
		super(diaConslta, mesConslta, anoConslta, utenteConslta, serveConslta, custoConslta);
		this.lower=lower;
		this.upper=upper;
		this.ops=ops;
	}

	@Override
	public ArrayList<String> getProlog() {
		ArrayList<String> ret = new ArrayList<>();
		String add=null;
		if(super.getPredicado().equals(CONSULTA)){
			int nulo =0;
			String[] second = new String[6];
			second[0]=super.getAnoConslta();
			second[1]=super.getMesConslta();
			second[2]=super.getDiaConslta();
			second[3]=super.getUtenteConslta();
			second[4]=super.getServeConslta();
			second[5]=super.getCustoConslta();
			for (int i = 0; i < second.length; i++) {
				if(second[i]==null){
					nulo=i;
				}
			}
			if(this.ops!=null){
				for (Iterator<String> iterator = ops.iterator(); iterator.hasNext();) {
					String s = (String) iterator.next();
					second[nulo]= s;
					add="exception("+super.getPredicado()+"(";
					for (int i1 = 0; i1 < second.length; i1++) {
						add+=second[i1];
						if(i1+1!=second.length)add+=",";
					}					
					add+=")).";
					ret.add(add);
					add="";	
				}
				
			}else{
				second[nulo]="V";
				add="exception("+super.getPredicado()+"(";
				for (int i1 = 0; i1 < second.length; i1++) {
					add+=second[i1];
					if(i1+1!=second.length)add+=",";
				}
				add+=(")) :- V>= " + this.lower +" ,  V=< "+this.upper+".");
				ret.add(add);
			}
					
		}else{
			if(super.getPredicado().equals(SERVICO)){
				int nulo =0;
				String[] second = new String[4];
				second[0]=super.getIdServico();
				second[1]=super.getNomeServico();
				second[2]=super.getInstServico();
				second[3]=super.getCidadeServico();
				for (int i = 0; i < second.length; i++) {
					if(second[i]==null){
						nulo=i;
					}
				}
				if(this.ops!=null){
					for (Iterator<String> iterator = ops.iterator(); iterator.hasNext();) {
						String s = (String) iterator.next();
						second[nulo]= s;
						add="exception("+super.getPredicado()+"(";
						for (int i1 = 0; i1 < second.length; i1++) {
							add+=second[i1];
							if(i1+1!=second.length)add+=",";
						}					
						add+=")).";
						ret.add(add);
						add="";	
					}
					
				}else{
					second[nulo]="V";
					add="exception("+super.getPredicado()+"(";
					for (int i1 = 0; i1 < second.length; i1++) {
						add+=second[i1];
						if(i1+1!=second.length)add+=",";
					}
					add+=(")) :- V>= " + this.lower +" ,  V=< "+this.upper+".");
					ret.add(add);
				}
			}else{
				if(super.getPredicado().equals(UTENTE)){
					int nulo=0;
					String[] second = new String[4];
					second[0]=super.getIdUtente();
					second[1]=super.getNomeUtente();
					second[2]=super.getIdadeUtente();
					second[3]=super.getMoradaUtente();
					for (int i = 0; i < second.length; i++) {
						if(second[i]==null){
							nulo=i;
						}
					}
					if(this.ops!=null){
						for (Iterator<String> iterator = ops.iterator(); iterator.hasNext();) {
							String s = (String) iterator.next();
							second[nulo]= s;
							add="exception("+super.getPredicado()+"(";
							for (int i1 = 0; i1 < second.length; i1++) {
								add+=second[i1];
								if(i1+1!=second.length)add+=",";
							}					
							add+=")).";
							ret.add(add);
							add="";	
						}
						
					}else{
						second[nulo]="V";
						add="exception("+super.getPredicado()+"(";
						for (int i1 = 0; i1 < second.length; i1++) {
							add+=second[i1];
							if(i1+1!=second.length)add+=",";
						}
						add+=(")) :- V>= " + this.lower +" ,  V=< "+this.upper+".");
						ret.add(add);
					}
				}
			}
			return ret;
		}
		return ret;

	}
}
