package com.example.yarimizuverse.pojo;

public class Note {

	private int id;
	private String note;
	private String lastupdate;
	
	public Note(int id, String note, String lastupdate) {
		this.id = id;
		this.note = note;
		this.lastupdate = lastupdate;
	}
	
	public int getId() {
		return id;
	}
	public String getNote() {
		return note;
	}
	public String getLastupdate() {
		return lastupdate;
	}
}
