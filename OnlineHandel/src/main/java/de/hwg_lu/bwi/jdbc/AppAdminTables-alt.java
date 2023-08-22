package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppAdminTables {
	//automatisch: public AppAdminTables(){}
	java.sql.Connection jdbcConn;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AppAdminTables applicationObject = new AppAdminTables();
		applicationObject.jdbcConn = new PostgreSQLAccess().getConnection();
		applicationObject.doSomething();
		
	}
	public void doSomething() throws ClassNotFoundException, SQLException{
//		this.createConnection();
//		this.setSchema();
//		this.dropTableAccount();
//		this.createTableAccount();
//		this.insertFirstAccount();
//		this.insertSeveralAccounts();
		this.showAllAccounts();
		
	}
	public void showAllAccounts() throws SQLException{
		String sql = "select userid, password, email, age, active, admin "
				+ "from account";
		System.out.println(sql);
		PreparedStatement prep = this.jdbcConn.prepareStatement(sql);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()){
			String userid   = dbRes.getString("userid");
			String password = dbRes.getString("password");
			String email    = dbRes.getString("email");
			int age         = dbRes.getInt("age");
			String active   = dbRes.getString("active");
			String admin    = dbRes.getString("admin");
			System.out.println(userid + password + email + age + active + admin);
		}
//		dbRes.next();
//		dbRes.next();
//		String newEMail = dbRes.getString("email");
	
		
		
		
		
	}
	public void insertAccountInsecure() throws SQLException{
		//diese Variante is unsicher (SQL Injection) --> Niemals!!! verwenden!
		//bitte immer PreparedStatements verwenden
		String userid = "testus6";
		String password = "geheim";
		String sql = "insert into account (userid) values ('" + userid + "', '" + password + "')";
		System.out.println(sql);
		this.jdbcConn.prepareStatement(sql).execute();
		System.out.println("testus6 angelegt");
	}
	public void insertSeveralAccounts() throws SQLException{
		String sql = "insert into account (userid, password, email, age, active, admin) "
				+ "values (?,?,?,?,'Y','N')";
		System.out.println(sql);
		PreparedStatement prep = this.jdbcConn.prepareStatement(sql);
		
		for (int index = 2; index <= 5; index++){
			prep.setString(1, "testus" + index);
			prep.setString(2, "geheim");
			prep.setString(3, "testus" + index + "@abc.de");
			prep.setInt(4, 17 + index);
			prep.executeUpdate();
		}
		System.out.println("testus2 - testus5 angelegt");
	}

	public void insertFirstAccount() throws SQLException{
		String sql = "insert into account (userid, password, email, age, active, admin) "
					+ "values (?,?,?,?,'Y','N')";
		System.out.println(sql);
		PreparedStatement prep = this.jdbcConn.prepareStatement(sql);
		prep.setString(1, "testus1");
		prep.setString(2, "geheim");
		prep.setString(3, "testus1@abc.de");
		prep.setInt(4, 17);
		prep.executeUpdate();
		System.out.println("Account testus1 angelegt");
	}
	public void dropTableAccount() throws SQLException{
		String sql = "drop table if exists account";
		System.out.println(sql);
		PreparedStatement prep = this.jdbcConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Table account gedropped");
	}
	public void createTableAccount() throws SQLException{
		String sql = "create table account("
					+ "userid   char(16)     not null primary key  ,"
					+ "password char(32)     not null              ,"
					+ "email    varchar(256) not null default ''   ,"
					+ "age      int          not null default 0    ,"
					+ "active   char(1)      not null default 'Y'  ,"
					+ "admin    char(1)      not null default 'N'"
					+ ")";
		System.out.println(sql);
		//JDBC -> Statement-Objekt -> excecute
		PreparedStatement prep = this.jdbcConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Table account angelegt");
/*
create table account(
   userid   char(16)     not null primary key  ,
   password char(32)     not null              ,
   email    varchar(256) not null default ''   ,
   age      int          not null default 0    ,
   active   char(1)      not null default 'Y'  ,
   admin    char(1)      not null default 'N'
)
 */
	}
	
	public void setSchema() throws SQLException{
		String sql = "set schema 'bwi420_6*****'";
		System.out.println(sql);
		//JDBC
		//Connection -> Statement-Objekt -> execute
		this.jdbcConn.prepareStatement(sql).execute();
		System.out.println("Schema gesetzt");
	}
//	public void createConnection() throws ClassNotFoundException, SQLException{
//		System.out.println("Hello JDBC");
//		Class.forName("org.postgresql.Driver");
//		System.out.println("Treiber geladen");
//		this.jdbcConn = DriverManager.getConnection(
//				"jdbc:postgresql://143.93.200.243:5432/BWUEBDB",
//				"user1",
//				"pgusers"
//		);
//		System.out.println("JDBC Connection hergestellt");
//	}
}
