
import java.util.*;

public class Principal {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Sala[] room = new Sala[21];
		Jogador player = new Jogador();
		Troll troll = new Troll();
		Chave chave = new Chave();
		Pocao pocao = new Pocao();
		Machado machado = new Machado();
		Ouro ouro = new Ouro();
		Diamante diamante = new Diamante();
		Corredor[] corredor = new Corredor[14];
		int[] auxPorta = new int[6];
		int menu = 1, verifica = 0;
		boolean bloqueia = false, wrong = false;
		Mapa mapa = new Mapa();
		
		mapa.defineTamanhoSala();
		mapa.definicaoCorredores(corredor);
		mapa.definicaoSalas(room);
		player.definicaoJogador(player, room);
		
		System.out.println("Seja bem vindo!");
		System.out.println("Para começarmos, digite seu nome ou nickname: ");
		player.setNomeJogador(input.nextLine());
		System.out.println("Olá " + player.getNomeJogador() + ". Você está localizado inicialmente na " + player.getNomeSalaAtual() + ".");
		
		//Rodando o jogo
		while(menu != 0){
			if(player.Sala == true){
				//Faz o troll atacar
				if (troll.getContTroll() == 1){
					troll.trollAtaca(room, player, pocao.getIdPocao(), menu, bloqueia);
				}	
			}
			if(player.Corredor == true){
				//Faz o troll atacar
				if (troll.getContTroll() == 1){
					troll.trollAtacaCorredor(corredor, player, pocao.getIdPocao(), menu, bloqueia);
				}	
			}
			
			//Se o troll tiver matado o jogador, o jogo não continuará rodando
			if(bloqueia == false){
				
				//Mostra os itens da mochila
				if(player.getItens() == 0){
					System.out.println("Você não possui nenhum item na mochila.");
				}
				if(player.getItens() > 0){
					System.out.println("Você possui: ");
					//Mostra as pocoes
					pocao.mostraPocao();
					//Mostra as chaves
					for(int i = 1; i <= chave.getIdChave(); i++){
						System.out.println("Uma chave que abre a '" + room[player.keyJogador[i-1].getLigacao()].getName() + "'.");
					}
					//Mostra os machados
					machado.mostraIdMachado();
				}
				
				System.out.println("Digite um comando(tecle 'help' para ver os comandos disponíveis).");
				String comando = input.nextLine();
				//Roda o comando help que exibe os comandos disponíveis para o jogador
				if(comando.equals("help")){
					wrong = false;
					System.out.println("'view' - lista o conteúdo da sala.");
					System.out.println("'moveTo (item/porta)' - move para o item/porta.");
					System.out.println("'exit' - sai pela porta.");
					System.out.println("'pickUp (item)' - pega um item próximo.");
					System.out.println("'drop (item)' - larga um item.");
					System.out.println("'throwAxe (nome_troll)' - lista o conteúdo da sala.");
				}

				//Roda o comando view
				if(comando.equals("view")){
					wrong = false;
					if(player.Sala == true){
						System.out.println("Esta sala possui: ");
						//Exibe as portas que estão na sala 
						for(int i = 0; i<=3; i++){
							if(room[player.getSalaJogador()].door[i].isExiste()){
								System.out.println("Porta " + room[player.getSalaJogador()].door[i].getNome() + ".");
							}
						}
						
						//Exibe as peças de ouro se houverem
						int tamanhoSala = mapa.getTamanhoSala(player.getSalaJogador());
						for (int i = 1; i < tamanhoSala; i++){
							if(room[player.getSalaJogador()].metro[i].gold.getValor() == 1){
								System.out.println(room[player.getSalaJogador()].metro[i].gold.getValor() + " peça de ouro.");
							}
							if(room[player.getSalaJogador()].metro[i].gold.getValor() > 1){
								System.out.println(room[player.getSalaJogador()].metro[i].gold.getValor() + " peças de ouro.");
							}
						}
						
						//Exibe as peças de diamante se houverem
						for (int i = 1; i < tamanhoSala; i++){
							if(room[player.getSalaJogador()].metro[i].diamond.getValor() == 1){
								System.out.println(room[player.getSalaJogador()].metro[i].diamond.getValor() + " peça de diamante.");
							}
							if(room[player.getSalaJogador()].metro[i].diamond.getValor() > 1){
								System.out.println(room[player.getSalaJogador()].metro[i].diamond.getValor() + " peças de diamante.");
							}
						}
						//Exibe a poção mágica se houver
						if(room[player.getSalaJogador()].potion.isExiste()){
							System.out.println("Uma poção mágica.");
						}
						//Exibe o machado se houver
						if(room[player.getSalaJogador()].axe.isExiste()){
							System.out.println("Um machado.");
						}
						//Exibe a chave se houver
						if(room[player.getSalaJogador()].key.isExiste()){
							System.out.println("Uma chave que abre a '" + room[room[player.getSalaJogador()].key.getLigacao()].getName() + "'.");
						}
						//Exibe o troll se houver
						if(room[player.getSalaJogador()].enemy.isExiste() && room[player.getSalaJogador()].enemy.isCavernaTroll()){
							System.out.println("Um troll da caverna chamado " + room[player.getSalaJogador()].enemy.getNomeTroll() + ".");
						}else if(room[player.getSalaJogador()].enemy.isExiste() && !room[player.getSalaJogador()].enemy.isCavernaTroll()){
							System.out.println("Um troll guerreiro chamado " + room[player.getSalaJogador()].enemy.getNomeTroll() + ".");
						}
					}
					
					if(player.Corredor == true){
						System.out.println("Este corredor possui: ");
						//Exibe as portas que estão na sala 
						for(int i = 0; i<=5; i++){
							if(corredor[player.getCorredorJogador()].door[i].isExiste()){
								System.out.println("Porta " + corredor[player.getCorredorJogador()].door[i].getNome() + ".");
							}
						}
						//Exibe os trolls
						if(corredor[player.getCorredorJogador()].enemy.isExiste() && corredor[player.getCorredorJogador()].enemy.isCavernaTroll()){
							System.out.println("Um troll da caverna chamado " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() + ".");
						}else if(corredor[player.getSalaJogador()].enemy.isExiste() && !corredor[player.getCorredorJogador()].enemy.isCavernaTroll()){
							System.out.println("Um troll guerreiro chamado " + corredor[player.getCorredorJogador()].enemy.getNomeTroll() + ".");
						}
						System.out.println(" ");
					}
				}
				
				if(player.Sala == true){
					//Roda o comando moveTo door + exit							
					for(int i = 0; i<=4; i++){
						if(room[player.getSalaJogador()].door[i].getNome() == 'A'){
							auxPorta[0] = i;
						}
						if(room[player.getSalaJogador()].door[i].getNome() == 'B'){
							auxPorta[1] = i;
						}
						if(room[player.getSalaJogador()].door[i].getNome() == 'C'){
							auxPorta[2] = i;
						}
						if(room[player.getSalaJogador()].door[i].getNome() == 'D'){
							auxPorta[3] = i;
						}
					}
					
					//Caso for mover para porta A
					if (comando.equals("moveTo A door")){
						int num = 0;
						char nome = 'A';
						player.moveToSala(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso for mover para porta B
					if(comando.equals("moveTo B door")){
						int num = 1;
						char nome = 'B';
						player.moveToSala(room, corredor,player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso for mover para porta C
					if(comando.equals("moveTo C door")){
						int num = 2;
						char nome = 'C';
						player.moveToSala(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso fro mover para D
					if(comando.equals("moveTo D door")){
						int num = 3;
						char nome = 'D';
						player.moveToSala(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					
					//Roda o comando moveTo gold + pickUp gold
					if(comando.equals("moveTo gold")){
						ouro.moveToGold(player, room, troll, wrong, mapa);
					}
					
					//Roda o comando moveTo diamond + pickUp diamond
					if(comando.equals("moveTo diamond")){
						diamante.moveToDiamond(player, room, troll, wrong, mapa);
					}
					
					//Roda o comando moveTo potion + pickUp potion
					if(comando.equals("moveTo potion")){
						pocao.moveToPotion(player, room, troll, wrong);
					}
					
					//Roda o comando moveTo axe + pickUp axe
					if(comando.equals("moveTo Axe")){
						machado.moveToAxe(player, room, troll, wrong,1);
					}
					//Roda o comando moveTo Axe + pickUp AxeGold
					if(comando.equals("moveTo AxeGold")){
						machado.moveToAxe(player, room, troll, wrong,2);
					}
					//Roda o comando moveTo Axe + pickUp AxeBronze
					if(comando.equals("moveTo AxeBronze")){
						machado.moveToAxe(player, room, troll, wrong,3);
					}
					
					//Roda o comando moveTo key + pickUp key
					if(comando.equals("moveTo Key")){
						chave.moveToKey(player, room, troll, wrong);
					}
				}
				
				if(player.Corredor == true){
					//Roda o comando moveTo door + exit							
					for(int i = 0; i<=5; i++){
						if(corredor[player.getCorredorJogador()].door[i].getNome() == 'A'){
							auxPorta[0] = i;
						}
						if(corredor[player.getCorredorJogador()].door[i].getNome() == 'B'){
							auxPorta[1] = i;
						}
						if(corredor[player.getCorredorJogador()].door[i].getNome() == 'C'){
							auxPorta[2] = i;
						}
						if(corredor[player.getCorredorJogador()].door[i].getNome() == 'D'){
							auxPorta[3] = i;
						}
						if(corredor[player.getCorredorJogador()].door[i].getNome() == 'E'){
							auxPorta[4] = i;
						}
					}
					
					//Caso for mover para porta A
					if (comando.equals("moveTo A door")){
						int num = 0;
						char nome = 'A';
						player.moveToCorredor(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso for mover para porta B
					if(comando.equals("moveTo B door")){
						int num = 1;
						char nome = 'B';
						player.moveToCorredor(room, corredor,player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso for mover para porta C
					if(comando.equals("moveTo C door")){
						int num = 2;
						char nome = 'C';
						player.moveToCorredor(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
					//Caso fro mover para D
					if(comando.equals("moveTo D door")){
						int num = 3;
						char nome = 'D';
						player.moveToCorredor(room, corredor, player, auxPorta, verifica, wrong, troll, chave, num, nome);
					}
				}
				//Roda o comando drop
				//drop Axe
				if(comando.equals("drop Axe")){
					machado.dropAxe(player, room, troll, wrong,1);
				}
				if(comando.equals("drop AxeG")){
					machado.dropAxe(player, room, troll, wrong,2);
				}
				if(comando.equals("drop AxeB")){
					machado.dropAxe(player, room, troll, wrong,3);
				}
				
				//drop Key
				if(comando.equals("drop Key")){
					chave.dropKey(player, room, troll, wrong);
				}
				
				//drop Potion
				if (comando.equals("drop potion")){
					pocao.dropPotion(player, room, troll, wrong);
				}
				
				//Roda o comando throwAxe
				boolean trollMorto = false;
				if(comando.equals("throwAxe Hyptu")){
					trollMorto = machado.jogaMachado(wrong, player, room,1);
					if (trollMorto == true)
						System.out.println("Você matou Hyptu!! Continue jogando.");
				}
				if(comando.equals("throwAxe Ajun")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,1);
					if (trollMorto == true)
						System.out.println("Você matou Ajun!! Continue jogando.");
				}		
				if(comando.equals("throwAxe Sligo")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,1);
					if (trollMorto == true)
						System.out.println("Você matou Sligo!! Continue jogando.");	
				}
				if(comando.equals("throwAxe Gamjee")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,1);
					if (trollMorto == true)
						System.out.println("Você matou Gamjee!! Continue jogando.");
				}
				if(comando.equals("throwAxe Rakash")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,1);
					if (trollMorto == true)
						System.out.println("Você matou Rakash!! Continue jogando.");
				}
				//Roda o comando throwAxeGold
				 trollMorto = false;
				if(comando.equals("throwAxeG Hyptu")){
					trollMorto = machado.jogaMachado(wrong, player, room,2);
					if (trollMorto == true)
						System.out.println("Voc� matou Hyptu!! Continue jogando.");
				}
				if(comando.equals("throwAxeG Ajun")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,2);
					if (trollMorto == true)
						System.out.println("Voc� matou Ajun!! Continue jogando.");
				}		
				if(comando.equals("throwAxeG Sligo")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,2);
					if (trollMorto == true)
						System.out.println("Voc� matou Sligo!! Continue jogando.");	
				}
				if(comando.equals("throwAxeG Gamjee")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,2);
					if (trollMorto == true)
						System.out.println("Voc� matou Gamjee!! Continue jogando.");
				}
				if(comando.equals("throwAxeG Rakash")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,2);
					if (trollMorto == true)
						System.out.println("Voc� matou Rakash!! Continue jogando.");
				}
				//roda o comando throwAxeBronze
				trollMorto = false;
				if(comando.equals("throwAxeB Hyptu")){
					trollMorto = machado.jogaMachado(wrong, player, room,3);
					if (trollMorto == true)
						System.out.println("Voc� matou Hyptu!! Continue jogando.");
				}
				if(comando.equals("throwAxeB Ajun")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,3);
					if (trollMorto == true)
						System.out.println("Voc� matou Ajun!! Continue jogando.");
				}		
				if(comando.equals("throwAxeB Sligo")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,3);
					if (trollMorto == true)
						System.out.println("Voc� matou Sligo!! Continue jogando.");	
				}
				if(comando.equals("throwAxeB Gamjee")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,3);
					if (trollMorto == true)
						System.out.println("Voc� matou Gamjee!! Continue jogando.");
				}
				if(comando.equals("throwAxeB Rakash")){
					trollMorto = false;
					trollMorto = machado.jogaMachado(wrong, player, room,3);
					if (trollMorto == true)
						System.out.println("Voc� matou Rakash!! Continue jogando.");
				}
				
				//Verifica se o usuário digitou um comando não existente
				if(wrong == true){
					System.out.println("Você digitou um comando não existente, tente novamente.");
				}
				
				//Atualiza sala ou corredor
				if(player.auxSala == true){
					player.Sala = true;
					player.auxSala = false;
				}
				if(player.auxCorredor == true){
					player.Corredor = true;
					player.auxCorredor = false;
				}
				
				//Verifica se o usuário chegou na saída
				if(verifica == 0){
					if(player.Sala == true)
						System.out.println("Você está na " + player.getNomeSalaAtual() + ".");
					else
						System.out.println("Você está no " + player.getNomeCorredorAtual() + ".");
					System.out.println(" ");
				}
				if(verifica == 1){
					System.out.println("*****************************************************************************************************");
					System.out.println("PARABÉNS " + player.getNomeJogador() + "!!! Você chegou na saída.");
					System.out.println("Você conseguiu coletar " + player.getGoldJogador() + " peça(s) de ouro e " + player.getDiamondJogador() + " peça(s) de diamante.");
					menu = 0;
				}
			}
		}
		input.close();
	}
}