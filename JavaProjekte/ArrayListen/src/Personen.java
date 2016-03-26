
public class  Personen {
	private String nachName;
	private String vorName;
	private int alter;
	
	
	public Personen() {
		super();
	}


	public Personen(String nachName) {
		super();
		this.nachName = nachName;
	}

	
	public Personen(String nachName, String vorName, int alter) {
		super();
		this.nachName = nachName;
		this.vorName = vorName;
		this.alter = alter;
	}
	public Personen(Personen p){
		this.nachName = p.getNachName();
		this.vorName = p.getVorName();
		this.alter = p.getAlter();
	}

	@Override
	public String toString() {
		return "Personen [nachName=" + nachName + ", vorName=" + vorName
				+ ", alter=" + alter + ", getNachName()=" + getNachName() + "]";
	}
	public static String binden(String a, String b){
		return a+" "+b;
	}
	public static int rechner(int a,int b){
		return a+b;
	}
	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}
	public Personen getPersonen(){
		return this;
	}
	
}
