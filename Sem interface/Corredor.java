
public class Corredor extends Porta{
	Porta[] door = new Porta[6];
	Troll enemy = new Troll();
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
