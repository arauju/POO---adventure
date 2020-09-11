public class Chave extends Item{
	
	private int ligacao;
	private int idChave = 0;

	public int getLigacao() {
		return ligacao;
	}

	public void setLigacao(int ligacao) {
		this.ligacao = ligacao;
	}
	
	public int getIdChave(){
		return idChave;
	}
	
	public void alteraIdChave(int valor){
		idChave = idChave + valor;
	}
	
	public void pegaChave(Jogador player, Sala[] room, Troll troll){
		player.setItens(player.getItens() + 1);
		player.keyJogador[idChave].setExiste(true);
		player.keyJogador[idChave].setColetado(true);
		player.keyJogador[idChave].setLigacao(room[player.getSalaJogador()].key.getLigacao());
		idChave ++;
		room[player.getSalaJogador()].key.setExiste(false);
		System.out.println("Uma chave foi adicionada à sua mochila.");
		troll.setContTroll(1);
	}
	
	public void moveToKey(Jogador player, Sala[] room, Troll troll, boolean wrong){
		if(!(room[player.getSalaJogador()].key.isExiste())){
			System.out.println("Não há chave nesta sala.");
			troll.setContTroll(1);
			wrong = false;
		}
		if(room[player.getSalaJogador()].key.isExiste()){
			wrong = false;
			System.out.println("Você se moveu para perto da chave. Comande 'pickUp key' para pegá-la.");
			String comando = input.nextLine();
			//Se o jogador tiver 5 itens, não será possível pegar a chave
			if((idChave > 3)){
				System.out.println("Você possui 3 chaves. Não é possível pegar mais");
				troll.setContTroll(1);
			}
			//Pega a chave
			if(comando.equals("pickUp Key") && (idChave < 3)){
				pegaChave(player, room, troll);
			}
		}
	}
	
	public void dropKey(Jogador player, Sala[] room, Troll troll, boolean wrong){
		if(idChave == 0){
			System.out.println("Você não possui chaves.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((idChave > 0)){
			room[player.getSalaJogador()].key.setExiste(true);
			room[player.getSalaJogador()].key.setLigacao(player.keyJogador[idChave-1].getLigacao());
			room[player.getSalaJogador()].key.setColetado(false);
			player.setItens(player.getItens() - 1);
			player.keyJogador[idChave].setExiste(false);
			player.keyJogador[idChave].setColetado(false);
			idChave--;
			System.out.println("Você dropou uma chave da sua mochila.");
			troll.setContTroll(1);
			wrong = false;
		}
	}
}	