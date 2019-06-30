package org.ismek.sorubankasi;

import java.util.List;
import java.util.Scanner;

import org.ismek.sorubankasi.db.DbIslemleri;
import org.ismek.sorubankasi.sinif.Ders;
import org.ismek.sorubankasi.sinif.Kullanici;
import org.ismek.sorubankasi.sinif.Secenek;
import org.ismek.sorubankasi.sinif.Soru;

public class Program {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		boolean cikis = true;
		while (cikis) {
			System.out.println("<��lem Se�iniz>");
			System.out.println(
						"1. Ders Ekle\n"
					+	"2. Ders G�ncelle\n"
					+	"3. Ders Listele\n"
					+ 	"4. Soru Ekle\n"
					+ 	"5. Soru G�ncelle\n"
					+ 	"6. Se�enek Ekle\n"
					+ 	"7. Se�enek G�ncelle\n"
					+ 	"8. Kullan�c� Ekle\n"
					+ 	"9. Kullan�c� G�ncelle\n"
					+ 	"10. Kullan�c� Listele\n"
					+ 	"11. Soru Listele\n"
					+ 	"12. Se�enek Listele\n"
					+	"0. ��k��");

			int secim = scanner.nextInt();
			switch (secim) {
			case 0:
				cikis = false;
				break;
			case 1:
				dersEkle();
				break;
			case 2:
				dersGuncelle();
				break;
			case 3:
				dersListele();
				break;
			case 4:
				soruEkle();
				break;
			case 8:
				kullaniciEkle();
				break;
			case 9:
				kullaniciGuncelle();
				break;
			case 10:
				kullaniciListele();
				break;
			case 11:
				soruListele();
				break;
			case 12:
				secenekListele();
				break;
			default:
				break;
			}
		}
		
		scanner.close();
	}

	private static void soruGuncelle() {
		
				
	}
	
	private static void dersListele() {
		DbIslemleri dbIslemleri = new DbIslemleri();
		List<Ders> dersList = dbIslemleri.getirDersListesi();
		System.out.println("ID\tDERS ADI");
		for (Ders ders : dersList) {
			System.out.println(ders.getId() + "\t" + ders.getAdi());
		}
	}

	private static void dersGuncelle() {
		dersListele();
		
		System.out.print("G�ncellemek istedi�iniz dersin ID si = ");
		int dersId = scanner.nextInt();
		
		System.out.println("Yeni Ders Ad� = ");
		String yeniDersAdi = scanner.nextLine();
		yeniDersAdi = scanner.nextLine();
		
		DbIslemleri dbIslemleri = new DbIslemleri();
		dbIslemleri.dersGuncelle(dersId, yeniDersAdi);
		
	}

	private static void dersEkle() {
		System.out.print("Yeni eklenecek ders = ");
		String dersAdi = scanner.nextLine();
		dersAdi = scanner.nextLine();
		
		Ders ders = new Ders();
		ders.setAdi(dersAdi);
		
		DbIslemleri dbIslemleri = new DbIslemleri();
		dbIslemleri.dersEkle(ders);
	}
	
	private static void kullaniciListele() {
		DbIslemleri dbIslemleri = new DbIslemleri();
		List<Kullanici> kullaniciList = dbIslemleri.getirKullaniciListesi();
		System.out.println("ID\tDERS ADI");
		for (Kullanici kullanici : kullaniciList) {
			System.out.println(kullanici.getId() + "\t" + kullanici.getIsim());
		}
	}

	private static void kullaniciGuncelle() {
		kullaniciListele();
		
		System.out.print("G�ncellemek istedi�iniz kullaniciin ID si = ");
		int kullaniciId = scanner.nextInt();
		
		System.out.println("Yeni Kullanici Ad� = ");
		String yeniKullaniciAdi = scanner.nextLine();
		yeniKullaniciAdi = scanner.nextLine();
		
		DbIslemleri dbIslemleri = new DbIslemleri();
		dbIslemleri.kullaniciGuncelle(kullaniciId, yeniKullaniciAdi);
		
	}

	private static void kullaniciEkle() {
		System.out.print("Yeni eklenecek kullanici = ");
		String kullaniciAdi = scanner.nextLine();
		kullaniciAdi = scanner.nextLine();
		
		Kullanici kullanici = new Kullanici();
		kullanici.setIsim(kullaniciAdi);
		
		DbIslemleri dbIslemleri = new DbIslemleri();
		dbIslemleri.kullaniciEkle(kullanici);
	}

	
	private static void soruListele() {
		DbIslemleri dbIslemleri = new DbIslemleri();
		List<Soru> soruList = dbIslemleri.getirSoruListesi();
		System.out.println("ID\tSORU\t\t\tDERS_ID\tDERS");
		for (Soru soru : soruList) {
			System.out.println(soru.getId() + "\t" + soru.getMetin() + "\t\t\t" + soru.getDers().getId() + "\t" + soru.getDers().getAdi());
		}
	}
	
	private static void soruEkle() {
		System.out.print("Yeni eklenecek soru = ");
		String soruAdi = scanner.nextLine();
		soruAdi = scanner.nextLine();

		dersListele();
		System.out.print("Ders Se�iniz = ");
		int dersId = scanner.nextInt();
		
		Ders ders = new Ders();
		ders.setId(dersId);
		
		Soru soru = new Soru();
		soru.setMetin(soruAdi);
		soru.setDers(ders);
		
		DbIslemleri dbIslemleri = new DbIslemleri();
		dbIslemleri.soruEkle(soru);
	}
	
	private static void secenekListele() {
		DbIslemleri dbIslemleri = new DbIslemleri();
		List<Secenek> secenekList = dbIslemleri.getirSecenekListesi();
		System.out.println("SORU\t\t\tSE�ENEK\t\t\tDO�RU\t");
		for (Secenek secenek : secenekList) {
			System.out.println(secenek.getSoru().getMetin() + "\t\t\t" + secenek.getMetin() + "\t\t" + secenek.getDogru());
		}
	}
}
