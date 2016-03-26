package de.hpi.javaide.firststeps;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Game extends PApplet {
	
	// Aufgabe 2: Ändere den Code so ab, dass das Rechteck sich von der linken oberen Ecke in die rechte untere Ecke bewegt.
	
	// Um eine Bewegung zu erzeugen brauchen wir zunächst variable Werte
	private int x;
	private int y;
	
	
	@Override
	public void setup() {
		// in der Setup Methode setzen wir die initialen Werte
		// Die Position 0/0 entspricht der linken oberen Ecke des Fensters
		this.x = 0;
		this.y = 0;
		
		// Hier zeichnen wir das Rechteck zum ersten Mal. 
		// Um den Code wenigstens etwas zu strukturieren haben wir dabei die Befehle in eine Methode verpackt, die wir nun an verschiedenen Stellen aufrufen können.
		// Dieser erste Aufruf an dieser Stelle, ist allerdings zugegebenermaßen nicht wirklich notwendig.
		drawRect(this.x , this.y);
	}

	/**
	 * Die von der PApplet Klasse (aus der Processing core.jar) geerbte draw() Methode wird hier überschrieben.
	 * Um den Aufruf dieser Methode muss ich mich nicht kümmern, dass übernimmt Processing für mich.
	 */
	@Override
	public void draw() {
		// Um dafür zu sorgen, dass sich das Rechteck tatsächlich bewegt, muss auch der Hintergrund immer wieder neu gemalt werden.
		background(0);
		
		// Der Wert der x/y Position wird bei jedem Aufruf der draw() Methode um 1 erhöht. 
		// Gezeigt werden 3 alternative Schreibweisen.
		this.x = this.x + 1;
		this.y += 1;
		//this.y++;
		
		// Das Rechteck wird immer wieder neu gezeichnet
		drawRect(this.x , this.y);
		
		//Wenn das Rechteck den rechten unteren Rand erreicht hat, wird die Animation gestoppt
		//this.width ist ein Wert der von Processing gesetzt wird. Mittels der size() Methode lässt sich die Größe des Fensters ändern.
		//this.width, this.height werden dadurch automatisch angepasst.
		//Die -10 ergibt sich aus der Breite des Rechtecks. Sauberer wäre es natürlich auch hier den Wert in einer Variablen oder Konstanten zu speichern. 
		//if (this.y > this.width - 10) {
			//noLoop() stoppt die Ausführung der draw() Methode
			//noLoop();
		//}
	}
	
	/**
	 * Die drawRect Methode zeichnet ein rotes Rechteck ohne Rand an der übergebenen x/y Position
	 * 
	 * @param x die x Position des Rechtecks als Ganzzahl (Integer)
	 * @param y die y Position des Rechtecks als Ganzzahl (Integer)
	 */
	private void drawRect(int x, int y) {
		noStroke();
		fill(255, 10, 10);
		rectMode(CORNER);
		// Die übergebenen x/y Werte werden an den Aufruf der Processing Methode zum Zeichnen eines Rechtecks weiter gegeben.
		rect(x, y, 10, 10);
	}
	
}
