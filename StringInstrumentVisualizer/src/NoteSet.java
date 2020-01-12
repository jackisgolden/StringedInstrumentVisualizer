public class NoteSet {
	private int[] notes;
	private String name;

	public NoteSet(int[] notes, String name) {
		this.notes = notes;
		this.name = name;
	}

	public NoteSet() {

	}

	public int getLength() {
		return notes.length;
	}

	public int get(int i) {
		return notes[i];
	}
	
	public boolean containsNote(int i){
		for(int u : notes)
			if(i == u)
				return true;
		return false;
	}

	public String toString() {
		return name;
	}
}
