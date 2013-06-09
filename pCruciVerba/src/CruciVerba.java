/**
 * ==================
 * ======
 * Autor: FIREFLY
 * ======
 * ==================
 */


import javax.swing.JOptionPane;

public class CruciVerba {
	
	//Stampa delle domande verticali e orizzontali con la matrice del --CRUCIVERBA--
	void stampaMatrice(char [][]matrice,String [][]matriceNum,String [] domandeVert,char [][] domandeOriz){
		
		int i, j, k;
		
		for (i = 0; i < domandeOriz.length; i++) {
			if(i==0)
				System.out.println("\n       ╔═════════════╗                     ╔═════╤═════╤═════╤═════╤═════╤═════╤═════╤═════╤═════╤═════╗               ╔═══════════╗");
			for (j = 0; j < matrice[0].length; j++) {
				if(j==0)
					for(k=0;k<domandeOriz[0].length;k++)
						System.out.print(domandeOriz[i][k]);
				if(i<matrice.length){
					if(j==0) // stampa partizione verticale
						System.out.print("             ║");
					System.out.print(matriceNum[i][j]);
					if(matrice[i][j]=='█')
						System.out.print("██"+matrice[i][j] + "██");
					else
						System.out.print(" "+matrice[i][j] + " ");
					if(j==matrice[0].length-1) // stampa partizione verticale
						System.out.print("║");
					else
						System.out.print("│");
					if (j==9)
						System.out.print("        "+domandeVert[i]);
				}
			}
			if(i<matrice.length){
				if(i==matrice.length-1)
					System.out.println("\n                                           ╚═════╧═════╧═════╧═════╧═════╧═════╧═════╧═════╧═════╧═════╝");
				else{
					if(i==0)
						System.out.println("\n       ╚═════════════╝                     ╟─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────╢               ╚═══════════╝");
					else
						System.out.println("\n                                           ╟─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────╢");
				}
			}
			if(i>=matrice.length)
				System.out.print("                                                                                  "+domandeVert[i]+"\n\n");
			if(i==domandeOriz.length-1)
				System.out.print("                                                                                                                "+domandeVert[i+1]+"\n\n");
		}
		System.out.println("▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼");
	}
	

	//conta le lettere per creare la matrice delle domande orizzontali
	int [] contaLettere(String [] domande){

		int [] conta = new int [2];
		conta[1]=domande.length;
		int conta1=0;
		int i,j;
		String s="";
		
		for(i=0;i<domande.length;i++){
			s=domande[i];
			for(j=0;j<s.length();j++)
				if(s.charAt(j)>65 || s.charAt(j)<122 || s.charAt(j)==' ')
					conta1++;
			if(conta1>conta[0])
				conta[0]=conta1;
			conta1=0;
			s="";
		}
		
		return conta;
	}
	

	//Crea la matrice delle domande orizzontali
	char [][] creaMatriceDomandeOriz(int [] conta,String [] domandeVert){
		
		char [][] matrice = new char [conta[1]][conta[0]];
		int i,j;
		String s="";
		String s1="";
		
		for(i=0;i<matrice.length;i++){
			s1+=domandeVert[i];
			for(j=0;j<matrice[0].length;j++){
				if(s.length()>=s1.length())
					matrice[i][j]=' ';
				else{
					matrice[i][j]=domandeVert[i].charAt(j);
					s+=matrice[i][j];
				}
			}
			s="";
			s1="";
		}
		
		return matrice;
	}
	

	//Inserimento delle coordinate
	int  [] inserimentoPosizioni(int [] pos,String [] domandeOriz,String [] domandeVert,int [] contaInserimentoOriz,int [] contaInserimentoVert){
		String s1="";
		int giaFatto [] = new int [2];
		boolean ok=false,ok1=false,ok2=false;
		int conta=0,conta1=0;
		int i,n;
		boolean giusta;
		
		//richiede l'inserimento se il valore inserito non è giusto
		do{
			
			for(i=1;i<contaInserimentoOriz.length;i++)
				if(contaInserimentoOriz[i]==1)
					conta++;
				
			for(i=1;i<contaInserimentoVert.length;i++)
				if(contaInserimentoVert[i]==1)
					conta1++;
				
			do{
				if(conta==contaInserimentoOriz.length){
					if(!ok1){
						JOptionPane.showMessageDialog(null,"Le domande Orizzontali sono finite devi fare quelle --> Verticali:");
						ok1=true;
					}else{
						JOptionPane.showMessageDialog(null,"Domanda Verticali");
					}
					n=1;
				}else{
					if(conta1==contaInserimentoVert.length){
						if(!ok2){
							JOptionPane.showMessageDialog(null,"Le domande Verticali sono finite devi fare quelle --> Orizzontali:");
							ok2=true;
						}else{
							JOptionPane.showMessageDialog(null,"Domanda Orizzontale");
							}
						n=0;
					}else{
						
						s1=JOptionPane.showInputDialog("Orizzontale(0) o Verticale(1)?:");
						n=Integer.parseInt(s1);
						
					}
				}
				if((n==0)||(n==1)){
					pos[0]=n;
					ok=true;
				}
					
				if(!ok)
					JOptionPane.showMessageDialog(null, "Il valore inserito non è valido, puoi inserire (0 o 1)");
				
			}while(!ok);
			
			
			ok=false;
			
			s1=JOptionPane.showInputDialog("Inserire il numero della definizione:");
			
			pos[1]=Integer.parseInt(s1);
			
			giaFatto=controlloEsiste(pos,domandeOriz,domandeVert,1);
			
						
			if(pos[0]==0){
				
				if(contaInserimentoOriz[giaFatto[0]]==0){
					contaInserimentoOriz[giaFatto[0]]=1;
					ok=true;
				}else{
					JOptionPane.showMessageDialog(null, "Questa domanda è già stata inserita");
				}
				
			}else{
				
				if(contaInserimentoVert[giaFatto[1]]==0){
					contaInserimentoVert[giaFatto[1]]=1;
					ok=true;
				}else{
					JOptionPane.showMessageDialog(null, "Questa domanda è già stata inserita!");
				}
				
			}
			
		}while(!ok);
		
		
		return pos;
	}
	
	
	//Inserimento della parola
	String inserimentoParola(int [] indice,String stringa,String [] domandeOriz,String [] domandeVert){
		
		if(indice[0]==0)
			stringa=JOptionPane.showInputDialog(domandeVert[indice[1]]);
		else
			stringa=JOptionPane.showInputDialog(domandeOriz[indice[0]]);
		
		stringa=stringa.toUpperCase();
		
		return stringa;
	}

	
	//cerca la domanda corrispondente al numero inserito e recupera il numero della domanda
	int recuperaStringhe(String stringa){
		String aus="";
		int aus1=0,i;
		
		for(i=0;i<2;i++)
			aus+=stringa.charAt(i);
		
		aus1 = Integer.parseInt(aus);
		
		return aus1;
	}

	
	//controlla se il numero digitato è uguale a quello della domanda 
	int [] controlloEsiste(int [] pos,String [] domandeOriz,String [] domandeVert,int c){
		
		int esiste [] = new int [2];
		int i,j,num1=0;
	
		boolean definizioneTrovata=false;
		
		
		if(pos[0]==0){
			for(i=1;i<domandeOriz.length;i++){
				num1=recuperaStringhe(domandeOriz[i]);
				
				if(num1==pos[1]){
					esiste[0]=i;
					definizioneTrovata=true;
				}else
					if(!definizioneTrovata)
						if(i==domandeOriz.length-1)
							if(c==0)
								JOptionPane.showMessageDialog(null, "Mi dispiace ma il numero digitato non c'è negli Orizzontali");
							
			}
				
		}else{
			
			for(j=1;j<domandeVert.length;j++){
				num1=recuperaStringhe(domandeVert[j]);
				
				if(num1==pos[1])
					esiste[1]=j;
				else
					if(!definizioneTrovata)
						if(j==domandeVert.length-1)
							if(c==0)
								JOptionPane.showMessageDialog(null, "Mi dispiace ma il numero digitato non c'è nei Verticale");
			}
		}
		
		return esiste;
	}
	
	
	//cerca le posizioni della matrice "cruciverba" per permettere l'inserimento dell parola nel punto giusto
	int [] cercaIndice(int [] pos,String [][] matriceNum){
		int [] posIj = new int [2];
		int i,j,num1=0;
		
		for(i=0;i<matriceNum.length;i++){
			for(j=0;j<matriceNum[0].length;j++){
				num1=recuperaStringhe(matriceNum[i][j]);
				
				if(num1==pos[1]){
					posIj[0]=i;
					posIj[1]=j;
				}
			}
		}
		
		return posIj;
	}
	
	
	//questo metodo permette l'inserimento delle parole in posizione orizzontale
	char [][] inserimentoParolaOrizzontale(String parola,int [] posIJ,char [][] matrice){
		int j,k=0;
		
		for(j=posIJ[1];k<parola.length();j++,k++)
				matrice[posIJ[0]][j]=parola.charAt(k);
		
		
		return matrice;
	}
	
	
	//questo metodo permette l'inserimento delle parole in posizione verticale
	char [][] inserimentoParolaVerticali(String parola,int [] posIJ,char [][] matrice){
		int j,k=0;
		
		for(j=posIJ[0];k<parola.length();j++,k++)
			matrice[j][posIJ[1]]=parola.charAt(k);
		
		return matrice;
	}
	
	
	//questo metodo, tramite la scelta iniziale (0,1), sceglie il metodo da usare per
	// l'inserimento della parola, quindi utilizza il metodo per l'inserimento della 
	// parola in verticale o orizzontale
	void controllaOrizVert(int [] pos,String parola,int [] posIJ,char [][] matrice){
		
		if(pos[0]==0)
			inserimentoParolaOrizzontale(parola,posIJ,matrice);
		else
			inserimentoParolaVerticali(parola,posIJ,matrice);
		
	}
	
	
	//guarda se la parola è troppo lunga o troppo corta
	
	
	//guarda se la parola è troppo lunga o troppo corta attraverso un metodo
	boolean confrontaParole(String parola,int [] pos1,int [] pos,String domandeVertSoluzione [],String domandeOrizSoluzione []){
		
		boolean giusta = false;
		
		
			if(pos[0]==0){		
				if(parola.equals(domandeOrizSoluzione[pos1[0]])==false){
						JOptionPane.showMessageDialog(null, "La parola inserita è sbagliata");	
				}else{
					giusta=true;
			}
		}
		
		
			if(pos[0]==1){
				if(parola.equals(domandeVertSoluzione[pos1[1]])==false){
					JOptionPane.showMessageDialog(null, "La parola inserita è sbagliata");
				}else{
					giusta=true;
			}
		}
	
		return giusta;
	}

	
	//questo metodo chiama tutti i metodi e li esegue
	void gioco(){
		
		
		char matrice [][] = {	
								{' ',' ','█','█','█',' ',' ',' ',' ',' '},
								{' ',' ',' ','█',' ',' ','█',' ','█',' '},
								{' ','█',' ','█',' ',' ','█',' ',' ',' '},
								{'█',' ',' ',' ',' ','█',' ',' ',' ','█'},
								{' ',' ','█',' ','█',' ','█',' ','█','█'},
								{' ','█',' ',' ','█',' ',' ',' ',' ',' '},
								{' ',' ',' ',' ',' ','█',' ',' ','█',' '},
								{' ',' ','█',' ','█',' ',' ',' ','█',' '},
								{'█','█',' ',' ','█',' ','█',' ',' ','█'},
								{'█',' ',' ',' ',' ',' ',' ',' ',' ',' '},
							};
		char matriceSoluzione [][] = {	
										{'S','U','█','█','█','P','A','V','I','A'},
										{'P','E','R','█','D','I','█','I','█','V'},
										{'A','█','I','█','I','L','█','T','R','A'},
										{'█','C','O','V','O','█','I','T','O','█'},
										{'L','O','█','E','█','P','█','O','█','█'},
										{'I','█','E','N','█','T','E','R','N','O'},
										{'N','U','O','T','O','█','V','I','█','N'},
										{'O','N','█','U','█','E','A','A','█','U'},
										{'█','█','F','R','█','S','█','N','A','█'},
										{'█','F','R','A','S','T','U','O','N','O'},
									};
		
		String matriceNum[][]= {
									{"¹ ","² ","","","","³ ","  ","⁴ ","  ","⁵ "},
									{"⁶ ","  ","⁷ ","","⁸ ","  ","","  ","","  "},
									{"  ","","  ","","⁹ ","  ","","¹⁰","¹¹","  "},
									{"","¹²","  ","¹³","  ","","¹⁴","  ","  ",""},
									{"¹⁵","  ","","  ","","¹⁶","","  ","",""},
									{"  ","","¹⁷","  ","","¹⁸","¹⁹","  ","  ","²⁰"},
									{"²¹","²²","  ","  ","  ","","²³","  ","","  "},
									{"²⁴","  ","","  ","","²⁵","  ","  ","","  "},
									{"","","²⁶","  ","","  ","","²⁷","²⁸",""},
									{"","²⁹","  ","  ","  ","  ","  ","  ","  ","  "},
								};
		
		String matriceNumGenerali[][]= {
										{"01","02","00","00","00","03","00","04","00","05"},
										{"06","00","07","00","08","00","00","00","00","00"},
										{"00","00","00","00","09","00","00","10","11","00"},
										{"00","12","00","13","00","00","14","00","00","00"},
										{"15","00","00","00","00","16","00","00","00","00"},
										{"00","00","17","00","00","18","19","00","00","20"},
										{"21","22","00","00","00","00","23","00","00","00"},
										{"24","00","00","00","00","25","00","00","00","00"},
										{"00","00","26","00","00","00","00","27","28","00"},
										{"00","29","00","00","00","00","00","00","00","00"},
									};
		
		String domandeOriz [] = {	"       ║ Orizzontali ║",
									"01. Come sopra",
									"03. Provincia della Lomellina",
									"06. Segno del prodotto",
									"08. Giorno",
									"09. Articolo",
									"10. In mezzo",
									"12. Rifugio",
									"14. Andato",
									"15. In mezzo al melone",
									"17. Inghilterra internazionale",
									"18. Vincita interessante",
									"21. Disciplina olimpica",
									"23. Provincia veneta (sigla)",
									"24. Acceso",
									"25. Vocali in Mentana",
									"26. Iniziali di Renga",
									"27. Città Partenopea (sigla)",
									"29. Rumore insopportabile",
								};
		
		String domandeOrizSoluzione [] = {	"       ║ Orizzontali ║",
											"SU",
											"PAVIA",
											"PER",
											"DI",
											"IL",
											"TRA",
											"COVO",
											"ITO",
											"LO",
											"EN",
											"TERNO",
											"NUOTO",
											"VI",
											"ON",
											"EAA",
											"FR",
											"NA",
											"FRASTUONO",
									};
		int [] contaInserimentoOriz = new int [domandeOrizSoluzione.length];
		
		
		String domandeVert [] = {	"       ║ Verticali ║",
									"01. Società Per Azioni   ",
									"02. Vi aderiscono Paesi dell'Euro e non   ",
									"03. Misuratore di ricchezza   ",
									"04. Stile caratteristico di molte città   ",
									"05. Antenata  ",
									"07. Fiumiciattolo   ",
									"08. Essere Onnipotente   ",
									"11. Centro di Verona   ",
									"12. Provincia della Valtellina (sigla)   ",
									"13. Conduttrice Rai",
									"15. Prezioso tessuto   ",
									"16. Poste e Telegrafo   ",
									"17. Ai margini dell'eremo   ",
									"19. Donna tentata   ",
									"20. Le Nazioni Unite  ",
									"22. Articolo indeterminativo  ",
									"25. Sulla Rosa dei Venti   ",
									"26. Frosinone in automobile   ",
									"28. Fan che ha perso la testa   ",
							};
		
		String domandeVertSoluzione [] = {	"       ║ Verticali ║",
											"SPA",
											"UE",
											"PIL",
											"VITTORIANO",
											"AVA",
											"RIO",
											"DIO",
											"RO",
											"CO",
											"VENTURA",
											"LINO",
											"PT",
											"EO",
											"EVA",
											"ONU",
											"UN",
											"EST",
											"FR",
											"AN",
									};
		

		int [] contaInserimentoVert = new int [domandeVertSoluzione.length];
		
		
		char [][] domandeOrizzontale = creaMatriceDomandeOriz(contaLettere(domandeOriz),domandeOriz);
		
		int [] pos = new int [2];
		int [] pos1 = new int [2];
		int [] pos2 = new int [2];
		String parola="";
		boolean esiste = false;
		
		
		stampaMatrice(matrice,matriceNum,domandeVert,domandeOrizzontale);
		
		
		do{
			do{
				do{
					pos=inserimentoPosizioni(pos,domandeOriz,domandeVert,contaInserimentoOriz,contaInserimentoVert);
					
					pos1=controlloEsiste(pos,domandeOriz,domandeVert,0);
					
				}while((pos1[0]==0) && (pos1[1]==0));
			
				parola=inserimentoParola(pos1,parola,domandeOriz,domandeVert);
				
				esiste=confrontaParole(parola,pos1,pos,domandeVertSoluzione,domandeOrizSoluzione);
				
				pos2=cercaIndice(pos,matriceNumGenerali);
				
			}while(!esiste);
			
			
			controllaOrizVert(pos,parola,pos2,matrice);
			
			stampaMatrice(matrice,matriceNum,domandeVert,domandeOrizzontale);
			
		}while(matrice!=matriceSoluzione);
		
		JOptionPane.showMessageDialog(null, "Hai finito il CRUCIVERBA!!");
		JOptionPane.showMessageDialog(null, "     CONGRATULAZIONI!!");
		
	}
	
	
	//inizio main, esegue il metodo "gioco"
	public static void main(String[] args) {
		CruciVerba esercizio = new CruciVerba();
		
		esercizio.gioco();
		
	}
	
}