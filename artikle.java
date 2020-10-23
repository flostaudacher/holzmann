package dbmodel;

public class artikle {
	private int artikeID;
	private int autorID;
	private int themengebietID;
	private String kopfzeile;
	private String zusammenfassung;
	private String artikelText;
	private boolean istgesperrt;
	public artikle() {
		super();
		this.artikeID = -1;
		this.autorID = -1;
		this.themengebietID = -1;
		this.kopfzeile = "";
		this.zusammenfassung = "";
		this.artikelText = "";
		this.istgesperrt = true;
	}
	public artikle(int artikeID, int autorID, int themengebietID, String kopfzeile, String zusammenfassung,
			String artikelText, boolean istgesperrt) {
		super();
		this.artikeID = artikeID;
		this.autorID = autorID;
		this.themengebietID = themengebietID;
		this.kopfzeile = kopfzeile;
		this.zusammenfassung = zusammenfassung;
		this.artikelText = artikelText;
		this.istgesperrt = istgesperrt;
	}
	@Override
	public String toString() {
		return "artikle [artikeID=" + artikeID + ", autorID=" + autorID + ", themengebietID=" + themengebietID
				+ ", kopfzeile=" + kopfzeile + ", zusammenfassung=" + zusammenfassung + ", artikelText=" + artikelText
				+ ", istgesperrt=" + istgesperrt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artikeID;
		result = prime * result + ((artikelText == null) ? 0 : artikelText.hashCode());
		result = prime * result + autorID;
		result = prime * result + (istgesperrt ? 1231 : 1237);
		result = prime * result + ((kopfzeile == null) ? 0 : kopfzeile.hashCode());
		result = prime * result + themengebietID;
		result = prime * result + ((zusammenfassung == null) ? 0 : zusammenfassung.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		artikle other = (artikle) obj;
		if (artikeID != other.artikeID)
			return false;
		if (artikelText == null) {
			if (other.artikelText != null)
				return false;
		} else if (!artikelText.equals(other.artikelText))
			return false;
		if (autorID != other.autorID)
			return false;
		if (istgesperrt != other.istgesperrt)
			return false;
		if (kopfzeile == null) {
			if (other.kopfzeile != null)
				return false;
		} else if (!kopfzeile.equals(other.kopfzeile))
			return false;
		if (themengebietID != other.themengebietID)
			return false;
		if (zusammenfassung == null) {
			if (other.zusammenfassung != null)
				return false;
		} else if (!zusammenfassung.equals(other.zusammenfassung))
			return false;
		return true;
	}
	public int getArtikeID() {
		return artikeID;
	}
	public void setArtikeID(int artikeID) {
		this.artikeID = artikeID;
	}
	public int getAutorID() {
		return autorID;
	}
	public void setAutorID(int autorID) {
		this.autorID = autorID;
	}
	public int getThemengebietID() {
		return themengebietID;
	}
	public void setThemengebietID(int themengebietID) {
		this.themengebietID = themengebietID;
	}
	public String getKopfzeile() {
		return kopfzeile;
	}
	public void setKopfzeile(String kopfzeile) {
		this.kopfzeile = kopfzeile;
	}
	public String getZusammenfassung() {
		return zusammenfassung;
	}
	public void setZusammenfassung(String zusammenfassung) {
		this.zusammenfassung = zusammenfassung;
	}
	public String getArtikelText() {
		return artikelText;
	}
	public void setArtikelText(String artikelText) {
		this.artikelText = artikelText;
	}
	public boolean isIstgesperrt() {
		return istgesperrt;
	}
	public void setIstgesperrt(boolean istgesperrt) {
		this.istgesperrt = istgesperrt;
	}
}
