package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String vorname;
	private String geschlaecht;
	private String email;
	private String passwort;
	private HashMap<String, String> chapterComplete;
	public User() {
		super();
	}
	
	public User(String name, String vorname, String geschlaecht, String email, String passwort) {
		this.name = name;
		this.vorname = vorname;
		this.geschlaecht = geschlaecht;
		this.email = email;
		this.passwort = passwort;
		this.chapterComplete = new HashMap<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getGeschlaecht() {
		return geschlaecht;
	}

	public void setGeschlaecht(String geschlaecht) {
		this.geschlaecht = geschlaecht;
	}

	public HashMap<String, String> getChapterComplete() {
		return chapterComplete;
	}

	public void setChapterComplete(HashMap<String, String> chapterComplete) {
		this.chapterComplete = chapterComplete;
	}
	
	
}
