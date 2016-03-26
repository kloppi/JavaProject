import java.util.ArrayList;


public class ExtendsBeispiel extends Personen{

	public ExtendsBeispiel(){
	ArrayList<Personen> liste = new ArrayList<Personen>();
		
	Personen p =new Personen();
	setAlter(10);
	setVorName("Eike");
	setNachName("Klopfleisch");
	p =new Personen(this.getPersonen());
	liste.add(p);

	setAlter(12);
	setVorName("Ramona");
	setNachName("Klopfleisch");
	
	liste.add(getPersonen());
	p =new Personen();
	p.setAlter(14);
	p.setVorName("Florian");
	p.setNachName("Klopfleisch");
	liste.add(p.getPersonen());
	liste.add(1,p);
	for (Personen x:liste){
//		System.out.println(x.toString());
	}
		System.out.println(binden("a","b"));
		Object[] o = liste.toArray();
	for (Object q:liste){
		System.out.println(q);
	}
	}
	
	
	
	public static void main(String[] args) {
		new ExtendsBeispiel();
	}
	
}
