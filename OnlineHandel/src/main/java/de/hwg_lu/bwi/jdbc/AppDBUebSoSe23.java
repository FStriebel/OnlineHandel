package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppDBUebSoSe23 {

	Connection dbConn;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AppDBUebSoSe23 myAppObj = new AppDBUebSoSe23();

		myAppObj.dbConn = new PostgreSQLAccess().getConnection();
		
		myAppObj.doSomething();
	}
	
	public void doSomething() throws ClassNotFoundException, SQLException{
		System.out.println("doSomething() gestartet");
//		this.dropSchema();
//		this.createSchema();
//		this.setSchema();
		this.dropTableWebapplication();
		this.createTableWebapplication();
		this.insertWebapplications();

	}
	public void insertWebapplications() throws SQLException{
		String sql = "insert into webapplication (applPath, applName) values "
				+ "('selectMultiple.jsp'     , 'Eis essen mit http-Parametern und -Headern'),"
				+ "('ShowDate.jsp'           , 'Aktuelles Datum anzeigen')                  ,"
				+ "('Urlaub1View.jsp'        , 'Urlaubsziele')                              ,"
				+ "('ShowAllAccountsView.jsp', 'Accounts verwalten')                        ;";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("webapplications erfolgreich eingefuegt");
	}
	public void dropTableWebapplication() throws SQLException{
		String sql = "drop table if exists webapplication";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Table webapplication gedropped");
	}
	
	public void createTableWebapplication() throws SQLException{
		String sql = "create table webapplication  "
				+ "(applPath varchar(64)  not null primary key     ,"
				+ " applName varchar(64)  not null                 );";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Table Webapplication angelegt");
	}
	
	
}
