import java.util.Scanner;

public class Diamante {

	private int valor;
	Scanner input = new Scanner(System.in);

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void moveToDiamond(Jogador player, Sala[] room, Troll troll, boolean wrong, Mapa mapa){
		int tamanhoSala = mapa.getTamanhoSala(player.getSalaJogador());
		int local = -1;
		//encontra o metro em que está o outro
		for (int i = 0; i < tamanhoSala; i++){
			if(room[player.getSalaJogador()].metro[i].diamond.getValor() > 0){
				local = i;
				break;
			}
		}

		if(local == -1){
			System.out.println("Não há peças de diamante nesta sala.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((local >= 0) && room[player.getSalaJogador()].enemy.isExiste() && room[player.getSalaJogador()].enemy.isCavernaTroll()){
			System.out.println("O troll das cavernas está protegendo as peças de diamante! Mate-o para pegá-las.");
			troll.setContTroll(1);
			wrong = false;
		}
		if((local >= 0) && !room[player.getSalaJogador()].enemy.isExiste() || (local >= 0) && !room[player.getSalaJogador()].enemy.isCavernaTroll()){
			wrong = false;
			System.out.println("Você se moveu para perto do diamante. Comande 'pickUp diamond' para pegá-lo.");
			String comando = input.nextLine();
			if(comando.equals("pickUp diamond")){
				player.setDiamondJogador(room[player.getSalaJogador()].metro[local].diamond.getValor() + player.getDiamondJogador());
				if(room[player.getSalaJogador()].metro[local].diamond.getValor() == 1){
					System.out.println("Você pegou " + room[player.getSalaJogador()].metro[local].diamond.getValor() + " peça de diamante.");
				}
				if(room[player.getSalaJogador()].metro[local].diamond.getValor() > 1){
					System.out.println("Você pegou " + room[player.getSalaJogador()].metro[local].diamond.getValor() + " peças de diamante.");
				}
				room[player.getSalaJogador()].metro[local].diamond.setValor(0);
				troll.setContTroll(1);
			}
		}
	}
}
