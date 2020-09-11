public class Pocao extends Item{
	
	private boolean usado;
	private int idPocao = 0;

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	
	public int getIdPocao(){
		return idPocao;
	}
	
	public void mostraPocao(){
		if(idPocao == 1){
			System.out.println("Uma poção mágica.");
		}
		if(idPocao > 1){
			System.out.println(idPocao + " poções mágicas.");
		}
	}
	
	public void moveToPotion(Jogador player, Sala[] room, Troll troll, boolean wrong){
		if(!(room[player.getSalaJogador()].potion.isExiste())){
			System.out.println("Não há poção mágica nesta sala.");
			troll.setContTroll(1);
			wrong = false;
		}
		if(room[player.getSalaJogador()].potion.isExiste()){
			wrong = false;
			System.out.println("Você se moveu para perto da poção mágica. Comande 'pickUp potion' para pegá-la.");
			String comando = input.nextLine();
			//Se o jogador tiver 3 pocoes, não será possível pegar a poção
			if(comando.equals("pickUp potion") && (idPocao > 3)){
				System.out.println("Você já possui 3 poções. Não é possível pegar mais.");
				troll.setContTroll(1);
			}
			//Pega a poção
			if((idPocao < 3)){
				player.setItens(player.getItens() + 1);
				player.potionJogador[idPocao].setExiste(true);
				idPocao++;
				room[player.getSalaJogador()].potion.setExiste(false);
				System.out.println("Uma poção mágica foi adicionada à sua mochila.");
				troll.setContTroll(1);
			}
		}
	}
	
	public void dropPotion(Jogador player, Sala[] room, Troll troll, boolean wrong){
		if(idPocao == 0){
			System.out.println("Você não possui poções mágicas.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((idPocao > 0)){
			player.setItens(player.getItens() - 1);
			player.potionJogador[idPocao].setExiste(false);
			idPocao--;
			room[player.getSalaJogador()].potion.setExiste(true);
			System.out.println("Você dropou uma poção mágica da sua mochila.");
			troll.setContTroll(1);
			wrong = false;
		}
	}
}