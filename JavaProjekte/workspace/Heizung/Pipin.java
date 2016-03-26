import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

//Anschlüsse für des RaspberryPi

public class Pipin {
	I2CBus bus;
	I2CDevice fd;
	byte[] ergebnis;
	public Pipin(int wert,char art) {
		
		try {
			this.bus = I2CFactory.getInstance(I2CBus.BUS_1);
			this.fd = bus.getDevice(0x60);
			//byte[] buf = ByteBuffer.allocate(4).putInt(wert).array();
			
			byte[] buffer =  {0x40,(byte)((int)wert >>> 4),(byte)((int)wert << 4)};
			//buffer[0]|=0x40;
			fd.write(buffer, 0, 3);
			this.ergebnis = new byte[3];
			fd.read(this.ergebnis, 0, 3);
			this.bus.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	public String readBuff(){
		String s1 = Arrays.toString(this.ergebnis);
		return s1;
	}

}
