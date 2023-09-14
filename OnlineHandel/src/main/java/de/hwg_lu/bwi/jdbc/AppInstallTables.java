package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class AppInstallTables {

	Connection dbConn;
	
	public static void main(String[] args) throws SQLException {
		AppInstallTables myApp = new AppInstallTables();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();
	}

	public void doSomething() throws SQLException {
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Kuchen");
		this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Obst");
		this.createTableObst();
		this.createTableKuchen();
		this.insertDataObst();
	}
	public void executeUpdateWithoutParms(String sql) throws SQLException{
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
	}
	public void createTableObst() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE Obst(" + 
				"ObstId   SERIAL       NOT NULL PRIMARY KEY," + 
				"ObstName VARCHAR(128) NOT NULL             " +
			")"
		);		
	}
	public void createTableKuchen() throws SQLException {
		this.executeUpdateWithoutParms(
			"CREATE TABLE Kuchen(" + 
				"KuchenId   SERIAL       NOT NULL PRIMARY KEY," + 
				"Teig       VARCHAR(128) NOT NULL            ," +
				"Obst       VARCHAR(128) NOT NULL             " +
			")"
		);		
	}
	public void insertDataObst() throws SQLException {
		this.executeUpdateWithoutParms(
			"INSERT INTO OBST" + 
			"(ObstName)" + 
			"VALUES" + 
			"('Apfel')," + 
			"('Kirsch')," + 
			"('Mandarinen')," + 
			"('Erdbeer')," + 
			"('Rhabarber')"
		);		
	}
	
}
