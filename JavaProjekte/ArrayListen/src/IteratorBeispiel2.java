import java.util.*;

public class IteratorBeispiel2
{
	
	private int x,y,z;
	
  public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

public static void main(String[] args)
  {
    ArrayList<String> liste4 = new ArrayList<String>();
    ArrayList<Personen> personenListe = new ArrayList<Personen>();
    Personen person;
    liste4.add("ABC");
    liste4.add("Nachbar");
    liste4.add("Transfer");
    liste4.add("Oma");
    liste4.add("Niemand");
    IteratorBeispiel2 rechner = new IteratorBeispiel2();
    
    rechner.setX(10);
    rechner.setY(20);
    rechner.setZ(30);
    for(String s: liste4)
    {
    	
       person = new Personen();
       person.setNachName(s);
       person.setVorName("Paul");
       person.setAlter(12);
       personenListe.add(person);
    	
    }
    for(Personen x : personenListe){
    	System.out.println(x.toString());
    	System.out.println(Personen.binden(x.getVorName(),x.getNachName()));
    	System.out.println(x.binden(x.getNachName(), x.getVorName()));
    	System.out.println(Personen.rechner(rechner.getX(), rechner.getY())+rechner.getZ());
    	rechner.setX(rechner.getX()*2);
    	rechner.setY(rechner.getY()*2);
    	rechner.setZ(rechner.getZ()*2);
    	
    	
    }
   
    System.out.println(personenListe.get(3).getNachName());
    System.out.println("");
    
    for(Iterator<String> iterator = liste4.iterator(); iterator.hasNext(); )
    {
    	String x = iterator.next();
    	System.out.println(x);
      if (x.equals(""))
      {
        iterator.remove(); // entfernt das aktuelle Element
      }
      System.out.print(x.charAt(0));
    }
    // Ausgabe ist trotzdem ANTON!

    System.out.println(); // Zeilenumbruch

    System.out.println(liste4.size()); // 3
    for(String s: liste4)
    {
      System.out.println(s);
    }

  }
}