import java.sql.*;


public class LoginBean {

	
	String email;
	String password;
	boolean loggedIn;
	
	public LoginBean() {
		this.setLoggedIn(false);
	}
	public String getLoginCheckRedirectHtml(){
		String html = "";
		if (!this.isLoggedIn()){
			html = "<meta http-equiv='refresh' content='0; URL=./OHAppl.jsp'>";
		}
		return html;
	}
	public boolean checkUseridPassword() throws SQLException{
		//true: userid/pw Kombination existiert in der Datenbank
		//false: userid/pw Kombination existiert nicht in der Datenbank
		String sql = "select userid from account where userid = ? and password = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		return dbRes.next();
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
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
}


