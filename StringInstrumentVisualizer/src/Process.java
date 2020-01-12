import processing.core.PApplet;

public class Process extends PApplet {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		PApplet.main("Process");
	}

	//NoteSet minorScale = new NoteSet({ 0, 2, 3, 5, 7, 8, 10 }, "Minor Scale");
	int[] majorScale = { 0, 2, 4, 5, 7, 9, 11 };
	int[] minorPent = { 0, 3, 5, 7, 10 };
	int[] majorPent = { 0, 2, 5, 7, 9 }; // these are rootless shapes. shift to align with different roots on guitar..
	int[] majorChord = { 0, 4, 7 };
	int[] minorChord = { 0, 3, 7 };
	int[] root = { 0 };

	String[] allNotes = { "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#" };

	int[] scale = majorScale; // ************CHOOSE YOUR SCALE**********************
	String scaleName = "Major Scale";
	int scaleStart = 0;

	int[] ukeN = { 5, 0, 8, 3 };
	int[] bassN = { 3, 10, 5, 0 };
	int[] guitarN = { 0, 7, 3, 10, 5, 0 }; // in reverse order because processing renders positive y downwards

	int[] instrument = guitarN; // ************CHOOSE YOUR INSTRUMENT**********************
	String instrumName = "Guitar";

	int startpointx, startpointy, lengthx, lengthy, nFrets; // 17 frets, 5 strings.

	public void settings() {
		size(1200, 600);
<<<<<<< HEAD
		background(0);
=======
		

>>>>>>> branch 'master' of https://github.com/jackisgolden/StringedInstrumentVisualizer
		nFrets = 17;
		startpointx = width / 12;
		startpointy = height / 4;

		lengthx = 10 * width / 12;
		lengthy = height / 2;
	}

	public void setup() {
		background(255);
		renderStrings();
		renderText();
	}

	public void draw() {
		renderNotes();
	}
	
	public void keyPressed()
	{
	  if(key == 'i'){  //switch instrument
	      
	  }
	  if(key == 's'){   //switch scale
	  
	  }
	  else if(key == CODED)     //left right arrow keys move KEY of song
	  {
	    scaleStart = (scaleStart + 1) % 12;
	  }
	  
	}

	public void renderStrings() {
		fill(255);
		stroke(255);
		for (int string = 0; string < instrument.length; string++) {
			int ycord = startpointy + string * lengthy / (instrument.length - 1);
			line(startpointx, ycord, startpointx + lengthx, ycord);
		}

		for (int fret = 0; fret < nFrets; fret++) {
			int xcord = startpointx + fret * lengthx / (nFrets - 1);
			if (fret == 0) {
				strokeWeight(5);
				line(xcord, startpointy, xcord, startpointy + lengthy);
				strokeWeight(1);

			}
			line(xcord, startpointy, xcord, startpointy + lengthy);
		}

		int[] markings = { 0, 5, 7, 9, 12 };
		int ycord = startpointy + lengthy / 2;
		for (int u : markings) {
			int xcord = startpointx + u * lengthx / (nFrets - 1) + lengthx / (nFrets * 2);
			noStroke();
			fill(255);
			ellipse(xcord, ycord, 5, 20);
		}
		stroke(1);
	}

	public void renderText() {
		textAlign(CENTER, CENTER);
		fill(255);
		textSize(20);
		for (int string = 0; string < instrument.length; string++) {
			int ycord = startpointy + string * lengthy / (instrument.length - 1);
			text(allNotes[instrument[string]], startpointx - 25, ycord);
		}
		textSize(20);
		text("Instrument: " + instrumName, 100, 20);

		textSize(40);
		text(allNotes[0] + " " + scaleName, width / 2, height / 8);
	}

	public void renderNotes() {
	      for (int string = 0; string < instrument.length; string++)
	          for (int fret = 0; fret < nFrets - 1; fret++)
	            for (int i = 0; i < scale.length; i++) {
	              if (scale[i] == (guitarN[string] + fret) % 12) {
	                int xcord = startpointx + fret * lengthx / (nFrets - 1) + lengthx/(nFrets * 2);
	                int ycord = startpointy + string * lengthy / (instrument.length - 1);
	                
	                if(xcord < mouseX + 2 * lengthx/17 && xcord > mouseX - 3*lengthx/17 && mouseY < startpointy + lengthy && mouseY > startpointy) //mouse must be inside fret board
	                 fill(0,255, 0);
	                if( (fret+ guitarN[string]) % 12 ==0)
	                  fill(255,0,0);
	                circle(xcord, ycord, 20);
	                fill(200);
	                break;
	              }
	            }
	}
}