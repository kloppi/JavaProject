//Datenverwaltung
public class Data {
	
public	int tempAktuelle;
public	int tempFrost;
public	int tempTag;
public	int tempNacht;
public  int tempMax;	
public  int tempStep;
	public Data(){
		this.tempMax = 0xFFF;
		this.tempTag = 0x7FF;
		this.tempNacht = 0x3FF;
		this.tempFrost = 0x000;
		this.tempAktuelle = this.tempTag; 
		this.tempStep = 0x30;
	}
	

}
