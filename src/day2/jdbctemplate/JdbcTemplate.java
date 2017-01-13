package day2.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.donghui.smis.util.JdbcUtil;

public class JdbcTemplate {
	private JdbcTemplate(){}
	
	// DML模板
	public static int update(String sql, Object ...params) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
		return 0;
	}
	
	// DQL模板
	@SuppressWarnings("unchecked")
	public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... params)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			return  (T) rsh.handle(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
}
