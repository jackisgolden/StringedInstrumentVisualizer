import processing.core.PApplet;

public class Process extends PApplet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		PApplet.main("Process");
	}
	
	int[] minorScale = {0, 2, 3, 5, 7, 8, 10};
	int[] majorScale = {0, 2, 4, 5, 7, 9, 11};
	int[] minorPent = {0, 3, 5, 7, 10};
	int[] majorPent = {0, 2, 5, 7, 9};    //these are rootless shapes. shift to align with different roots on guitar.
	int[] scale = minorScale;

	int[] guitarN = {0, 5, 10, 3, 7, 0};   //arbitrarily chose E as base
	int[] bassN = {0, 5, 10, 3};
	int[] ukeN = {3, 9, 0, 5};
	int[] instrument = guitarN;

	public void settings() {
		size(1000,500);
	}
	public void setup(){
	    renderBoard();
	}

	public void draw(){
	  renderNotes();
	  
	}

	void renderBoard(){
	  int startpointx = width/ 4;
	  int startpointy = height/4;
	  
	  for(int string = 0; string < 6; string++)
	     line(startpointx, startpointy + (string / 5) * (width / 2) , startpointx + width /2, startpointy + (string / 5) * (width / 2));
	  for(int fret = 0; fret < 18; fret++)
	       line(startpointx + (fret / 17) * (height / 2), startpointy, startpointx + (fret / 17) * (height / 2), startpointy + height/2);
	}

	void renderNotes(){
	  for(int string = 0; string < 7; string++)
	    for(int fret = 0; fret < 17; fret++)
	        for(int i = 0; i < scale.length; i++) {
	          if(scale[i]==(guitarN[string] + fret) % 12 ) {
	                //circle();
	              break;
	        }
	    }
	  
	}
}
