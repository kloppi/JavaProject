import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class TemperaturDspl {
	private int x;
	private int y;
	private int tempAktuell;
	private JLabel tempScala;
	private JPanel tempPanel;

	
	public TemperaturDspl(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.tempAktuell = c/163;
		this.tempScala = new JLabel("F|15|20|25|M");
		this.tempScala.setBounds(this.x, this.y, 200, 10);
		this.tempScala.setVisible(true);
		this.tempPanel = new JPanel();
		//this.tempPanel
		this.tempPanel.setBounds(this.x,this.y+15 , this.tempAktuell, 15);
		this.tempPanel.setBackground(Color.green);		
		//this.tempPanel.add(this.tempAnzeige);
		this.tempPanel.setVisible(true);
		
	}
	public JLabel anzeigen(){
		return tempScala;
	}
	public JPanel anzeigenPanel(){
		return this.tempPanel;
	}
	
	
	
}
