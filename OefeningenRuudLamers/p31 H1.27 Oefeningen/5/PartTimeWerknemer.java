public class PartTimeWerknemer extends Werknemer{
	
	int aantalUrenGewerkt;
	
	public PartTimeWerknemer(String voornaam, String achternaam, int werknemernummer, float salaris, int aantalGewerkt){
		super(voornaam,achternaam,werknemernummer,salaris);
		this.aantalUrenGewerkt=aantalGewerkt;
	}
	
	public float getWeekLoon(){
		return aantalUrenGewerkt*salaris;
	}
	
	@Override
	public void salarisVerhogen(int perc){
		if(perc>5){
			perc=0;
			System.out.println("Fout: slects 5% opslag toegestaan");
		}else{
			super.salarisVerhogen(perc);
		}
	}
}