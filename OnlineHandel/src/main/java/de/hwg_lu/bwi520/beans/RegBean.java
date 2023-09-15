package de.hwg_lu.bwi520.beans;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class RegBean {

	String userid;
	String vorname;
	String nachname;
	String email;
	String password;
	int age;
	
	
	
	Connection dbConn;
	
	public void AccountBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	public void initialize() {
		this.userid = "";
		this.email = "";
		this.password = "";
		this.age = 0;
		this.vorname = "";
		this.nachname = "";
		
	}
	public String getAgeForHtmlView(){
		if (this.age == 0) return "";
		//else return "" + this.age;
		else return Integer.toString(this.age);
	}
//	public MessageBean checkAccountData(){
//		//null: alle Daten ok
//		//gef�llte MessageBean: nicht alle Daten ok
//		if (this.benutzername.length() > 32){
//			MessageBean newMessageBean = new MessageBean();
//			newMessageBean.setUseridTooLong();
//			return newMessageBean;
//		}else if(this.password.length() > 32){
//			MessageBean newMessageBean = new MessageBean();
//			newMessageBean.setPasswordTooLong();
//			return newMessageBean;
//		}else if(this.password.length() == 0){
//			MessageBean newMessageBean = new MessageBean();
//			newMessageBean.setPasswordEmpty();
//			return newMessageBean;
//		}else{//alles gut
//			return null;
//		}
//	}
	public boolean checkAccountExists() throws SQLException{
		//true - Account existiert bereits - In account-table kommt ein Datensatz mit this.userid vor
		//false - Account existiert noch nicht - In account-table kommt this.userid nicht vor
		String sql = "select userid from account where userid = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.userid);
		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = dbRes.next();
		return gefunden;
	}

	public boolean insertAccountIfNotExists() throws SQLException{
		//true: userid wurde angelegt
		//false: userid war schon da, kein insert gemacht
		boolean accountAlreadyExists = this.checkAccountExists();
		if (accountAlreadyExists){
			System.out.println(false);
			return false;
		}else{
			this.insertAccountNoCheck();
			System.out.println(true);
			return true;
		}
	}
	public void insertAccountNoCheck() throws SQLException{
		String sql = "insert into account (userid, password, age, email, vorname, nachname) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.userid);
		prep.setString(2, this.password);
		prep.setInt(3, this.age);
		prep.setString(4, this.email);
		prep.setString(5, this.vorname);
		prep.setString(6, this.nachname);
		prep.executeUpdate();
		System.out.println("Account " + this.userid + " erfolgreich angelegt");
	}
	
	public void checkData() {
		
	}
	
	@Override
	public String toString() {
		return "AccountBean [userid=" + userid + ", password=" + password + ", vorname=" + vorname + ", nachname=" + nachname + ", age=" + age + ", email=" + email;
	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connection getDbConn() {
		return dbConn;
	}
	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}