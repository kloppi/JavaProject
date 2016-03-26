import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class RadioExample extends JFrame implements ActionListener{
	JFrame f;  
	JButton wandeln,pfadread;	
	JRadioButton r1;
	JRadioButton r2;
	JPanel panel;
	JLabel label;
	JTextField pfad;
	RadioExample(){  
	f=new JFrame();  
	//panel = new JPanel();
	label = new JLabel("Pfadeinagbe");
	label.setBounds(10, 10, 80, 30);
	label.setVisible(true);

	f.add(label);
	
	r1=new JRadioButton("Male");  
	r2=new JRadioButton("FeMale");  
	r1.setBounds(50,100,70,30);  
	r2.setBounds(50,130,70,30);  

	
	ButtonGroup bg=new ButtonGroup();  
	bg.add(r1);bg.add(r2);  
	
	wandeln = new JButton();
	wandeln.setText("Click");
	wandeln.addActionListener(this);
	
	wandeln.setBounds(50,170,70,30);
	f.add(wandeln);
	
	
	pfad = new JTextField("Eike",15);
	pfad.setBounds(90, 10, 80, 30);
	pfad.setVisible(true);
//	panel.add(pfad);
	
	f.add(pfad);
	
	f.add(r1);f.add(r2);  
	
	f.setSize(600,600);  
	f.setLayout(null);  
	f.setVisible(true);  
	}  
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,pfad.getText());
		if(r1.isSelected()){  
			JOptionPane.showMessageDialog(this,"You are male");  
			r2.setSelected(true);
			}  
			if(r2.isSelected()){  
			JOptionPane.showMessageDialog(this,"You are female");  
			r1.setSelected(true);
			}  
		System.out.println("Button push");
		
		wandeln.setText("danke");
	}  
	public static void main(String[] args) {  
	    new RadioExample();  
	    
	}
	
}
