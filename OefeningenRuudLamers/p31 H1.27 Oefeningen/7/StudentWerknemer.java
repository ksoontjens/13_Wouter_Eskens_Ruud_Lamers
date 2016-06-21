public class StudentWerknemer extends PartTimeWerknemer{

	private float RSZpercentage;
	
	public StudentWerknemer(String vn, String an, int nummer, int sal, int gewerkt){
		super(vn,an,nummer,sal,gewerkt);
		super.setRSZ(5.0f);
	}
}