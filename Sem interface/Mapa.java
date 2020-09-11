import java.util.Random;

public class Mapa {

	Random r = new Random();
	int[] tamanho = new int[20];

	public int getTamanhoSala(int local){
		return tamanho[local];
	}

	public void defineTamanhoSala(){
		tamanho[0] = 8;
		tamanho[1] = 15;
		tamanho[2] = 7;
		tamanho[3] = 12;
		tamanho[4] = 19;
		tamanho[5] = 20;
		tamanho[6] = 17;
		tamanho[7] = 1;
		tamanho[8] = 16;
		tamanho[9] = 13;
		tamanho[10] = 9;
		tamanho[11] = 2;
		tamanho[12] = 3;
		tamanho[13] = 6;
		tamanho[14] = 21;
		tamanho[15] = 5;
		tamanho[16] = 18;
		tamanho[17] = 10;
		tamanho[18] = 14;
		tamanho[19] = 11;
	}

	public void setaDiamante(int idSala, Sala[] room){
		Random r = new Random();

		for (int i = 1; i < tamanho[idSala]; i++){
			room[idSala].metro[i].diamond.setValor(r.nextInt(10));
			if (tamanho[idSala] > 6 && room[idSala].metro[i].diamond.getValor() < 4){
				room[idSala].metro[i].diamond.setValor(0);
			}
		}
	}

	public void setaOuro(int idSala, Sala[] room){
		Random r = new Random();
		for (int i = 1; i < tamanho[idSala]; i++){
			room[idSala].metro[i].gold.setValor(r.nextInt(10));
			if (tamanho[idSala] > 6 && room[idSala].metro[i].gold.getValor() < 4){
				room[idSala].metro[i].gold.setValor(0);
			}
		}
	}

	public void setaDiamanteOuro(int idSala, Sala[] room){
		for (int i = 1; i < tamanho[idSala]; i++){
			room[idSala].metro[i].gold.setValor(r.nextInt(10));
			room[idSala].metro[i].diamond.setValor(r.nextInt(10));
			if (tamanho[idSala] > 5 && room[idSala].metro[i].diamond.getValor() < 4){
				room[idSala].metro[i].diamond.setValor(0);
			}
			if (tamanho[idSala] > 5 && room[idSala].metro[i].gold.getValor() < 4){
				room[idSala].metro[i].gold.setValor(0);
			}
			if (room[idSala].metro[i].gold.getValor() + room[idSala].metro[i].diamond.getValor()  > 10){
				room[idSala].metro[i].diamond.setValor(0);
			}
		}
	}

	public void definicaoCorredores(Corredor[] corredor){
		int i;
		for(i = 0; i < 14; i++){
			for (int k = 0; k < 21; k++){
				corredor[i] = new Corredor();
				corredor[i].enemy.setExiste(false);
			}
			for(int j = 0; j < 6; j++){
				corredor[i].door[j] = new Porta();
				corredor[i].door[j].setTrancada(false);
				corredor[i].door[j].setExiste(false);
				corredor[i].door[j].setSaida(false);
			}
		}

		corredor[1].setName("Corredor 1");
		corredor[1].door[1].setExiste(true);
		corredor[1].door[2].setExiste(true);
		corredor[1].door[3].setExiste(true);
		corredor[1].door[4].setExiste(true);

		corredor[1].door[1].setNome('A');
		corredor[1].door[2].setNome('B');
		corredor[1].door[3].setNome('C');
		corredor[1].door[4].setNome('D');

		corredor[1].door[1].setPassagem(0);
		corredor[1].door[2].setPassagem(2);
		corredor[1].door[3].setPassagem(5);
		corredor[1].door[4].setPassagem(7);

		corredor[2].setName("Corredor 2");
		corredor[2].door[1].setExiste(true);
		corredor[2].door[2].setExiste(true);
		corredor[2].door[3].setExiste(true);
		corredor[2].door[4].setExiste(true);

		corredor[2].door[1].setNome('A');
		corredor[2].door[2].setNome('B');
		corredor[2].door[3].setNome('C');
		corredor[2].door[4].setNome('D');

		corredor[2].door[1].setPassagem(1);
		corredor[2].door[2].setPassagem(0);
		corredor[2].door[3].setPassagem(5);
		corredor[2].door[4].setPassagem(6);

		corredor[3].setName("Corredor 3");
		corredor[3].door[1].setExiste(true);
		corredor[3].door[2].setExiste(true);

		corredor[3].door[1].setNome('A');
		corredor[3].door[2].setNome('B');

		corredor[3].door[1].setPassagem(2);
		corredor[3].door[2].setPassagem(1);

		corredor[4].setName("Corredor 4");
		corredor[4].door[1].setExiste(true);
		corredor[4].door[2].setExiste(true);
		corredor[4].door[3].setExiste(true);
		corredor[4].door[5].setExiste(true);
		corredor[4].enemy.setCorredorTroll(4);
		corredor[4].enemy.setNomeTroll("Ajun");
		corredor[4].enemy.setCavernaTroll(false);


		corredor[4].door[1].setNome('A');
		corredor[4].door[2].setNome('B');
		corredor[4].door[3].setNome('C');
		corredor[4].door[5].setNome('E');

		corredor[4].door[1].setPassagem(6);
		corredor[4].door[2].setPassagem(11);
		corredor[4].door[3].setPassagem(7);
		corredor[4].door[5].setPassagem(12);

		corredor[5].setName("Corredor 5");
		corredor[5].door[1].setExiste(true);
		corredor[5].door[4].setExiste(true);
		

		corredor[5].door[1].setNome('A');
		corredor[5].door[4].setNome('D');

		corredor[5].door[1].setPassagem(10);
		corredor[5].door[4].setPassagem(11);

		corredor[6].setName("Corredor 6");
		corredor[6].door[2].setExiste(true);
		corredor[6].door[3].setExiste(true);
		corredor[6].enemy.setCorredorTroll(6);
		corredor[6].enemy.setNomeTroll("Hyptu");
		corredor[6].enemy.setCavernaTroll(false);


		corredor[6].door[2].setNome('B');
		corredor[6].door[3].setNome('C');

		corredor[6].door[2].setPassagem(16);
		corredor[6].door[3].setPassagem(17);

		corredor[7].setName("Corredor 7");
		corredor[7].door[1].setExiste(true);
		corredor[7].door[2].setExiste(true);

		corredor[7].door[1].setNome('A');
		corredor[7].door[2].setNome('B');

		corredor[7].door[1].setPassagem(17);
		corredor[7].door[2].setPassagem(18);

		corredor[8].setName("Corredor 8");
		corredor[8].door[1].setExiste(true);
		corredor[8].door[2].setExiste(true);
		corredor[8].door[3].setExiste(true);
		corredor[8].door[4].setExiste(true);

		corredor[8].door[1].setNome('A');
		corredor[8].door[2].setNome('B');
		corredor[8].door[3].setNome('C');
		corredor[8].door[4].setNome('D');

		corredor[8].door[1].setPassagem(15);
		corredor[8].door[2].setPassagem(10);
		corredor[8].door[3].setPassagem(13);
		corredor[8].door[4].setPassagem(18);

		corredor[8].door[1].setExiste(true);
		corredor[8].door[2].setExiste(true);

		corredor[9].setName("Corredor 9");
		corredor[9].door[1].setExiste(true);
		corredor[9].door[2].setExiste(true);
		corredor[9].door[3].setExiste(true);
		corredor[9].door[4].setExiste(true);
		corredor[9].enemy.setExiste(true);
		corredor[9].enemy.setCorredorTroll(9);
		corredor[9].enemy.setNomeTroll("Rakash");
		corredor[9].enemy.setCavernaTroll(false);

		corredor[9].door[1].setNome('A');
		corredor[9].door[2].setNome('B');
		corredor[9].door[3].setNome('C');
		corredor[9].door[4].setNome('D');

		corredor[9].door[1].setPassagem(8);
		corredor[9].door[2].setPassagem(3);
		corredor[9].door[3].setPassagem(9);
		corredor[9].door[4].setPassagem(4);

		corredor[10].setName("Corredor 10");
		corredor[10].door[4].setExiste(true);
		corredor[10].door[2].setExiste(true);

		corredor[10].door[4].setNome('D');
		corredor[10].door[2].setNome('B');

		corredor[10].door[2].setPassagem(14);
		corredor[10].door[4].setPassagem(9);

		corredor[11].setName("Corredor 11");

		corredor[11].door[1].setExiste(true);
		corredor[11].door[3].setExiste(true);

		corredor[11].door[1].setNome('A');
		corredor[11].door[3].setNome('C');

		corredor[11].door[1].setPassagem(13);
		corredor[11].door[3].setPassagem(14);

		corredor[12].setName("Corredor 12");
		corredor[12].door[1].setExiste(true);
		corredor[12].door[4].setExiste(true);
		corredor[12].enemy.setNomeTroll("Sligo");
		corredor[12].enemy.setSalaTroll(12);
		corredor[12].enemy.setCavernaTroll(false);


		corredor[12].door[1].setNome('A');
		corredor[12].door[4].setNome('D');

		corredor[12].door[1].setPassagem(19);
		corredor[12].door[4].setPassagem(14);

		corredor[13].setName("Corredor 13");
		corredor[13].door[1].setExiste(true);
		corredor[13].door[2].setExiste(true);

		corredor[13].door[1].setNome('A');
		corredor[13].door[2].setNome('B');

		corredor[13].door[1].setPassagem(4);
		corredor[13].door[2].setPassagem(9);

	}

	//Definição das salas
	public void definicaoSalas(Sala[] room){
		int i;
		for(i = 0; i<=20; i++){
			for (int k = 0; k < 21; k++){
				room[i] = new Sala();
				room[i].enemy.setExiste(false);
			}
			for(int j = 0; j<=5; j++){
				room[i].door[j] = new Porta();
				room[i].door[j].setTrancada(false);
				room[i].door[j].setExiste(false);
				room[i].door[j].setSaida(false);
			}
			for(int j = 0; j < 22; j++){
				room[i].metro[j] = new Metro();
			}
		}

		//inicia os machados
		room[r.nextInt(19)].axeGold.setExiste(r.nextBoolean());
		for (i = 0; i < 3; i++){
			room[r.nextInt(19)].axeBronze.setExiste(r.nextBoolean());
		}

		room[0].setName("Sala 1");
		room[0].door[1].setExiste(true);
		room[0].door[2].setExiste(true);
		room[0].door[1].setNome('A');
		room[0].door[2].setNome('B');
		room[0].door[1].setPassagem(1);
		room[0].door[2].setPassagem(2);
		room[0].potion.setExiste(true);
		setaOuro(0, room);

		room[1].setName("Sala 2");
		room[1].door[1].setExiste(true);
		room[1].door[2].setExiste(true);
		room[1].door[1].setNome('A');
		room[1].door[2].setNome('B');
		room[1].door[1].setPassagem(2);
		room[1].door[2].setPassagem(3);
		room[1].axe.setExiste(r.nextBoolean());
		room[1].potion.setExiste(r.nextBoolean());
		setaDiamante(1, room);

		room[2].setName("Sala 3");
		room[2].door[1].setExiste(true);
		room[2].door[2].setExiste(true);
		room[2].door[1].setNome('A');
		room[2].door[2].setNome('B');
		room[2].door[1].setPassagem(3);
		room[2].door[2].setPassagem(1);
		room[2].key.setExiste(true);
		room[2].key.setLigacao(10);
		room[2].axe.setExiste(r.nextBoolean());
		room[2].potion.setExiste(r.nextBoolean());
		setaOuro(2, room);

		room[3].setName("Sala 4");
		room[3].door[0].setExiste(true);
		room[3].door[2].setExiste(true);
		room[3].door[0].setNome('A');
		room[3].door[2].setNome('B');
		room[3].door[0].setPassagem(12);
		room[3].door[2].setPassagem(9);
		room[3].door[0].setSaida(true);
		room[3].enemy.setExiste(true);
		room[3].enemy.setSalaTroll(3);
		room[3].enemy.setNomeTroll("Ajun");
		room[3].enemy.setCavernaTroll(true);
		setaDiamanteOuro(3, room);

		room[4].setName("Sala 5");
		room[4].door[1].setExiste(true);
		room[4].door[2].setExiste(true);
		room[4].door[1].setNome('A');
		room[4].door[2].setNome('B');
		room[4].door[1].setTrancada(true);
		room[4].door[1].setPassagem(13);
		room[4].door[2].setPassagem(9);
		room[4].axe.setExiste(true);
		room[4].potion.setExiste(r.nextBoolean());

		room[5].setName("Sala 6");
		room[5].door[1].setExiste(true);
		room[5].door[3].setExiste(true);
		room[5].door[1].setNome('A');
		room[5].door[3].setNome('C');
		room[5].door[1].setPassagem(2);
		room[5].door[3].setPassagem(1);
		room[5].key.setExiste(true);
		room[5].key.setLigacao(17);
		room[5].potion.setExiste(r.nextBoolean());
		room[5].axe.setExiste(r.nextBoolean());
		setaOuro(0, room);

		room[6].setName("Sala 7");
		room[6].door[1].setExiste(true);
		room[6].door[4].setExiste(true);
		room[6].door[1].setNome('A');
		room[6].door[4].setNome('D');
		room[6].door[1].setPassagem(4);
		room[6].door[4].setPassagem(2);
		room[6].enemy.setExiste(true);
		room[6].enemy.setSalaTroll(6);
		room[6].enemy.setNomeTroll("Hyptu");
		room[6].enemy.setCavernaTroll(false);
		setaOuro(0, room);

		room[7].setName("Sala 8");
		room[7].door[3].setExiste(true);
		room[7].door[4].setExiste(true);
		room[7].door[3].setNome('C');
		room[7].door[4].setNome('D');
		room[7].door[3].setPassagem(4);
		room[7].door[4].setPassagem(1);
		room[7].axe.setExiste(r.nextBoolean());
		room[7].potion.setExiste(r.nextBoolean());
		setaDiamante(7, room);

		room[8].setName("Sala 9");
		room[8].door[1].setExiste(true);
		room[8].door[1].setNome('A');
		room[8].door[1].setPassagem(9);
		room[8].potion.setExiste(r.nextBoolean());
		room[8].axe.setExiste(r.nextBoolean());
		setaDiamanteOuro(0, room);

		room[9].setName("Sala 10");
		room[9].door[2].setExiste(true);
		room[9].door[3].setExiste(true);
		room[9].door[4].setExiste(true);
		room[9].door[2].setNome('B');
		room[9].door[3].setNome('C');
		room[9].door[4].setNome('D');
		room[9].door[2].setPassagem(13);
		room[9].door[3].setPassagem(9);
		room[9].door[4].setPassagem(10);
		room[9].potion.setExiste(r.nextBoolean());
		setaDiamanteOuro(9, room);

		room[10].setName("Sala 11");
		room[10].door[1].setExiste(true);
		room[10].door[2].setExiste(true);
		room[10].door[1].setNome('A');
		room[10].door[2].setNome('B');
		room[10].door[1].setPassagem(5);
		room[10].door[2].setPassagem(8);
		room[10].door[2].setTrancada(true);
		room[10].enemy.setExiste(true);
		room[10].enemy.setNomeTroll("Sligo");
		room[10].enemy.setCavernaTroll(true);
		room[10].enemy.setSalaTroll(10);

		room[11].setName("Sala 12");
		room[11].door[2].setExiste(true);
		room[11].door[3].setExiste(true);
		room[11].door[4].setExiste(true);
		room[11].door[2].setNome('B');
		room[11].door[3].setNome('C');
		room[11].door[4].setNome('D');
		room[11].door[2].setPassagem(4);
		room[11].door[3].setPassagem(3);
		room[11].door[4].setPassagem(5);
		room[11].potion.setExiste(r.nextBoolean());
		setaOuro(11, room);

		room[12].setName("Sala 13");
		room[12].door[4].setExiste(true);
		room[12].door[5].setExiste(true);
		room[12].door[4].setNome('D');
		room[12].door[5].setNome('E');
		room[12].door[4].setPassagem(3);
		room[12].door[5].setPassagem(4);
		room[12].axe.setExiste(r.nextBoolean());
		room[12].potion.setExiste(r.nextBoolean());
		setaDiamante(12, room);

		room[13].setName("Sala 14");
		room[13].door[1].setExiste(true);
		room[13].door[3].setExiste(true);
		room[13].door[1].setNome('A');
		room[13].door[3].setNome('C');
		room[13].door[1].setPassagem(11);
		room[13].door[3].setPassagem(8);
		room[13].enemy.setExiste(true);
		room[13].enemy.setSalaTroll(13);
		room[13].enemy.setNomeTroll("Gamjee");
		room[13].enemy.setCavernaTroll(false);
		setaOuro(13, room);

		room[14].setName("Sala 15");
		room[14].door[2].setExiste(true);
		room[14].door[3].setExiste(true);
		room[14].door[4].setExiste(true);
		room[14].door[2].setNome('B');
		room[14].door[3].setNome('C');
		room[14].door[4].setNome('D');
		room[14].door[2].setPassagem(10);
		room[14].door[3].setPassagem(11);
		room[14].door[4].setPassagem(12);
		room[14].axe.setExiste(r.nextBoolean());
		room[14].potion.setExiste(r.nextBoolean());
		setaDiamante(14, room);

		room[15].setName("Sala 16");
		room[15].door[1].setExiste(true);
		room[15].door[3].setExiste(true);
		room[15].door[1].setNome('A');
		room[15].door[3].setNome('C');
		room[15].door[1].setPassagem(8);
		room[15].door[3].setPassagem(5);
		room[15].axe.setExiste(true);
		room[15].potion.setExiste(r.nextBoolean());
		setaDiamanteOuro(15, room);

		room[16].setName("Sala 17");
		room[16].door[1].setExiste(true);
		room[16].door[2].setExiste(true);
		room[16].door[1].setNome('A');
		room[16].door[2].setNome('B');
		room[16].door[1].setPassagem(5);
		room[16].door[2].setPassagem(6);
		room[16].enemy.setExiste(true);
		room[16].enemy.setSalaTroll(16);
		room[16].enemy.setNomeTroll("Rakash");
		room[3].enemy.setCavernaTroll(false);

		room[17].setName("Sala 18");
		room[17].door[1].setExiste(true);
		room[17].door[3].setExiste(true);
		room[17].door[1].setNome('A');
		room[17].door[3].setNome('C');
		room[17].door[1].setPassagem(18);
		room[17].door[3].setPassagem(16);
		room[17].door[1].setTrancada(true);
		room[17].axe.setExiste(r.nextBoolean());
		setaDiamante(17, room);

		room[18].setName("Sala 19");
		room[18].door[2].setExiste(true);
		room[18].door[4].setExiste(true);
		room[18].door[2].setNome('B');
		room[18].door[4].setNome('D');
		room[18].door[2].setPassagem(7);
		room[18].door[4].setPassagem(8);
		room[18].potion.setExiste(r.nextBoolean());
		setaOuro(18, room);

		room[19].setName("Sala 20");
		room[19].door[1].setExiste(true);
		room[19].door[1].setNome('A');
		room[19].door[1].setPassagem(12);
		room[19].key.setExiste(true);
		room[19].key.setLigacao(4);
		room[19].axe.setExiste(r.nextBoolean());
		setaDiamanteOuro(19, room);
	}
}
