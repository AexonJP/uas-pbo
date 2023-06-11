public abstract class akun{
	protected final Integer id;
	protected final String user;
    protected final String pass;
    public akun(Integer id,String user,String pass){
    	this.id = id;
    	this.user = user;
    	this.pass = pass;
    }
    // Connection connection = null;
    // try {
    //     // below two lines are used for connectivity.
    //     Class.forName("com.mysql.cj.jdbc.Driver");
    //     connection = DriverManager.getConnection(
    //             "jdbc:mysql://localhost:3306/dbApotekSamarinda",
    //             "root", "");

    //     // mydb is database
    //     // mydbuser is name of database
    //     // mydbuser is password of database

    //     Statement statement;
    //     statement = connection.createStatement();
    //     ResultSet resultSet;
    //     resultSet = statement.executeQuery(
    //             "SELECT * FROM tbAkun");
    //     Integer code;
    //     String username;
    //     String password;


    //     while (resultSet.next()) {
    //         code = resultSet.getInt("idAkun");
    //         username = resultSet.getString("username").trim();
    //         password = resultSet.getString("password").trim();
    //         dataAkun.add(code,username,password)
    //     }
    //     resultSet.close();
    //     statement.close();
    //     connection.close();
    // } catch (Exception exception) {
    //     System.out.println(exception);
    // }


    public String getNama(){
    	return user;
    }
    public String getPass(){
    	return pass;
    }
}