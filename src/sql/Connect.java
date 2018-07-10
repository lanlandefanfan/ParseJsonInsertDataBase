package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
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
	// System.out.println("数据库连接失败");
	// }
	//
	// return conn;
	// }

	// 这里可以设置数据库名称
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Data";
	private static final String USER = "sa";
	private static final String PASSWORD = "123456";

	private static Connection conn = null;
	// 静态代码块（将加载驱动、连接数据库放入静态块中）
	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 2.获得数据库的连接
			conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 对外提供一个方法来获取数据库连接
	public static Connection getConnection() {
		return conn;
	}
}
