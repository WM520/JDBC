package day2.returnpk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.donghui.smis.util.JdbcUtil;


// 自动获取生成主键
public class ReturnPKTest {
	@Test
	public void testStatement() throws Exception {
		
		String sql = "Insert into l_image(headImg) values ('wangmiao')";
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		JdbcUtil.close(conn, st, rs);
	}
	
	@Test
	public void testPreparedStatement() throws Exception {
		String sql = "Insert into l_image(headImg) values (?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "yinting");
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			System.out.println(id);
		}
		JdbcUtil.close(conn, ps, rs);
		
		
	}
}
