package de.hwg_lu.bwi520.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class ArtikelBean {
	

	String aname;
	double preis;
	String beschreibung;
	int anr;
	
	Connection dbConn;
	
	
	public void insertArtikel() throws SQLException{
		String sql = "insert into artikel (aname, preis, beschreibung) values (?,?,?)";
		System.out.println(sql);
	    dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.aname);
		prep.setDouble(2, this.preis);
		prep.setString(3, this.beschreibung);
		prep.executeUpdate();
		System.out.println("Account " + this.aname + " erfolgreich angelegt");
	}

	
	public void getArtikelFromDB() throws NoConnectionException, SQLException{
		String sql = "SELECT anr, aname, preis " +
								"from artikel";
		System.out.println();
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
							prepareStatement(sql).executeQuery();
		while (dbRes.next()){
			/*this.artikelListe.add(
				new Artikel(			
						dbRes.getInt("anr"),
						dbRes.getString("aname"),
						dbRes.getDouble("preis")
				)
			);*/
		}
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
