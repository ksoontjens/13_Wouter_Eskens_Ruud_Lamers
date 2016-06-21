public class Werknemer {

	public String voornaam;
	public String achternaam;
	public int werknemernummer;
	protected float salaris;
	
	public Werknemer(String voornaam, String achternaam, int werknemernummer){
		this.voornaam=voornaam;
		this.achternaam=achternaam;
		this.werknemernummer=werknemernummer;
	}
	
	public void salarisVerhogen(int perc){
		salaris+=salaris*(perc/100.0);
	}
	
	public float getSalaris(){
		return salaris;
	}
	
	public void setSalaris(float salaris){
		this.salaris=salaris;
	}
}