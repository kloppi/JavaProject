import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

//Aktionsabläufe
public class Steuerung {
	Data data;
	String str;
	public Steuerung(){
		data = new Data();
		this.sendI2CAktuell();
	}
	public void setAktuelleTemperatur(String art){
		if (art=="F") this.data.tempAktuelle=this.data.tempFrost;
		if (art=="N") this.data.tempAktuelle=this.data.tempNacht;
		if (art=="T") this.data.tempAktuelle=this.data.tempTag;
	}
	
	public boolean incAktuelleTemperatur(){
		if (this.data.tempAktuelle - this.data.tempStep > 0x000) {this.data.tempAktuelle-=this.data.tempStep;
		this.sendI2CAktuell();
		return true;
		}
		return false;
	}
	public boolean decAktuelleTemperatur(){
		if (this.data.tempAktuelle + this.data.tempStep < 0xFFF) {this.data.tempAktuelle+=this.data.tempStep;
		this.sendI2CAktuell();
		return true;
		}
		return false;
	}
	public int aktuellerwert(){
		return this.data.tempAktuelle;
	}
	public String gesendeterWert(){
		//int wert = this.data.tempAktuelle;
		//byte[] buf = ByteBuffer.allocate(4).putInt(this.data.tempAktuelle).array();
		//byte[] buf = {(byte)((int)wert >> 8),(byte)wert};
		//buf[0]|=0x40;
		//this.str = Arrays.toString(buf);
		return this.str;
	}
	public void iniTemp(){
		//new Pipin(this.data.tempAktuelle,'d');
	}
	private void sendI2CAktuell(){
	//	Pipin send = new Pipin(this.data.tempAktuelle,'d');
	//	this.str = send.readBuff();
	}
}
