public class Porta {
	
	private boolean existe;
	private char nome;
	private boolean trancada;
	private int passagem;
	private boolean saida;
	
	public boolean isSaida() {
		return saida;
	}
	public void setSaida(boolean saida) {
		this.saida = saida;
	}
	public int getPassagem() {
		return passagem;
	}
	public void setPassagem(int passagem) {
		this.passagem = passagem;
	}
	public boolean isExiste() {
		return existe;
	}	
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	public char getNome() {
		return nome;
	}
	public void setNome(char nome) {
		this.nome = nome;
	}
	public boolean isTrancada() {
		return trancada;
	}
	public void setTrancada(boolean trancada) {
		this.trancada = trancada;
	}
}
 