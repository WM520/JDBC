package day2.datasource.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

// dbcp工具类
public class DBCPUtil {
	private DBCPUtil() {
		
	}
	
	private static Properties p = new Properties();
	private static DataSource datasource;
	static {
		try {
			InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties");
			p.load(inStream);
			datasource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		try {
			return datasource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}
	 }
}
