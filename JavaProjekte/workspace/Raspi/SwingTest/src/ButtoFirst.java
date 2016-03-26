package de.sdek;

import javax.swing.*;


public class ButtonFirst extends JFrame{  
JFrame f;  

ButtonFirst(){        
JButton b=new JButton("click");//creating instance of JButton  
b.setBounds(130,100,100, 40);  
add(b);//adding button in JFrame          

setSize(400,500);//400 width and 500 height  
setLayout(null);//using no layout managers

setVisible(true);//making the frame visible  

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

}  
  
public static void main(String[] args) {  
new FirstSwingExample();  
}  
}  
