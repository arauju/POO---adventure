import java.util.Scanner;

public class Jogador {

	private String nomeJogador;
	private String salaAtual;
	private int salaJogador, itens, diamondJogador, goldJogador;
	private String corredorAtual;
	private int corredorJogador;
	Pocao[] potionJogador = new Pocao[3];
	Machado[] axeJogador = new Machado[5];
	Chave[] keyJogador = new Chave[3];
	public boolean Sala;
	public boolean Corredor;
	public boolean auxSala;
	public boolean auxCorredor;
	
	public int getDiamondJogador() {
		return diamondJogador;
	}

	public void setDiamondJogador(int diamondJogador) {
		this.diamondJogador = diamondJogador;
	}

	public int getGoldJogador() {
		return goldJogador;
	}

	public void setGoldJogador(int goldJogador) {
		this.goldJogador = goldJogador;
	}

	public int getItens() {
		return itens;
	}

	public void setItens(int itens) {
		this.itens = itens;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public int getCorredorJogador() {
		return corredorJogador;
	}

	public void setCorredorJogador(int salaJogador) {
		this.corredorJogador = salaJogador;
	}

	public String getNomeCorredorAtual() {
		return corredorAtual;
	}

	public void setNomeCorredorAtual(String corredorAtual) {
		this.corredorAtual = corredorAtual;
	}

	public int getSalaJogador() {
		return salaJogador;
	}

	public void setSalaJogador(int salaJogador) {
		this.salaJogador = salaJogador;
	}

	public String getNomeSalaAtual() {
		return salaAtual;
	}

	public void setNomeSalaAtual(String salaAtual) {
		this.salaAtual = salaAtual;
	}
	
	public void definicaoJogador(Jogador player, Sala[] room) {
		player.setItens(0);
		player.setNomeSalaAtual(room[0].getName());
		player.setSalaJogador(0);
		Sala = true;
		Corredor = false;
		for (int i = 0; i <= 4; i++) {
			player.axeJogador[i] = new Machado();
		}
		for (int i = 0; i <= 2; i++) {
			player.keyJogador[i] = new Chave();
			player.potionJogador[i] = new Pocao();
		}
	}

	public void moveToSala(Sala[] room, Corredor[] corredor, Jogador player, int[] auxPorta, int verifica, boolean wrong, Troll troll, 
			Chave chave, int num, char nome) {
		int destrava = 0, count = 0;
		String comando;
		Scanner in = new Scanner(System.in);
		if (!(room[player.getSalaJogador()].door[auxPorta[num]].isExiste()) && (room[player.getSalaJogador()].door[auxPorta[num]].getNome() == nome)) {
			System.out.println("Não existe Porta "+ nome +".");
			troll.setContTroll(1);
			wrong = false;
		}
		if (room[player.getSalaJogador()].door[auxPorta[num]].isExiste() && (room[player.getSalaJogador()].door[auxPorta[num]].getNome() == nome)) {
			wrong = false;
			System.out.println("Você se moveu para a porta "+ nome +". Comande 'exit' para abri-la e passar para outra sala.");
			comando = in.nextLine();
			// Verifica se a porta está trancada e se o jogador tem a chave para abri-la
			for (int i = 0; i <= 2; i++) {
				if (comando.equals("exit") && room[player.getSalaJogador()].door[auxPorta[num]].isTrancada() 
						&& player.keyJogador[i].isColetado() && (player.keyJogador[i].getLigacao() == player.getSalaJogador())) {
					//destranca porta
					System.out.println("A porta foi destrancada com a chave!");
					player.setItens(player.getItens() - 1);
					player.keyJogador[chave.getIdChave()].setExiste(false);
					player.keyJogador[chave.getIdChave()].setColetado(false);
					chave.alteraIdChave(-1);
					room[player.getSalaJogador()].door[auxPorta[num]].setTrancada(false);
					player.setSalaJogador(room[player.getSalaJogador()].door[auxPorta[num]].getPassagem());
					player.setNomeSalaAtual(room[player.getSalaJogador()].getName());
					destrava = 1;
					troll.setContTroll(0);
				}
				if (comando.equals("exit") && room[player.getSalaJogador()].door[auxPorta[num]].isTrancada()
						&& (!(player.keyJogador[i].isColetado()) 
						|| (player.keyJogador[i].getLigacao() != player.getSalaJogador()))) {
					count++;
				}
			}
			if (count == 3) {
				System.out.println("Você não possui a chave que destranca esta porta! Encontre-a e tente novamente.");
				troll.setContTroll(1);
			}
			if (comando.equals("exit") && !room[player.getSalaJogador()].door[auxPorta[num]].isTrancada() && (destrava == 0)) {
				if (room[player.getSalaJogador()].door[auxPorta[num]].isSaida()) {
					verifica = 1;
				}
				//Jogador passa para o corredor
				player.setCorredorJogador(room[player.getSalaJogador()].door[auxPorta[num]].getPassagem());
				player.setNomeCorredorAtual(corredor[player.getCorredorJogador()].getName());
				troll.setContTroll(0);
				this.Sala = false;
				this.auxCorredor = true;
				wrong = false;
			}
		}
	}
	public void moveToCorredor(Sala[] room, Corredor[] corredor, Jogador player, int[] auxPorta, int verifica, boolean wrong, Troll troll, 
			Chave chave, int num, char nome) {
		String comando;
		Scanner in = new Scanner(System.in);
		if (!(corredor[player.getCorredorJogador()].door[auxPorta[num]].isExiste()) && (corredor[player.getCorredorJogador()].door[auxPorta[num]].getNome() == nome)){
			System.out.println("Não existe Porta "+ nome +".");
			troll.setContTroll(1);
			wrong = false;
		}
		if (corredor[player.getCorredorJogador()].door[auxPorta[num]].isExiste() && (corredor[player.getCorredorJogador()].door[auxPorta[num]].getNome() == nome)){
			wrong = false;
			System.out.println("Você se moveu para a porta "+ nome +". Comande 'exit' para abri-la e passar para uma sala.");
			comando = in.nextLine();
				if (comando.equals("exit") && !corredor[player.getCorredorJogador()].door[auxPorta[num]].isTrancada()) {
				if (corredor[player.getCorredorJogador()].door[auxPorta[num]].isSaida()) {
					verifica = 1;
				}
				//Jogador passa para a sala
				player.setSalaJogador(corredor[player.getCorredorJogador()].door[auxPorta[num]].getPassagem());
				player.setNomeSalaAtual(room[player.getSalaJogador()].getName());
				troll.setContTroll(0);
				this.Corredor = false;
				this.auxSala = true;
				wrong = false;
			}
		}
	}

}