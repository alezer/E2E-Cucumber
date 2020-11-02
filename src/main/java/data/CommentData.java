package data;

import java.util.Date;

public class CommentData {
	String comment;
	
	public CommentData() {
		comment = "Unique comment - " + new Date();
	}
	
	public String getComment() {
		return comment;
	}
}