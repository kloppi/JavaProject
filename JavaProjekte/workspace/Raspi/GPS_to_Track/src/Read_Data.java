
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
public class Read_Data {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		//PathSelect path = new PathSelect();
		
		String datum ="GPRMC_111115";
		StringBuffer TrackDaten =new StringBuffer("");
			
		FileReader infile = new FileReader("c:\\daten\\GPSTest\\Head.txt");
		Scanner indata = new Scanner(infile);
		System.out.println("read Head");
		
		while (indata.hasNextLine())
		{
			TrackDaten.append(indata.nextLine());
		}
		infile.close();
		indata.close();
		System.out.println("read Body");
		infile = new FileReader("c:\\daten\\GPSTest\\datenlog\\TripToFlorida\\"+datum+".txt");
		indata = new Scanner(infile);
		while (indata.hasNextLine())
        {
			System.out.println("read Line");
        	wandlung wandeln = new wandlung(indata.nextLine());
        	System.out.println("read LineReady");
            TrackDaten.append(wandeln.getLaenge()+","+wandeln.getBreite()+",0"+'\n');
            System.out.println("read Wandeln ready");
        }
		System.out.println("read Daten");
        infile.close();
        indata.close();
        infile = new FileReader("c:\\daten\\GPSTest\\Feed.txt");
        indata = new Scanner(infile);
		while (indata.hasNextLine())
		{
			TrackDaten.append(indata.nextLine());
		}
		infile.close();
		indata.close();
		 PrintWriter pWriter = new PrintWriter(new FileWriter("c:\\daten\\GPSTest\\datenlog\\TripToFlorida\\"+datum+".kml"));
         pWriter.println(TrackDaten.toString());
         pWriter.flush(); 
         pWriter.close();
		}catch (IOException e){
			System.out.println("Fehler beim Öffnen");
		}
	}

	
	public static class wandlung{
		String tDate, tBreite, tLaenge;
		Double dBreite, dLaenge;
		
		wandlung(String z){
			StringBuffer zeile = new StringBuffer(z);
			
			//tDate =zeile.substring(1,6);
			tDate =zeile.substring(7,13);
			System.out.println(tDate);
			//tBreite = zeile.substring(11, 20);
			tBreite = zeile.substring(20, 29);
			//tLaenge = zeile.substring(23, 33);
			tLaenge = zeile.substring(32, 42);
		}
		
		public String getBreite(){
			return umrechnung(2,tBreite);
		}
		
		public String getLaenge(){
			return "-"+umrechnung(3,tLaenge);
		}
		
		private String umrechnung(int x,String art){
			StringBuffer tmp = new StringBuffer(art);
			dBreite = Double.parseDouble(tmp.substring(x,7+x));
			System.out.println("vorher " +dBreite.toString());
			dBreite /=60;
			BigDecimal myDec = new BigDecimal(dBreite);
			myDec = myDec.setScale( 6, BigDecimal.ROUND_HALF_UP );
			StringBuffer tmp2 = new StringBuffer(myDec.toString());
			if (tmp2.length()<8){ 
				return tmp.substring(0, x)+"."+tmp2.substring(2,tmp2.length());}
			else{
				return tmp.substring(0, x)+"."+tmp2.substring(2);
			}
		}
	}
}

















