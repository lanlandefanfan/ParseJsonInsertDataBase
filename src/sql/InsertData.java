package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 向数据库插入和更新数据
 */

public class InsertData {
	Connect cd;
	Connection conn;

	public InsertData() {
		cd = new Connect();
		conn = cd.getConnection();
	}

	public int add(String datetime, Double value) {
		// mysql的语句
		String mysql = "INSERT into weather (datetime,value) VALUES (?,?)" + "ON DUPLICATE KEY UPDATE  value =?";
		// sqlserver的语句
		String sqlserver = "if not exists (select datetime from weather where datetime= ?)"
				+ "insert into weather (datetime,value) values(?,?) " + "else update weather set value=?"
				+ " where datetime = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sqlserver);
			ps.setString(1, datetime);
			ps.setString(2, datetime);
			ps.setDouble(3, value);
			ps.setDouble(4, value);
			ps.setString(5, datetime);
			int n = ps.executeUpdate();
			return n;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

}
