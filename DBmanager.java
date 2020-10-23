package dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class DBmanager {
	public Connection getConnection() 
			throws ClassNotFoundException, SQLException {

		Connection con = null;		
		Class.forName("com.mysql.jdbc.Driver");		
		con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/swp?serverTimezone=UTC&useSSL=false",  // DB
				"root",                                 // User
				"13456stau"                                      // Passwort
				);
		return con;
	}
	public void releaseConnection (Connection con) 
			throws SQLException {

		if (con != null)
			con.close();	
	}
	public boolean benutzerAnmeldungIstOk(Connection con, String email, String pwd) throws SQLException{
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null; 
		try {
			String sql = "select count(*) from benutzer where email = ? and passwort = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, pwd);
			rs = stm.executeQuery();
			if (rs.next()) {
				int anzahl = rs.getInt(1);
				result = anzahl == 1;
			}
		}
		finally {
			if (stm != null) {
				stm.close();
			}
		}
		return result;
	}
	public void speichereNeuenBenutzer(Connection con, benutzer b) 
			throws SQLException {
		String sql = "insert into benutzer (email, vorname, nachname, passwort, nickname, usergroup, gesperrt) values (?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, b.getEmail());
			stm.setString(2, b.getVorname());
			stm.setString(3, b.getNachname());
			stm.setString(4, b.getPasswort());
			stm.setString(5, b.getNickname());
			stm.setString(6, b.getUsergroup());
			stm.setBoolean(7, b.isGesperrt());			
			stm.executeUpdate();
		}
		finally {
			if (stm != null)
				stm.close();
		}
	}
	public boolean benutzerEmailIstVorhanden(Connection con, String email) throws SQLException{
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null; 
		try {
			String sql = "select count(*) from benutzer where email = ? ";
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			rs = stm.executeQuery();
			if (rs.next()) {
				int anzahl = rs.getInt(1);
				result = anzahl == 1;
			}
		}
		finally {
			if (stm != null) {
				stm.close();
			}
		}
		return result;
	}
	public boolean benutzerNicknameIstVorhanden(Connection con, String nickname) throws SQLException{
		boolean result = false;
		PreparedStatement stm = null;
		ResultSet rs = null; 
		try {
			String sql = "select count(*) from benutzer where nickname = ? ";
			stm = con.prepareStatement(sql);
			stm.setString(1, nickname);
			rs = stm.executeQuery();
			if (rs.next()) {
				int anzahl = rs.getInt(1);
				result = anzahl == 1;
			}
		}
		finally {
			if (stm != null) {
				stm.close();
			}
		}
		return result;
	}
	public ArrayList<themengebiet> leseAlleThemengebiete (Connection con) throws SQLException{
		PreparedStatement stm = null;
		ResultSet rs = null; 
		ArrayList<themengebiet> result= new ArrayList<themengebiet>();
		try {
			String sql = "select * from themengebiete";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				int themengebietid = rs.getInt(1);
				String themengebiete = rs.getString(2);
				themengebiet a = new themengebiet(themengebietid, themengebiete);
				result.add(a);
			}
		}finally {
			if (stm !=null) {
				stm.close();
			}
		}
		return result;
	}
	public ArrayList<artikle> leseArtikelVonThemenebiet (Connection con, int themengebietID)
			throws SQLException{
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<artikle> result = new ArrayList<artikle>();
		try {
			String sql = "select artikleID, autorID, kopfzeile, zusammenfassung, artikelText, istgesperrt from artikle where themengebietID = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, themengebietID);
			rs = stm.executeQuery();
			while(rs.next()) {
				int artikeID = rs.getInt(1);
				int autorID = rs.getInt(2);
				String kopfzeile = rs.getString(3);
				String zusammenfassung = rs.getString(4);
				String artikelText = rs.getString(5);
				boolean istgesperrt = rs.getBoolean(6);
				artikle a = new artikle(artikeID,autorID,themengebietID,kopfzeile,zusammenfassung,artikelText,istgesperrt);
				result.add(a);
			}
		}
		finally
		{
			if(stm != null)
				stm.close();
		}
		return result;	
	}
	public void speichereNeuenKommentar(Connection con, kommentar k) throws SQLException {
		String sql = "Insert into kommentare (vonBenutzerId,zuArtikleId,kommentar,zuKommentarId) values(?,?,?,?);";
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, k.getVonBenutzerId());
			stm.setInt(2, k.getZuArtikelId());
			stm.setString(3, k.getKommentar());
			stm.setInt(4, k.getZuKommentarId());
			stm.executeUpdate();
		}
		finally {
			if(stm != null) {
				stm.close();
			}
		}
	}
	public ArrayList<kommentar> leseKommentareZuArtikel (Connection con, int artikelid)
			throws SQLException{
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<kommentar> result = new ArrayList<kommentar>();
		try {
			String sql ="select"+
						"	kommentarId, vonBenutzerId, zuArtikleId, "+
						"	kommentar, zeitpunkt, zuKommentarId, istgesperrt"+
						"	from kommentare where zuArtikleId = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, artikelid);
			rs = stm.executeQuery();
			while(rs.next()) {
			int kommentarid = rs.getInt(1);
			int vonbenutzerid = rs.getInt(2);
			int zuartikelid = rs.getInt(3);
			String kommentar = rs.getString(4);
			Timestamp zeitpunkt = rs.getTimestamp(5);
			int zukommentarid = rs.getInt(6);
			boolean istgesperrt = rs.getBoolean(7);
			kommentar a = new kommentar(kommentarid, vonbenutzerid, zuartikelid, kommentar, zeitpunkt, zukommentarid, istgesperrt);
			result.add(a);
			}
		}
		finally
		{
			if(stm != null)
				stm.close();
		}
		return result;
	}
}









