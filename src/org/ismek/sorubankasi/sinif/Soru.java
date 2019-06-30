package org.ismek.sorubankasi.sinif;

public class Soru {

	private int id;
	private String metin;
	private Ders ders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetin() {
		return metin;
	}

	public void setMetin(String metin) {
		this.metin = metin;
	}

	public Ders getDers() {
		return ders;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}
}