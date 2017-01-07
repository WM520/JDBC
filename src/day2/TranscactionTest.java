package day2;

import java.sql.ResultSet;

import org.junit.Test;

import com.donghui.smis.util.JdbcUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TranscactionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	@Test
	public void testName() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConn();
//			String sql = 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
