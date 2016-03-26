package de.sdek;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
public class RadioExample extends JFrame implements ActionListener{
	/**
	 * 
	 */
	
	JFrame f;  
	JButton wandeln,pfadread,switcher;
	JRadioButton r1;
	JRadioButton r2;
	JPanel panel;
	JLabel label;
	JTextField pfad;
	int pin=15;
	I2CDevice fd;
	I2CBus bus;
	private RadioExample() throws IOException{  
	f=new JFrame();  
	//panel = new JPanel();
	label = new JLabel("Pfadeinagbe");
	label.setBounds(10, 10, 200, 30);
	label.setVisible(true);

	f.add(label);
	
	r1=new JRadioButton("Lampe on");  
	r2=new JRadioButton("Lampe off");  
	ButtonGroup bg=new ButtonGroup(); //wechselt automatisch auf einmal true  
	bg.add(r1);bg.add(r2);  
	r1.setBounds(50,50,200,30);  
	r2.setBounds(50,80,200,30);  
	r2.setSelected(true);//off switchen
	
	switcher = new JButton();
	switcher.setText("on");
	switcher.addActionListener(this);
	switcher.setBounds(150, 120, 70, 30);
	f.add(switcher);
	wandeln = new JButton();
	wandeln.setText("Click");
	wandeln.addActionListener(this);
	
	wandeln.setBounds(50,120,70,30);
	f.add(wandeln);
	
	
	pfad = new JTextField("Hallo",35);
	
	pfad.setBounds(90, 10, 80, 30);
	pfad.setVisible(true);
	
	f.add(pfad);
	
	f.add(r1);f.add(r2);  
	f.setBounds(1, 1, 320, 240);
	
	f.setLayout(null);  
	f.setVisible(true);  
	if (Gpio.wiringPiSetup() == -1) {
		pfad.setText(" ==>> GPIO FAILED");
		return ;}else{
			pfad.setText(" ==>> GPIO OK");
		}
 	
	GpioUtil.export(pin, GpioUtil.DIRECTION_OUT);            
	Gpio.pinMode(pin, Gpio.OUTPUT);
	this.bus = I2CFactory.getInstance(I2CBus.BUS_1);
	this.fd = bus.getDevice(0x60);

	 
	}  
	 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(this,pfad.getText());
		 byte[] buf = new byte[2];
		if(r1.isSelected()){  
			Gpio.digitalWrite(pin, 0);
			switcher.setText("on");
			r2.setSelected(true);
			try {
			buf[0] = (byte) 0x0F;
			buf[1] = (byte) 0xFF;
				this.fd.write(buf, 0, 2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}else{
			if(r2.isSelected()){  
				Gpio.digitalWrite(pin, 1);
				switcher.setText("off");
			r1.setSelected(true);
			try {
			buf[0] = (byte) 0x00;
			buf[1] = (byte) 0x00;
				this.fd.write(buf, 0, 2);
				wandeln.setText("OK");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				wandeln.setText("fuck2");
				e1.printStackTrace();
				
			}
			
			}  }
		
		
	}  
	public void raspi(){
		
	}
	public static void main(String[] args) throws IOException {  
	    //new RadioExample(args[0]);  
	    new RadioExample();  
	}
	
}

//JOptionPane.showMessageDialog(this,"You are male");  
//JOptionPane.showMessageDialog(this,"You are female");  
