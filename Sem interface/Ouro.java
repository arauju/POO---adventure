import java.util.Scanner;

public class Ouro {

	private int valor;
	Scanner input = new Scanner(System.in);

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void moveToGold(Jogador player, Sala[] room, Troll troll, boolean wrong, Mapa mapa){
		int tamanhoSala = mapa.getTamanhoSala(player.getSalaJogador());
		int local = -1;
		//encontra o metro em que está o outro
		for (int i = 0; i < tamanhoSala; i++){
			if(room[player.getSalaJogador()].metro[i].gold.getValor() > 0){
				local = i;
				break;
			}
		}

		if(local == -1){
			System.out.println("Não há peças de ouro nesta sala.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((local >= 0) && room[player.getSalaJogador()].enemy.isExiste()  && room[player.getSalaJogador()].enemy.isCavernaTroll()){
			System.out.println("O troll das cavernas está protegendo as peças de ouro! Mate-o para pegá-las.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((local >= 0) && !room[player.getSalaJogador()].enemy.isExiste() || (local >= 0) && !room[player.getSalaJogador()].enemy.isCavernaTroll()){
			wrong = false;
			System.out.println("Você se moveu para perto do ouro. Comande 'pickUp gold' para pegá-lo.");
			String comando = input.nextLine();
			if(comando.equals("pickUp gold")){
				player.setGoldJogador(room[player.getSalaJogador()].metro[local].gold.getValor() + player.getGoldJogador());
				if(room[player.getSalaJogador()].metro[local].gold.getValor() == 1){
					System.out.println("Você pegou " + room[player.getSalaJogador()].metro[local].gold.getValor() + " peça de ouro.");
				}
				if(room[player.getSalaJogador()].metro[local].gold.getValor() > 1){
					System.out.println("Você pegou " + room[player.getSalaJogador()].metro[local].gold.getValor() + " peças de ouro.");
				}
				room[player.getSalaJogador()].metro[local].gold.setValor(0);
				troll.setContTroll(1);
			}
		}

	}
}
