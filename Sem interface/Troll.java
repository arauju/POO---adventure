public class Troll {

	private String nomeTroll;
	private int salaTroll;
	private int corredorTroll;
	private boolean existe;
	private int contTroll = 0;
	private int contTrollGold = 0;
	private int contTrollBronze = 0;
	private boolean cavernaTroll;


	public boolean isCavernaTroll() {
		return cavernaTroll;
	}
	public void setCavernaTroll(boolean cavernaTroll) {
		this.cavernaTroll = cavernaTroll;
	}
	public String getNomeTroll() {
		return nomeTroll;
	}
	public void setNomeTroll(String nomeTroll) {
		this.nomeTroll = nomeTroll;
	}
	public int getSalaTroll() {
		return salaTroll;
	}
	public void setSalaTroll(int salaTroll) {
		this.salaTroll = salaTroll;
	}
	public int getCorredorTroll() {
		return corredorTroll;
	}
	public void setCorredorTroll(int corredorTroll) {
		this.corredorTroll = corredorTroll;
	}
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public int setContTroll(int valor){
		contTroll = valor;
		return contTroll;
	}

	public int setContTrollG(int valor){
		contTrollGold = valor;
		return contTrollGold;
	}
	public int setContTrollB(int valor){
		contTrollBronze = valor;
		return contTrollBronze;
	}

	public int getContTroll(){
		return contTroll;
	}



	public void trollAtaca(Sala[] room, Jogador player, int idPocao, int menu, boolean bloqueia){
		boolean a,b,c;
		a = contTroll == 1 && room[player.getSalaJogador()].enemy.isExiste()  && !room[player.getSalaJogador()].enemy.isCavernaTroll(); //ataca com machado de ferro
		b = contTrollGold == 1 && room[player.getSalaJogador()].enemy.isExiste()  && !room[player.getSalaJogador()].enemy.isCavernaTroll(); // ataca com machado de ouro
		c = contTrollBronze == 1 && room[player.getSalaJogador()].enemy.isExiste()  && !room[player.getSalaJogador()].enemy.isCavernaTroll();// ataca com machado de bronze


		if(a || c){
			//Caso o jogador n�o possua ouro
			if(player.getGoldJogador() == 0 && idPocao == 0){
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE MATOU!!!");
				System.out.println("Voc� perdeu!");
				menu = 0;
				bloqueia = true;
				contTroll = 0;
			}
		}
		if(	a || c){
			//Caso o jogador n�o possua vidas, ent�o ser� retirado seus ouros
			if(idPocao == 0){
				player.setGoldJogador(0);
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU!! VOC� PERDEU TODO SEU OURO!");
				contTroll = 0;
			}
		}
		if(contTroll == 1 && room[player.getSalaJogador()].enemy.isExiste() ){
			//Caso o jogador possua vidas(po��o m�gica)
			if(idPocao > 0){
				player.setItens(player.getItens() - 1);
				player.potionJogador[idPocao].setExiste(false);
				idPocao--;
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU!! VOC� PERDEU UMA PO��O M�GICA!");
			}
		}
		//jogador precisa de 2 pots pra se defender do machado de bronze
		//caso ele tenha menos que 2 potions � atacado, perde tudo
		if(c){
			if(idPocao < 2){
				player.setGoldJogador(0);
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU!! VOC� PERDEU TODO SEU OURO!");
				contTroll = 0;
			}
		}
		// quando ele possui 2 ou mais pots
		if(c){
			if(idPocao == 2){
				player.setItens(player.getItens() - 1);
				player.potionJogador[idPocao].setExiste(false);
				idPocao += 2;
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU COM UM MACHADO DE BRONZE!! VOC� PERDEU DUAS PO��ES M�GICA!");
			}
			if(idPocao > 2){
				player.setItens(player.getItens() - 1);
				idPocao += 2;
				System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU COM UM MACHADO DE BRONZE!! VOC� PERDEU DUAS PO��ES M�GICAS!");

			}
		}
		//n�o h� como se defender de machados de ouro
		if(b){
			player.setGoldJogador(0);
			System.out.println("O TROLL " + room[player.getSalaJogador()].enemy.getNomeTroll() + " TE ATACOU COM UM MACHADO DOURADO!! VOC� PERDEU TODO SEU OURO!");
			contTroll = 0;
		}
	}
	
	public void trollAtacaCorredor(Corredor[] corredor, Jogador player, int idPocao, int menu, boolean bloqueia){
		boolean a,b,c;
		a = contTroll == 1 && corredor[player.getCorredorJogador()].enemy.isExiste()  && !corredor[player.getCorredorJogador()].enemy.isCavernaTroll(); //ataca com machado de ferro
		b = contTrollGold == 1 && corredor[player.getCorredorJogador()].enemy.isExiste()  && !corredor[player.getCorredorJogador()].enemy.isCavernaTroll(); // ataca com machado de ouro
		c = contTrollBronze == 1 && corredor[player.getCorredorJogador()].enemy.isExiste()  && !corredor[player.getCorredorJogador()].enemy.isCavernaTroll();// ataca com machado de bronze


		if(a || c){
			//Caso o jogador n�o possua ouro
			if(player.getGoldJogador() == 0 && idPocao == 0){
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() + " TE MATOU!!!");
				System.out.println("Voc� perdeu!");
				menu = 0;
				bloqueia = true;
				contTroll = 0;
			}
		}
		if(	a || c){
			//Caso o jogador n�o possua vidas, ent�o ser� retirado seus ouros
			if(idPocao == 0){
				player.setGoldJogador(0);
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() 
						+ " TE ATACOU!! VOC� PERDEU TODO SEU OURO!");
				contTroll = 0;
			}
		}
		if(contTroll == 1 && corredor[player.getCorredorJogador()].enemy.isExiste() ){
			//Caso o jogador possua vidas(po��o m�gica)
			if(idPocao > 0){
				player.setItens(player.getItens() - 1);
				player.potionJogador[idPocao].setExiste(false);
				idPocao--;
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() 
						+ " TE ATACOU!! VOC� PERDEU UMA PO��O M�GICA!");
			}
		}
		//jogador precisa de 2 pots pra se defender do machado de bronze
		//caso ele tenha menos que 2 potions � atacado, perde tudo
		if(c){
			if(idPocao < 2){
				player.setGoldJogador(0);
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() + 
						" TE ATACOU!! VOC� PERDEU TODO SEU OURO!");
				contTroll = 0;
			}
		}
		// quando ele possui 2 ou mais pots
		if(c){
			if(idPocao == 2){
				player.setItens(player.getItens() - 1);
				player.potionJogador[idPocao].setExiste(false);
				idPocao += 2;
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() 
						+ " TE ATACOU COM UM MACHADO DE BRONZE!! VOC� PERDEU DUAS PO��ES M�GICA!");
			}
			if(idPocao > 2){
				player.setItens(player.getItens() - 1);
				idPocao += 2;
				System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() + 
						" TE ATACOU COM UM MACHADO DE BRONZE!! VOC� PERDEU DUAS PO��ES M�GICAS!");

			}
		}
		//n�o h� como se defender de machados de ouro
		if(b){
			player.setGoldJogador(0);
			System.out.println("O TROLL " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() 
					+ " TE ATACOU COM UM MACHADO DOURADO!! VOC� PERDEU TODO SEU OURO!");
			contTroll = 0;
		}
	}

}
