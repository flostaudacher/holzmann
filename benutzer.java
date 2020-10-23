package dbmodel;

public class benutzer {
	private int Benutzerid;
	private String email;
	private String vorname;
	private String nachname;
	private String passwort;
	private String nickname;
	private String usergroup;
	private boolean gesperrt;
	public benutzer(int benutzerid, String email, String vorname, String nachname, String passwort, String nickname,
			String usergroup, boolean gesperrt) {
		super();
		Benutzerid = benutzerid;
		this.email = email;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.nickname = nickname;
		this.usergroup = usergroup;
		this.gesperrt = gesperrt;
	}
	public benutzer() {
		super();
		Benutzerid = -1;
		this.email = "";
		this.vorname = "";
		this.nachname = "";
		this.passwort = "";
		this.nickname = "";
		this.usergroup = "";
		this.gesperrt = true;
	}
	@Override
	public String toString() {
		return "benutzer [Benutzerid=" + Benutzerid + ", email=" + email + ", vorname=" + vorname + ", nachname="
				+ nachname + ", passwort=" + passwort + ", nickname=" + nickname + ", usergroup=" + usergroup
				+ ", gesperrt=" + gesperrt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Benutzerid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (gesperrt ? 1231 : 1237);
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((passwort == null) ? 0 : passwort.hashCode());
		result = prime * result + ((usergroup == null) ? 0 : usergroup.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		benutzer other = (benutzer) obj;
		if (Benutzerid != other.Benutzerid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gesperrt != other.gesperrt)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (passwort == null) {
			if (other.passwort != null)
				return false;
		} else if (!passwort.equals(other.passwort))
			return false;
		if (usergroup == null) {
			if (other.usergroup != null)
				return false;
		} else if (!usergroup.equals(other.usergroup))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	public int getBenutzerid() {
		return Benutzerid;
	}
	public void setBenutzerid(int benutzerid) {
		Benutzerid = benutzerid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}
	public boolean isGesperrt() {
		return gesperrt;
	}
	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}
	
}
