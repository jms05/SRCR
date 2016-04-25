%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% sicstus prolog: definicoes iniciais

:- op(900,xfy,'::').
:- dynamic utente/4.
:- dynamic servico/4.
:- dynamic consulta/6. 
:- dynamic nulo/1. 
:- dynamic exception/1.
:- dynamic nao/1.
:- dynamic '-'/1.
%:- dynamic ':-'/2.

:- set_prolog_flag( unknown,fail ).
:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).

%------------------------------------------------------------------
% Extensao do predicado utente : idUtent, Nome, Idade, Morada,  -> {V,F}

-utente(Id,Name,Age,Aderess) :- nao(utente(Id,Name,Age,Aderess)), 
				nao(exception(utente(Id,Name,Age,Aderess))).

% Conhecimento perfeito
utente(1,armindo_quilhoado,69,braga).
utente(2,sara,18,porto).

% Conhecimento negativo
-utente(1,armindo_quilhoado,69,porto).
-utente(2,sara,30,faro).

% Conhecimento imprefeito
	% Conhecimento Imperfeito Incerto

	% Utente bruno com o numero de identificação 3, com 25 anos e desconhece o endereço de residencia.
	utente(3,bruno,25,xpto1). 
	exception(utente(Id,Nome,Idade,Morada)) :- utente(Id,Nome,Idade,xpto1).

	% Conhecimento Imperfeito Impreciso
	
	% Utente Manuel com o numero de identificação 5, residente em Cuba, tem idade compreendida entre 60 e 70.
	exception(utente(5,manuel,I,cuba)) :- I>=60, I=<70.

	% Utente maria com o numero de identificação 6 ou 7, reside na maia e 40 anos de idade.
	exception(utente(6,maria,40,maia)).
	exception(utente(7,maria,40,maia)).

	% Conhecimento Imperfeito Interdito

	% Não é possivel saber a morada do utente pedro, com id 8 e com 20 anos.
	utente(8,pedro,20,xpto8).
	eception(utente(ID,N,I,M)) :- utente(ID,N,I,xpto8). 
	nulo(xpto8).
	+utente(ID,N,I,M)::( solucoes( 1, (utente(8,pedro,20,M),nao(nulo(M))),L),
			comprimento(L,X),X==0).

%------------------------------------------------------------------
% Invariante para os utentes 

% utente nao pode ter ID repetido
+utente(Id,Na,Ag,Ad)::( solucoes((Id,Na,Ag,Ad),utente(Id,Na,Ag,Ad),L ), 
			comprimento(L,X ), X == 1 ). 
% Nao pode ser removido um utente que já esteja referenciado numa consulta
-utente(Id,Na,Ag,Ad)::( solucoes( ( Id ) , consulta(_,_,_,Id,_,_) , L ) , 
			comprimento(L,N), N==0 ).

%------------------------------------------------------------------
% Extensao do predicado servico: IDServ, Descricao, Instituicao, Cidade,  -> {V,F}

-servico(IdS, D, Inst, C) :- 	nao(servico(IdS, D, Inst, C)), 
				nao(exception(servico(IdS, D, Inst, C))).

% Conhecimento perfeito

servico(1,cardiologia,sao_joao,porto).
servico(2,analises,santa_maria,lisboa).

% Conhecimento negativo
-servico(1,cardiologia,sao_joao,lisboa).
-servico(2,raioX,santa_maria,porto).

% Conhecimento imprefeito
	% Conhecimento imperfeito incerto

	% O serviço analise com id 3 localizado na cidade do porto nao se sabe a instituição.
	servico(3,analise,xpto2,porto).
	exception(servico(Id,De,In,Ci)) :-	servico(Id,De,xpto2,Ci).
						
	% Conhecimento imperfeito impreciso

	% O serviço de tac existe no porto com id 4 mas o ministro de saúde afirma ser no sao_joao e o primeiro ministro jura ser no sao_jose
	exception(servico(4,tac,sao_joao,porto)).
	exception(servico(4,tac,sao_jose,porto)).

	% Conhecimento interdito

	% O ficheiro que continha o id do servico de ecografia do sao_joao da cidade do porto foi perdido e por estet motivo torna-se impossivel conhecer o seu valor
	servico(xpto3,ecografia,sao_joao,porto).
	exception( servico(Id,De,In,Ci) ) :- servico(xpto3,De,In,Ci).
	nulo(xpto3).
	+servico(Id,De,In,Ci):: (solucoes( (IDServ,De,In,Ci) , ( servico(IDServ,ecografia,sao_joao,porto), nao(nulo(IDServ))),L ),
					comprimento(L,N), N==0 ).

%------------------------------------------------------------------
% Invariantes para o conehcimento do predicado serviço
% Invariante que nao permite a inserção de dois serviçoes com o mesmo identidicador
+servico(Id,De,In,Ci)::( solucoes( (Id), servico(Id,De,In,Ci), L ), comprimento(L,N), N==1 ).

% Invariante que nao permite a remoção de um serviço caso este esteja referenciado numa consulta
-servico(Id,De,In,Ci)::( solucoes( (Id), consulta(_,_,_,_,Id,_), L), comprimento(L,N), N==1 ).

%------------------------------------------------------------------
% Extensao do predicado consulta: Ano,Mes,Dia, IdUtente, IdServ, Custo,  -> {V,F}

-consulta(A,M,D,U,S,C) :- nao( consulta(A,M,D,U,S,C) ), 
			 nao( exception( consulta(A,M,D,U,S,C) ) ).

% Conhecimento perfeito
consulta(2015,2,20,1,1,300).
consulta(2016,5,1,2,1,250).

% Conhecimento negativo
-consulta(2020,4,20,10,7,1.5).
-consulta(1995,3,13,11,1,500).

% Conhecimento imperfeito
	% Conhecimento Imperfeito Incerto 

	% Foi realizadda uma consulta medica no servico 2 (analises clinicas) ao utente 2 com um custo de 10 unidades no ano 2014 mes 10 mas nao se sabe o dia.
	consulta(2014,10,xpto4,2,2,10).
	exception( consulta(Ano,Mes,Dia,Ut,Serv,Custo) ) :- consulta(Ano,Mes,xpto4,Ut,Serv,Custo).
	
	% Conhecimento Imperfeito Impreciso

	% A consulta realizada no ano 2010 no dia 4 do mes 1 para o utente 1 do serviço 1 teve um custo compreendido entre 15 e 30 unidades.
	exception(consulta(2010,4,1,1,1,Custo)) :- Custo>=15 , Custo=<30.

	% Conhecimento Imperfeito Interdito

	% A ficha do utente 1 que realizou uma consulta do servico 2 com um custo de 10 unidades foi perdida e por esse motivo não é possivel saber quando foi realizada.
	servico(xpto5,xpto6,xpto7,1,2,10).
	exception(servico(A,M,D,U,S,C)) :- servico(xpto5,xpto6,xpto7,U,S,C).
	nulo(xpto5).
	nulo(xpto6).
	nulo(xpto7).

	+consulta(A,M,D,U,S,C):: (solucoes( (A,M,D,U,S,C), ( consulta(A,M,D,1,2,10), nao( ( nulo(A),nulo(M),nulo(D) ) ) ), L),
					comprimento(L,N), N==0 ).

%------------------------------------------------------------------
% Invariante para os consulta 

% Invariante que não permite a inserção de uma consulta repetida
+consulta(Ano,Mes,Dia,Ut,Se,Cu)::( solucoes( (Ano,Mes,Dia,Ut,Se), consulta(Ano,Mes,Dia,Ut,Se,_), L ),
                			comprimento(L,N ), N == 1 ).

% Invariante que valida o identificadores do utente e do serviço
+consulta(Ano,Mes,Dia,Ut,Se,Cu)::( (solucoes( (Serv), servico(Se,_,_,_),L1) ),
					(solucoes( (Ut) , utente(Ut,_,_,_),L2) ),
					comprimento(L1,N1),
					comprimento(L2,N2),
					N1 == 1,
					N2 == 1).

% Invariante gerais
% Invariante que não permite a adição de exceptions repetidas
+exception(E):: (solucoes( E , exceptions(E) , l), comprimento(L,N), N==1).

% Invariante que não permite a adição de nulo repetidos
+nulo(V)::( solucoes( V, nulo(V),L ), comprimento(L,N), N==1).


% Auxiliares ------------------------------------------------------------------

% Extensao do predido que permite a inserção de uma lista de perdidados
% caso a inserção de um dos perdicados falhe todos os outros sao removidos



evolucaoA([],LI,TP,LIF,TPF) :- insercoes(TP,TP), teste(LI).
evolucaoA([X|XS],LI,TP,LIF,TPF) :- solucoes(Invariante,+X::Invariante,Lista1),
						  		  concatenar(Lista1,LI,LIF1),
						  		  concatenar([X],TP,TPF1),
						  		  evolucaoA(XS,LIF1,TPF1,LIF,TPF).


evolucaoS(LT) :- evolucaoA(LT,[],[],R,R1).

% Extensao do perdicado que permite inserir uma lista de perdicados
insercoes([],TP).
insercoes([Termo|Termos],TP) :- assert(Termo), insercoes(Termos,TP).
insercoes(Termos,TP) :- removeall(TP),!,fail.

% Exte
removeall([]).
removeall([X|XS]) :- retract(X), removeall(XS).

% Extensao do predicado que permite a evolucao do conhecimento
evolucao(Termo) :- 
	solucoes(Invariante,+Termo::Invariante,Lista),
	insercao(Termo),
	teste(Lista).

% Extensão do predicado que permite a remoção de conehcimento
insercao(Termo):- 
	assert(Termo).
insercao(Termo):- 	
	retract(Termo),!,fail.

% Extensão do perdicado que permite verificar uma lista de termos
teste([]).
teste([R|Lr]) :- R,
		teste(Lr).


remocao(Termo) :- solucoes(Invariante,-Termo::Invariante,Lista), 
			eliminar(Termo), 
			teste(Lista).
			
eliminar(Termo) :- retract(Termo).
eliminar(Termo) :- assert(Termo), !, fail.


% Extensao do predicado que calcula o tamanho de uma lista comprimento : L,N ->{ V,F }
comprimento(L,N):- length(L,N).

% Extensao do predicado solucoes : F,P,S -> {V,F}
solucoes(F,P,S):-findall(F,P,S).

% Extensao do predicado concatenar : L1,L2,R -> {V,F}
concatenar([],L2,L2).
concatenar(L1,[],L1).
concatenar([X|L1],L2,[X|L]):- concatenar(L1,L2,L).


%--------------------------------------------------------------------------
nao(Q) :- Q, !, fail.
nao(Q).

demo([Q1|QS], R) :-
	demo1(Q1,R1),
	demo(QS,R2),
	newAnd(R1,R2,R).
demo([Q],R) :- demo1(Q,R).


demo1(Q, verdadeiro) :- Q.
demo1(Q, falso) :- -Q.
demo1(Q, desconhecido) :- nao(Q), nao(-Q).

%demo([consulta(2015,2,20,1,1,300),consulta(2020,4,20,10,7,1.5),utente(3,bruno,25,cona)],R).
%demo1(utente(3,bruno,25,cona),R).
demo([consulta(2015,2,20,1,1,300),utente(3,bruno,25,cona)],R).
demo([consulta(2020,4,20,10,7,1.5),utente(3,bruno,25,cona)],R).

newAnd(verdadeiro,verdadeiro,verdadeiro).
newAnd(verdadeiro,falso,falso).
newAnd(verdadeiro,desconhecido,desconhecido).
newAnd(falso,verdadeiro,falso).
newAnd(falso,falso,falso).
newAnd(falso,desconhecido,falso).
newAnd(desconhecido,verdadeiro,desconhecido).
newAnd(desconhecido,falso,falso).
newAnd(desconhecido,desconhecido,desconhecido).


%evolucaoS([nulo(rui),nulo(joao),nulo(ana)]).
%evolucaoS([nulo(rui),nulo(joao)]).
%:- prolog_flag(debugging,_,trace).
