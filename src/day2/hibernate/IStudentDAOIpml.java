package day2.hibernate;


import java.util.List;

import com.donghui.smis.dao.IStudentDAO;
import com.donghui.smis.domian.Students;



public class IStudentDAOIpml implements IStudentDAO{
	

	@Override
	public void save(Students stu) throws Exception {
		HibernateMock.save(stu);
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Students stu) throws Exception {
		
	}


	@Override
	public void get(int id) throws Exception {

	}

	@Override
	public void get() throws Exception {
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Students> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
