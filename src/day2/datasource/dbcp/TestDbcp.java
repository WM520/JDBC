package day2.datasource.dbcp;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import com.donghui.smis.util.JdbcUtil;



// 测试DBCP
public class TestDbcp {
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/login");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setMaxTotal(10);
		return ds;
	}
	
	@Test
	public void testQuery() throws Exception {
		
		String sql = "select * from login";
		Connection conn = getDataSource().getConnection();
		System.out.println(conn);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String password = rs.getString(3);
			System.out.println(id + "\t" + name + "\t" + password + "\t");
		}
		
		JdbcUtil.close(conn, ps, rs);
	}
	
}
