public class PartTimeWerknemer extends Werknemer{
	
	int aantalUrenGewerkt;
	
	public PartTimeWerknemer(String voornaam, String achternaam, int werknemernummer, float salaris, int aantalGewerkt){
		super(voornaam,achternaam,werknemernummer,salaris);
		this.aantalUrenGewerkt=aantalGewerkt;
	}
	
	public float getWeekLoon(){
		return aantalUrenGewerkt*salaris;
	}
}