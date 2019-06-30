package org.ismek.sorubankasi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ismek.sorubankasi.sinif.Ders;
import org.ismek.sorubankasi.sinif.Kullanici;
import org.ismek.sorubankasi.sinif.Secenek;
import org.ismek.sorubankasi.sinif.Soru;

public class DbIslemleri {

	public void dersEkle(Ders ders) {
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Insert Into Ders (adi) values (?)")) {
			prepareStatement.setString(1, ders.getAdi());
			boolean execute = prepareStatement.execute();
			System.out.println("Ders Eklendi");
		} catch (Exception e) {
			System.out.println("Ders Ekleme Hatasý =" + e.getMessage());
		}
	}
	
	public void dersGuncelle(int guncellenecekDersId, String yeniDersAdi) {
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Update Ders Set adi = ? Where id = ?")) {
			prepareStatement.setString(1, yeniDersAdi);
			prepareStatement.setInt(2, guncellenecekDersId);
			boolean execute = prepareStatement.execute();
			System.out.println("Ders Güncellendi");
		} catch (Exception e) {
			System.out.println("Ders Güncelleme Hatasý =" + e.getMessage());
		}
	}
	
	public List<Ders> getirDersListesi() {
		
		ArrayList<Ders> dersListesi = new ArrayList<Ders>();
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Select * from Ders")) {
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Ders ders = new Ders();
				ders.setId(resultSet.getInt(1));
				ders.setAdi(resultSet.getString(2));
				dersListesi.add(ders);
			}
		} catch (Exception e) {
			System.out.println("Ders Listeleme Hatasý =" + e.getMessage());
		}
		return dersListesi;
	}
	
	public void kullaniciEkle(Kullanici Kullanici) {
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Insert Into Kullanici (isim) values (?)")) {
			prepareStatement.setString(1, Kullanici.getIsim());
			boolean execute = prepareStatement.execute();
			System.out.println("Kullanici Eklendi");
		} catch (Exception e) {
			System.out.println("Kullanici Ekleme Hatasý =" + e.getMessage());
		}
	}
	
	public void kullaniciGuncelle(int guncellenecekKullaniciId, String yeniKullaniciAdi) {
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Update Kullanici Set isim = ? Where id = ?")) {
			prepareStatement.setString(1, yeniKullaniciAdi);
			prepareStatement.setInt(2, guncellenecekKullaniciId);
			boolean execute = prepareStatement.execute();
			System.out.println("Kullanici Güncellendi");
		} catch (Exception e) {
			System.out.println("Kullanici Güncelleme Hatasý =" + e.getMessage());
		}
	}
	
	public List<Kullanici> getirKullaniciListesi() {
		
		ArrayList<Kullanici> KullaniciListesi = new ArrayList<Kullanici>();
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Select * from Kullanici")) {
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Kullanici Kullanici = new Kullanici();
				Kullanici.setId(resultSet.getInt(1));
				Kullanici.setIsim(resultSet.getString(2));
				KullaniciListesi.add(Kullanici);
			}
		} catch (Exception e) {
			System.out.println("Kullanici Listeleme Hatasý =" + e.getMessage());
		}
		return KullaniciListesi;
	}
	
	public void soruEkle(Soru soru) {
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Insert Into Soru (metin, ders_id) values (?, ?)")) {
			prepareStatement.setString(1, soru.getMetin());
			prepareStatement.setInt(2, soru.getDers().getId());
			boolean execute = prepareStatement.execute();
			System.out.println("Soru Eklendi");
		} catch (Exception e) {
			System.out.println("Soru Ekleme Hatasý =" + e.getMessage());
		}
	}
	
	public List<Soru> getirSoruListesi() {
		
		ArrayList<Soru> soruListesi = new ArrayList<Soru>();
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("Select s.id, s.metin, d.id ders_id, d.adi from Soru s join ders d on s.ders_id = d.id")) {
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Soru soru = new Soru();
				soru.setId(resultSet.getInt("id"));
				soru.setMetin(resultSet.getString("metin"));
			
				Ders ders = new Ders();
				ders.setId(resultSet.getInt("ders_id"));
				ders.setAdi(resultSet.getString("adi"));
				soru.setDers(ders);
				
				soruListesi.add(soru);
			}
		} catch (Exception e) {
			System.out.println("Soru Listeleme Hatasý =" + e.getMessage());
		}
		return soruListesi;
	}
	
	public List<Secenek> getirSecenekListesi() {
		
		ArrayList<Secenek> secenekListesi = new ArrayList<Secenek>();
		Connection connection = Baglanti.baglantiOlustur();
		try (PreparedStatement prepareStatement = connection.prepareStatement("select s1.id, s1.metin, s1.kisa_kod kisaKod, s1.dogru, s2.id soru_id, s2. metin soru from secenek s1 join soru s2 on s1.soru_id = s2.id")) {
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Secenek secenek = new Secenek();
				secenek.setId(resultSet.getInt("id"));
				secenek.setMetin(resultSet.getString("metin"));
				secenek.setDogru(resultSet.getInt("dogru"));
				secenek.setKisaKod(resultSet.getString("kisaKod"));
			
				Soru soru = new Soru();
				soru.setId(resultSet.getInt("soru_id"));
				soru.setMetin(resultSet.getString("soru"));
				secenek.setSoru(soru);
				
				secenekListesi.add(secenek);
			}
		} catch (Exception e) {
			System.out.println("Secenek Listeleme Hatasý =" + e.getMessage());
		}
		return secenekListesi;
	}
}
