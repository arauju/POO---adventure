public class Sala extends Porta{
	
	Porta[] door = new Porta[6];
	Pocao potion = new Pocao();
	Machado axe = new Machado();
	Chave key = new Chave();
	Troll enemy = new Troll();
	Machado axeGold = new Machado();
	Machado axeBronze = new Machado();
	Metro[] metro = new Metro[22];
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}