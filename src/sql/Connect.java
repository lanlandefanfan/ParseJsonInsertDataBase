package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�������
 */

public class Connect {
	// Connection conn=null;
	// public Connection connectionMySQLDataBase(){
	// String drive="com.mysql.jdbc.Driver";
	// String
	// url="jdbc:mysql://127.0.0.1:3306/weather?useUnicode=true&characterEncoding=utf-8";
	// String username="root";
	// String password="123456";
	//
	// try {
	// Class.forName(drive);
	// conn=DriverManager.getConnection(url, username, password);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// System.out.println("���ݿ�����ʧ��");
	// }
	//
	// return conn;
	// }

	// ��������������ݿ�����
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Data";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";

	private static Connection conn = null;
	// ��̬����飨�������������������ݿ���뾲̬���У�
	static {
		try {
			// 1.������������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2.������ݿ������
			conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �����ṩһ����������ȡ���ݿ�����
	public static Connection getConnection() {
		return conn;
	}
}
