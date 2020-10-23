package dbmodel;

import java.sql.Timestamp;

public class kommentar {
	private int kommentarId;
	private int vonBenutzerId;
	private int zuArtikelId;
	private String kommentar;
	private Timestamp zeitpunkt;
	private int zuKommentarId;
	private boolean istgesperrt;
	public kommentar() {
		super();
		this.kommentarId = -1;
		this.vonBenutzerId = -1;
		this.zuArtikelId = -1;
		this.kommentar = "";
		this.zeitpunkt =null;
		this.zuKommentarId = -1;
		this.istgesperrt = true;
		// TODO Auto-generated constructor stub
	}
	public kommentar(int kommentarId, int vonBenutzerId, int zuArtikelId, String kommentar, Timestamp zeitpunkt,
			int zuKommentarId, boolean istgesperrt) {
		super();
		this.kommentarId = kommentarId;
		this.vonBenutzerId = vonBenutzerId;
		this.zuArtikelId = zuArtikelId;
		this.kommentar = kommentar;
		this.zeitpunkt = zeitpunkt;
		this.zuKommentarId = zuKommentarId;
		this.istgesperrt = istgesperrt;
	}
	public int getKommentarId() {
		return kommentarId;
	}
	public void setKommentarId(int kommentarId) {
		this.kommentarId = kommentarId;
	}
	public int getVonBenutzerId() {
		return vonBenutzerId;
	}
	public void setVonBenutzerId(int vonBenutzerId) {
		this.vonBenutzerId = vonBenutzerId;
	}
	public int getZuArtikelId() {
		return zuArtikelId;
	}
	public void setZuArtikelId(int zuArtikelId) {
		this.zuArtikelId = zuArtikelId;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public Timestamp getZeitpunkt() {
		return zeitpunkt;
	}
	public void setZeitpunkt(Timestamp zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}
	public int getZuKommentarId() {
		return zuKommentarId;
	}
	public void setZuKommentarId(int zuKommentarId) {
		this.zuKommentarId = zuKommentarId;
	}
	public boolean isIstgesperrt() {
		return istgesperrt;
	}
	public void setIstgesperrt(boolean istgesperrt) {
		this.istgesperrt = istgesperrt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (istgesperrt ? 1231 : 1237);
		result = prime * result + ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result + kommentarId;
		result = prime * result + vonBenutzerId;
		result = prime * result + ((zeitpunkt == null) ? 0 : zeitpunkt.hashCode());
		result = prime * result + zuArtikelId;
		result = prime * result + zuKommentarId;
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
		kommentar other = (kommentar) obj;
		if (istgesperrt != other.istgesperrt)
			return false;
		if (kommentar == null) {
			if (other.kommentar != null)
				return false;
		} else if (!kommentar.equals(other.kommentar))
			return false;
		if (kommentarId != other.kommentarId)
			return false;
		if (vonBenutzerId != other.vonBenutzerId)
			return false;
		if (zeitpunkt == null) {
			if (other.zeitpunkt != null)
				return false;
		} else if (!zeitpunkt.equals(other.zeitpunkt))
			return false;
		if (zuArtikelId != other.zuArtikelId)
			return false;
		if (zuKommentarId != other.zuKommentarId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "kommentar [kommentarId=" + kommentarId + ", vonBenutzerId=" + vonBenutzerId + ", zuArtikelId=" + zuArtikelId
				+ ", kommentar=" + kommentar + ", zeitpunkt=" + zeitpunkt + ", zuKommentarId=" + zuKommentarId
				+ ", istgesperrt=" + istgesperrt + "]";
	}

}
