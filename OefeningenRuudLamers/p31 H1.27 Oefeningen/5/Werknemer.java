public class Werknemer {
	
	public String voornaam;
	public String achternaam;
	public int werknemernummer;
	protected float salaris;
	private float RSZpercentage=33.0f;
	
	public Werknemer(String voornaam, String achternaam, int werknemernummer, float salaris){
		this.voornaam=voornaam;
		this.achternaam=achternaam;
		this.werknemernummer=werknemernummer;
		this.salaris=salaris;
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
	
	public void setRSZ(float rsz){
		if(rsz>100){System.out.println("Fout");}
		this.RSZpercentage=rsz;
	}
	
	public float getRSZ(){
		return this.RSZpercentage;
	}
}