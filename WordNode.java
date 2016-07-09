package assignment3;

public class WordNode {
	boolean visitRecord;
	String word;

	public WordNode() {

	}

	public WordNode(String word) {
		this.word = word;
	}

	public void SetFlag(){
		visitRecord=true;
	}

	public String GetString() {
		return word;

	}
	
	public boolean GetFlag(){
		return visitRecord;
	}
}
