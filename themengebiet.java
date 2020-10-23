package dbmodel;

public class themengebiet {
	private int themengebietID;
	private String themengebiete;
	
	public themengebiet() {
		super();
		this.themengebietID = -1;
		this.themengebiete = "";
	}
	public themengebiet(int themengebietid, String themengebiet) {
		super();
		this.themengebietID = themengebietid;
		this.themengebiete = themengebiet;
	}
	public int getThemengebietid() {
		return themengebietID;
	}
	public void setThemengebietid(int themengebietid) {
		this.themengebietID = themengebietid;
	}
	public String getThemengebiet() {
		return themengebiete;
	}
	public void setThemengebiet(String themengebiet) {
		this.themengebiete = themengebiet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((themengebiete == null) ? 0 : themengebiete.hashCode());
		result = prime * result + themengebietID;
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
		themengebiet other = (themengebiet) obj;
		if (themengebiete == null) {
			if (other.themengebiete != null)
				return false;
		} else if (!themengebiete.equals(other.themengebiete))
			return false;
		if (themengebietID != other.themengebietID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "themengebiet [themengebietid=" + themengebietID + ", themengebiet=" + themengebiete + "]";
	}
}
