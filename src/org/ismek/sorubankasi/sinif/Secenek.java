package org.ismek.sorubankasi.sinif;

public class Secenek {

	private int id;
	private String metin;
	private String kisaKod;
	private Soru soru;
	private int dogru;

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

	public String getKisaKod() {
		return kisaKod;
	}

	public void setKisaKod(String kisaKod) {
		this.kisaKod = kisaKod;
	}

	public Soru getSoru() {
		return soru;
	}

	public void setSoru(Soru soru) {
		this.soru = soru;
	}

	public int getDogru() {
		return dogru;
	}

	public void setDogru(int dogru) {
		this.dogru = dogru;
	}
}