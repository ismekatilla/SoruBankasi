package org.ismek.sorubankasi.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Baglanti {

	public static Connection baglantiOlustur() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/soru_bankasi?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"root", "1234");
			return con;
		} catch (Exception e) {
			System.out.println("Baðlantý bilgileri hatalý olabilir. Kontrol ediniz." + e.getMessage());
		}
		return null;
	}
}