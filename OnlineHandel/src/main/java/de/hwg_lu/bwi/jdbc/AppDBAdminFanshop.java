package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class AppDBAdminFanshop {

	Connection dbConn;
	
	public static void main(String[] args) throws SQLException {
		AppDBAdminFanshop myApp = new AppDBAdminFanshop();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();
	}

	public void doSomething() throws SQLException {
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Rechnung");
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Bestart");
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Bestellung");
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Artikel");
		this.createTableArtikel();
		this.createTableBestellung();
		this.createTableBestArt();
		this.createTableRechnung();
		this.insertDataArtikel();
	}
	public void executeUpdateWithoutParms(String sql) throws SQLException{
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
	}
	public void createTableArtikel() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE ARTIKEL(" + 
				"ANR      INTEGER      NOT NULL PRIMARY KEY," + 
				"ANAME    VARCHAR(128) NOT NULL            ," + 
				"PREIS    DECIMAL(9,2) NOT NULL" + 
			")"
		);		
	}
	public void createTableBestellung() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE BESTELLUNG(" + 
				"BNR      SERIAL       NOT NULL PRIMARY KEY," + 
				"KUNDE    VARCHAR(128) NOT NULL            ," + 
				"DATUM    DATE         DEFAULT CURRENT_DATE" + 
			")"
		);		
	}
	public void createTableBestArt() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE BESTART(" + 
				"ANR      INTEGER      NOT NULL            ," + 
				"BNR      INTEGER      NOT NULL            ," + 
				"PRIMARY KEY(ANR, BNR)" + 
			")"
		);		
	}
	public void createTableRechnung() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE RECHNUNG(" + 
				"RNR      SERIAL       NOT NULL PRIMARY KEY," + 
				"KUNDE    VARCHAR(128) NOT NULL            ," + 
				"ARTIKEL  TEXT         NOT NULL" + 
			")"
		);		
	}
	public void insertDataArtikel() throws SQLException {
		this.executeUpdateWithoutParms(
			"INSERT INTO ARTIKEL" + 
			"(ANR, ANAME, PREIS)" + 
			"VALUES" + 
			"( 0, 'Power Fan 2720s', 29.80)," + 
			"( 1, 'DFB-Heimtrikot 2010', 70.00)," + 
			"( 2, 'DFB-Torwarttrikot 2010', 75.00)," + 
			"( 3, 'DFB-3Streifen-Cap 2010', 16.00)," + 
			"( 4, 'DFB-Schal Heimtrikot 2010', 18.00)," + 
			"( 5, 'DFB-Polo Trainer 2010', 35.00)," + 
			"( 6, 'DFB-Heimhose 2010', 35.00)," + 
			"( 7, 'DFB-Heimstruempfe 2010', 15.00)," + 
			"( 8, 'DFB-Turnbeutel 2010', 13.00)," + 
			"( 9, 'DFB-Kalender - Unser Team - 2010', 12.95)," + 
			"(10, 'Jabulani Spielball FIFA WM 2010 Sued Afrika ', 109.95)," + 
			"(11, 'Zylinder Hut Fanartikel Deutschland Fuﬂball WM 2010', 9.85)," + 
			"(12, 'Deutschland Fahne', 2.95)," + 
			"(13, 'Autofahne Deutschland', 0.48)," + 
			"(14, 'Schweiﬂband Deutschland', 0.55)," + 
			"(15, 'Stirnband Deutschland', 1.19)," + 
			"(16, 'Cowboyhut Deutschland', 2.39)," + 
			"(17, 'Fanhut deutsche Wikinger', 3.15)," + 
			"(18, 'Boogie Blaster (1000 Stueck)', 1790.00)," + 
			"(19, 'Sitzkissen Deutschland', 3.49)," + 
			"(20, 'Pappnase Deutschland', 11.99)"
		);		
	}
	
}
