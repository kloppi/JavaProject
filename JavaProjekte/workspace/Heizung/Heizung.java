import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Benutzeroberfläche


@SuppressWarnings("serial")
public class Heizung extends JFrame implements ActionListener{
	
	JButton btTempPlus, btTempMinus, btTempRom, btTempNacht, btTempTag, btTempFrost;
	JLabel jlAnzeige;
	Steuerung strg;
	TemperaturDspl tempDspl;
//	Tester
	public Heizung(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 320, 240);
		this.btTempPlus = new JButton();
		this.btTempPlus.setText("+");
		this.btTempPlus.setBounds(240, 150, 50, 20);
		this.btTempPlus.addActionListener(this);
		add(this.btTempPlus);
		this.btTempMinus = new JButton();
		this.btTempMinus.setText("-");
		this.btTempMinus.setBounds(170, 150, 50, 20);
		this.btTempMinus.addActionListener(this);
		add(this.btTempMinus);
		this.btTempTag = new JButton();
		this.btTempTag.setText("T");
		this.btTempTag.setBounds(240, 100, 50, 20);
		this.btTempTag.addActionListener(this);
		add(this.btTempTag);
		this.btTempNacht = new JButton();
		this.btTempNacht.setText("N");
		this.btTempNacht.setBounds(170, 100, 50, 20);
		this.btTempNacht.addActionListener(this);
		add(this.btTempNacht);
		this.btTempFrost = new JButton();
		this.btTempFrost.setText("F");
		this.btTempFrost.setBounds(240, 50, 50, 20);
		this.btTempFrost.addActionListener(this);
		add(this.btTempFrost);
		this.btTempRom = new JButton();
		this.btTempRom.setText("R");
		this.btTempRom.setBounds(170, 50, 50, 20);
		this.btTempRom.addActionListener(this);
		add(this.btTempRom);
		this.jlAnzeige = new JLabel("Hallo");
		this.jlAnzeige.setBounds(10, 10, 200, 30);
		this.jlAnzeige.setVisible(true);
		

		add(this.jlAnzeige);
		setLayout(null);  
		setVisible(true); 
		this.strg = new Steuerung();
		this.jlAnzeige.setText(strg.aktuellerwert()+" - "+strg.gesendeterWert());
		this.strg.iniTemp();
		this.tempDspl = new TemperaturDspl(10, 50, this.strg.aktuellerwert());
		add(this.tempDspl.anzeigen());
		add(this.tempDspl.anzeigenPanel());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btTempPlus) this.strg.incAktuelleTemperatur();
		if (e.getSource()==this.btTempMinus) this.strg.decAktuelleTemperatur();
		this.jlAnzeige.setText(strg.aktuellerwert()+" - "+strg.gesendeterWert());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Heizung();
		
		
	}
}
