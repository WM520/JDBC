package day2.blob;



import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import org.junit.Test;

import com.donghui.smis.util.JdbcUtil;

public class BlobTest {
	// 存储
	@Test
	public void testBlobTest() throws Exception {
		String sql = "insert into l_image (headImg) values (?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
//		ps.setInt(1, 1);;
		ps.setBlob(1, new FileInputStream("/Users/zhangguodong/Desktop/1.png"));
		ps.executeUpdate();
		JdbcUtil.close(conn, ps, null);
	}
	
	@Test
	public void testBlobRead() throws Exception {
		String sql = "select * from l_image where id = ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, 4);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			Blob image = (Blob) rs.getBlob("headImg");
			InputStream in = image.getBinaryStream();
			Files.copy(in,Paths.get("/Users/zhangguodong/Desktop/3.png"));
		}
		
		JdbcUtil.close(conn, ps, rs);
	}
	
	
}
