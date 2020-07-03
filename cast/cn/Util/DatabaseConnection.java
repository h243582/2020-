package cn.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC���ݿ����ӹ�����
 * @author ���ŷ�
 *
 */
public class DatabaseConnection {
	//oracle.jdbc.driver.OracleDriver
	//jdbc:oracle:thin:@localhost:1521:MLDN
	private Connection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;
	/**
	 * ���췽������Connection����
	 */
	public DatabaseConnection() {
		try {
			Class.forName(Constant.DBDRIVER);
			this.conn = DriverManager.getConnection(Constant.DBURL,Constant.DBUSER,Constant.PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * 
	 * @return ʵ������Connection����������null�����ʾû���ӳɹ�
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void close() {
		if(stat!= null) {
			try {
				stat.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		if(rs!= null) {
			try {
				rs.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		if(conn!= null) {
			try {
				conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	}
}