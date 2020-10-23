package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import dbmodel.DBmanager;
import dbmodel.benutzer;
import dbmodel.kommentar;
import dbmodel.themengebiet;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBmanager db = new DBmanager();
		Connection con = db.getConnection();
		System.out.println("ok");
		//benutzer Flo = new benutzer(1,"flostaudacher@gmail.com","Florian","Nachname","13456stau","NOT YOUR GLOBAL","A", false);
		Timestamp time = new Timestamp(0);
		//kommentar k = new kommentar(1,1,1,"kommentar durch java",time,15,false);
		themengebiet sport = new themengebiet(3,"programmieren");
		//db.speichereNeuenBenutzer(con, Flo);
		System.out.println("benutzer erzeugt");
		//db.speichereNeuenKommentar(con, k);
		System.out.println("kommentar erzeugt");
		db.benutzerAnmeldungIstOk(con, "flostaudacher@gmail.com", "13456stau");
		db.benutzerNicknameIstVorhanden(con, "flo");
		db.benutzerEmailIstVorhanden(con, "flostaudacher@gmail.com");
		db.leseAlleThemengebiete(con);
		db.leseArtikelVonThemenebiet(con, 1);
		db.leseKommentareZuArtikel(con, 1);
		db.releaseConnection(con);
	
	}

}
