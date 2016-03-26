package test;

import java.io.File;

import javax.swing.JFileChooser;

public class PathSelect {
	
	public PathSelect(){ 
	JFileChooser fc = new JFileChooser();
	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	int returnVal = fc.showOpenDialog(null);
	File f;
	if (returnVal == JFileChooser.APPROVE_OPTION)
	 {
	 f = fc.getSelectedFile();
	 System.out.println(f.getPath());
	 }}
}
