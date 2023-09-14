
public class ArtikelBean {
	
	String aname;
	double preis;
	String beschreibung;
	
	
	
	public void insertArtikel() throws SQLException{
		String sql = "insert into artikel (anr, aname, preis, beschreibung) values (?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.);
		prep.setString(2, this.aname);
		prep.setInt(3, this.preis);
		prep.setString(4, this.beschreibung);
		prep.executeUpdate();
		System.out.println("Account " + this.aname + " erfolgreich angelegt");
	}

	
	
	


	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	
}
