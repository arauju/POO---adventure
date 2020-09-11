public class Machado extends Item{

	private boolean lancado;
	private int idMachado = 0;
	private int idMachadoGold = 0;
	private int idMachadoBronze = 0;

	public boolean isLancado() {
		return lancado;
	}

	public void setLancado(boolean lancado) {
		this.lancado = lancado;
	}
	
	public int getIdMachado(){
		return idMachado;
	}
	
	public void mostraIdMachado(){
		if(idMachado == 1){
			System.out.println("Um machado.");
		}
		if(idMachado > 1){
			System.out.println(idMachado + " machados.");
		}
		
		if(idMachadoGold == 1){
			System.out.println("Um machado de Ouro.");
		}
		if(idMachadoGold > 1){
			System.out.println(idMachadoGold + " machados de Ouro.");
		}
		
		if(idMachadoBronze == 1){
			System.out.println("Um machado de Bronze.");
		}
		if(idMachadoBronze > 1){
			System.out.println(idMachadoBronze + " machados de Bronze.");
		}
	}
	
	public boolean jogaMachado(boolean wrong, Jogador player, Sala[] room, int code){
		boolean trollMorto = false;
		int integridadeG = 0, integridadeB = 0;
		if(code == 1){
			wrong = false;
			if(idMachado == 0){
				System.out.println("Voc� n�o possui um machado para matar o troll.");
				System.out.println("Saia da sala e procure por um antes que ele te acerte!");
			}else if(idMachado > 0){
				player.setItens(player.getItens() - 1);
				player.axeJogador[idMachado].setExiste(false);
				room[player.getSalaJogador()].enemy.setExiste(false);
				idMachado--;
				trollMorto = true;
			}
			return trollMorto;
		}else if(code == 2){
			wrong = false;
			if(idMachadoGold == 0){
				System.out.println("Voc� n�o possui um machado de Ouro para matar o troll.");
				System.out.println("Saia da sala e procure por um antes que ele te acerte!");
			}else if(idMachadoGold > 0){
				if(integridadeG < 3){
					integridadeG++;
					trollMorto = true;
				}
				if(integridadeG == 4){
					player.setItens(player.getItens() - 1);				
					player.axeJogador[idMachadoGold].setExiste(false);
					room[player.getSalaJogador()].enemy.setExiste(false);
					idMachadoGold--;
					System.out.println("Seu machado de Ouro quebrou!");
					trollMorto = true;	
				}
			}
			return trollMorto;
		}else if(code == 3){
			wrong = false;
			if(idMachadoBronze == 0){
				System.out.println("Voc� n�o possui um machado de Bronze para matar o troll.");
				System.out.println("Saia da sala e procure por um antes que ele te acerte!");
			}else if(idMachado > 0){
				if(integridadeB < 5){
					integridadeB++;
					trollMorto = true;
				}
				if(integridadeB == 6){
					player.setItens(player.getItens() - 1);
					player.axeJogador[idMachadoBronze].setExiste(false);
					room[player.getSalaJogador()].enemy.setExiste(false);
					System.out.println("Seu machado de Bronze quebrou!");
					idMachadoBronze--;
					trollMorto = true;
				}
			}
			return trollMorto;
		}
		return trollMorto;		
	}
	
	public void pegaMachado(Jogador player, Sala[] room, Troll troll, int code){
		if(code == 1){
			player.setItens(player.getItens() + 1);
			player.axeJogador[idMachado].setExiste(true);
			idMachado++;
			room[player.getSalaJogador()].axe.setExiste(false);
			System.out.println("Um machado foi adicionado � sua mochila.");
			troll.setContTroll(1);
		}
	
		if(code == 2){
			player.setItens(player.getItens() + 1);
			player.axeJogador[idMachadoGold].setExiste(true);
			idMachadoGold++;
			room[player.getSalaJogador()].axeGold.setExiste(false);
			System.out.println("Um machado de Ouro foi adicionado � sua mochila.");
			troll.setContTrollG(1);
		}
		
		if(code == 3){
			player.setItens(player.getItens() + 1);
			player.axeJogador[idMachadoBronze].setExiste(true);
			idMachadoBronze++;
			room[player.getSalaJogador()].axeBronze.setExiste(false);
			System.out.println("Um machado de Bronze foi adicionado � sua mochila.");
			troll.setContTrollB(1);
		}
		
	}
	
	public void moveToAxe(Jogador player, Sala[] room, Troll troll, boolean wrong, int code){
		if(code == 1){
			if(!(room[player.getSalaJogador()].axe.isExiste())){
				System.out.println("N�o h� machado nesta sala.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(room[player.getSalaJogador()].axe.isExiste()){
				wrong = false;
				System.out.println("Voc� se moveu para perto do machado. Comande 'pickUp axe' para peg�-lo.");
				String comando = input.nextLine();
				//Se o jogador tiver 5 itens, n�o ser� poss�vel pegar o machado
				if(comando.equals("pickUp axe") && (player.getItens() == 5)){
					System.out.println("Voc� possui 5 itens. Comande 'drop (item)' para dropar um e pegar o machado.");
					troll.setContTroll(1);
				}
				//Pega o machado
				if((player.getItens() < 5)){
					pegaMachado(player, room, troll,1);	
				}
			}			
		}
		
		if(code == 2){
			if(!(room[player.getSalaJogador()].axeGold.isExiste())){
				System.out.println("N�o h� machado de Ouro nesta sala.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(room[player.getSalaJogador()].axeGold.isExiste()){
				wrong = false;
				System.out.println("Voc� se moveu para perto do machado de Gold. Comande 'pickUp axeGold' para peg�-lo.");
				String comando = input.nextLine();
				//Se o jogador tiver 5 itens, n�o ser� poss�vel pegar o machado
				if(comando.equals("pickUp axeGold") && (player.getItens() == 5)){
					System.out.println("Voc� possui 5 itens. Comande 'drop (item)' para dropar um e pegar o machado de Ouro.");
					troll.setContTroll(1);
				}
				//Pega o machado
				if((player.getItens() < 5)){
					pegaMachado(player, room, troll,2);	
				}
			}			
		}
		
		if(code == 3){
			if(!(room[player.getSalaJogador()].axeBronze.isExiste())){
				System.out.println("N�o h� machado de Bronze nesta sala.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(room[player.getSalaJogador()].axeBronze.isExiste()){
				wrong = false;
				System.out.println("Voc� se moveu para perto do machado de Bronze. Comande 'pickUp axeBronze' para peg�-lo.");
				String comando = input.nextLine();
				//Se o jogador tiver 5 itens, n�o ser� poss�vel pegar o machado
				if(comando.equals("pickUp axeBronze") && (player.getItens() == 5)){
					System.out.println("Voc� possui 5 itens. Comande 'drop (item)' para dropar um e pegar o machado de Ouro.");
					troll.setContTroll(1);
				}
				//Pega o machado
				if((player.getItens() < 5)){
					pegaMachado(player, room, troll,3);	
				}
			}			
		}
		
		
	}
	
	public void dropAxe(Jogador player, Sala[] room, Troll troll, boolean wrong, int code){
		if(code == 1){
			if(idMachado == 0){
				System.out.println("Voc� n�o possui machados.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(player.getItens() > 0){
				player.setItens(player.getItens() - 1);
				player.axeJogador[idMachado].setExiste(false);
				idMachado--;
				room[player.getSalaJogador()].axe.setExiste(true);
				System.out.println("Voc� dropou um machado da sua mochila.");
				troll.setContTroll(1);
				wrong = false;
			}
		}
		
		if(code == 2){
			if(idMachadoGold == 0){
				System.out.println("Voc� n�o possui machados de Ouro.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(player.getItens() > 0){
				player.setItens(player.getItens() - 1);
				player.axeJogador[idMachadoGold].setExiste(false);
				idMachadoGold--;
				room[player.getSalaJogador()].axeGold.setExiste(true);
				System.out.println("Voc� dropou um machado de Ouro da sua mochila.");
				troll.setContTroll(1);
				wrong = false;
			}
		}
		
		if(code == 3){
			if(idMachadoBronze == 0){
				System.out.println("Voc� n�o possui machados de Bronze.");
				troll.setContTroll(1);
				wrong = false;
			}
			if(player.getItens() > 0){
				player.setItens(player.getItens() - 1);
				player.axeJogador[idMachadoBronze].setExiste(false);
				idMachadoBronze--;
				room[player.getSalaJogador()].axeBronze.setExiste(true);
				System.out.println("Voc� dropou um machado de Bronze da sua mochila.");
				troll.setContTroll(1);
				wrong = false;
			}
		}
	}
}