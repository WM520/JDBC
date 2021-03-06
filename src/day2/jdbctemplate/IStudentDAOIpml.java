package day2.jdbctemplate;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.donghui.smis.dao.IStudentDAO;
import com.donghui.smis.domian.Students;
import com.donghui.smis.util.JdbcUtil;


public class IStudentDAOIpml implements IStudentDAO{
	
	
	private Connection conn;
	private Statement st;
//	private PreparedStatement pt;
	private ResultSet rs;

	@Override
	public void save(Students stu) throws Exception {
		// TODO Auto-generated method stub
//		try {
//			StringBuilder sd = new StringBuilder(80);
//			sd.append("insert into login(user, password) values(");
//			sd.append("'").append(stu.getName()).append("'").append(",");
//			sd.append("'").append(stu.getAge()).append("'");
//			sd.append(")");
//			System.out.println(sd.toString());
//			conn = JdbcUtil.getConn();
//			st = (Statement) conn.createStatement();
//			st.executeUpdate(sd.toString());
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(conn, st, rs);
//		}
		
		String sql = "insert into login(user,password) values (?, ?)";
		Object[] params = {stu.getAge(), stu.getName()};
		JdbcTemplate.update(sql, params);
}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from login where id =" + id;
			conn = JdbcUtil.getConn();
			st = (Statement)conn.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
	}

	@Override
	public void update(Students stu) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update login set user=? where user=?" ;
//		conn = JdbcUtil.getConn();
//		pt = (PreparedStatement) conn.prepareStatement(sql);
//		pt.setString(1,"wangmiao");
//		pt.setString(2,stu.getName());
//		pt.executeUpdate();
		Object[] params = {stu.getAge(), stu.getName()};
		JdbcTemplate.update(sql, params);
	}

	@Override
	public List<Students> queryList() throws Exception {
		// TODO Auto-generated method stub
		List<Students> list = new ArrayList<>();
		return list;
	}

	@Override
	public void get(int id) throws Exception {
		// TODO Auto-generated method stub
//		try {
//			conn = JdbcUtil2.getConn();
//			String sql = "select *from login where id = " + id;
//			st = (Statement) conn.createStatement();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				Students stu = new Students();
//				Long aid = rs.getLong("id");
//				String name = rs.getString("user");
//				String age = rs.getString("password");
//				stu.setAge(age);
//				stu.setId(aid);
//				stu.setName(name);
//				System.out.println(stu);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(conn, st, rs);
//			
//		}
		String sql = "select * from login where id = ?";
		JdbcTemplate.query(sql, new StudentResultSetHandler<>(), id);
	}

	@Override
	public void get() throws Exception {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConn();
			String sql = "select *from login";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Students stu = new Students();
				Long aid = rs.getLong("id");
				String name = rs.getString("user");
				String age = rs.getString("password");
				stu.setAge(age);
				stu.setId(aid);
				stu.setName(name);
				System.out.println(stu);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, st, rs);
		}
	}
	
	class StudentResultSetHandler<T> implements IResultSetHandler<day2.jdbctemplate.Students> {

		@Override
		public List<day2.jdbctemplate.Students> handle(ResultSet rs) throws Exception {
			// TODO Auto-generated method stub
			List<day2.jdbctemplate.Students> list = new ArrayList<>();
			while(rs.next()) {
				day2.jdbctemplate.Students stu = new day2.jdbctemplate.Students();
				list.add(stu);
				Long id = rs.getLong("id");
				String name = rs.getString("user");
				stu.setId(id);
				stu.setName(name);
			}
			return list;
		}
		
	}

}
