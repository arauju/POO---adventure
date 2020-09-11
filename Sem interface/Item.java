import java.util.Scanner;

public class Item {
	
	private boolean coletado;
	private boolean existe;
	Scanner input = new Scanner(System.in);
	
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	public boolean isColetado() {
		return coletado;
	}
	public void setColetado(boolean coletado) {
		this.coletado = coletado;
	}
}