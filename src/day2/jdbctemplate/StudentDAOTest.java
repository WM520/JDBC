package day2.jdbctemplate;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.donghui.smis.dao.IStudentDAO;
import com.donghui.smis.dao.impl.IStudentDAOIpml;
import com.donghui.smis.domian.Students;

public class StudentDAOTest {

	private IStudentDAO dao = null;
	
	
	@Before
	public void init() throws Exception 
	{
		dao = new IStudentDAOIpml();
	}
	
	@Test
	public void testSave() throws Exception {
		Students stu = new Students("yuzhenmiao", "43");
		dao.save(stu);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(10);
	}

	@Test
	public void testUpdate() throws Exception {
		Students stu = new Students("daxiao", "43");
		dao.update(stu);
	}

	@Test
	public void testGet() throws Exception {
		dao.get();
	}
	
	@Test
	public void testGetSomeOne() throws Exception
	{
		dao.get(5);
	}
	
	

	@Test
	public void testQueryList() throws Exception {
		List<Students> list = dao.queryList();
		for (Students students : list) {
			System.out.println(students);
		}
	}

}
