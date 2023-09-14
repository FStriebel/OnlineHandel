
import java.sql.Connection;

public class RegBean {

	String benutzername;
	String vorname;
	String nachname;
	String email;
	String password;
	
	
//	int age;
	
	
	Connection dbConn;
	
	public void AccountBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	public void initialize() {
		this.benutzername = "";
		this.email = "";
		this.password = "";
	//	this.age = 0;
		this.vorname = "";
		this.nachname = "";
		
	}
	public String getAgeForHtmlView(){
		if (this.age == 0) return "";
		//else return "" + this.age;
		else return Integer.toString(this.age);
	}
	public MessageBean checkAccountData(){
		//null: alle Daten ok
		//gef�llte MessageBean: nicht alle Daten ok
		if (this.benutzername.length() > 32){
			MessageBean newMessageBean = new MessageBean();
			newMessageBean.setUseridTooLong();
			return newMessageBean;
		}else if(this.password.length() > 32){
			MessageBean newMessageBean = new MessageBean();
			newMessageBean.setPasswordTooLong();
			return newMessageBean;
		}else if(this.password.length() == 0){
			MessageBean newMessageBean = new MessageBean();
			newMessageBean.setPasswordEmpty();
			return newMessageBean;
		}else{//alles gut
			return null;
		}
	}
	public boolean checkAccountExists() throws SQLException{
		//true - Account existiert bereits - In account-table kommt ein Datensatz mit this.userid vor
		//false - Account existiert noch nicht - In account-table kommt this.userid nicht vor
		String sql = "select userid from account where userid = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.userid);
		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = dbRes.next();
		return gefunden;
	}
	public boolean checkAccountExists2() throws SQLException{
		//true - Account existiert bereits - In account-table kommt ein Datensatz mit this.userid vor
		//false - Account existiert noch nicht - In account-table kommt this.userid nicht vor
		String sql = "select count(*) from account where benutzername = ?";
		System.out.println(sql);
//		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.benutzername);
		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = dbRes.next(); //gefunden ist true
		int anzahl = dbRes.getInt(1); // anzahl ist 0 oder 1
		return (anzahl == 1);
//		if (anzahl == 1) return true; else return false;
//		return (anzahl == 1)?true:false;
	}
	public boolean insertAccountIfNotExists() throws SQLException{
		//true: userid wurde angelegt
		//false: userid war schon da, kein insert gemacht
		boolean accountAlreadyExists = this.checkAccountExists();
		if (accountAlreadyExists){
			return false;
		}else{
			this.insertAccountNoCheck();
			return true;
		}
	}
	public void insertAccountNoCheck() throws SQLException{
		String sql = "insert into account (userid, password, age, email, active, admin) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.userid);
		prep.setString(2, this.password);
		prep.setInt(3, this.age);
		prep.setString(4, this.email);
		prep.setString(5, this.active);
		prep.setString(6, this.admin);
		prep.executeUpdate();
		System.out.println("Account " + this.userid + " erfolgreich angelegt");
	}
	
	
	
	@Override
	public String toString() {
		return "AccountBean [userid=" + userid + ", password=" + password + ", age=" + age + ", email=" + email
				+ ", active=" + active + ", admin=" + admin + "]";
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
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
	
	
	
}